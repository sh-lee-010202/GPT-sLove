package Main;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;
import Actor.신규_사용자;
import Database.데이터베이스_어댑터;
import Database.로드;
import Database.수정;
import Database.저장;
import Factory.팩토리;
/**
 * 
 */
public class 시뮬레이션게임 {

    private static final String URL = null;

	/**
     * Default constructor
     */
    public 시뮬레이션게임() {
        this.어댑터객체 = new 데이터베이스_어댑터();
        this.팩토리객체 = new 팩토리();
    }


    
    static Scanner scanner = new Scanner(System.in);
    static Connection conn = null;
    /**
     * 
     */
    private 데이터베이스_어댑터 어댑터객체;
    
    /**
     * 
     */
    private 팩토리 팩토리객체;
    
    public static void main(String[] args) {
    	시뮬레이션게임 메인객체 = new 시뮬레이션게임();
    	데이터베이스_어댑터 어댑터객체 = new 데이터베이스_어댑터();
    	팩토리 팩토리객체 = new 팩토리();
    	사용자 사용자객체 = (사용자) 팩토리객체.객체생성("사용자");
    	AI캐릭터 AI캐릭터객체 = (AI캐릭터) 팩토리객체.객체생성("AI캐릭터");
    	생성형AI 생성형AI객체 = (생성형AI) 팩토리객체.객체생성("생성형AI");
    	
    	메인객체.초기_데이터베이스연결();
    	if (메인객체.conn != null) {
            System.out.println("DB 연결 성공!");

            try {
                while (true) {
                    // 2. 메뉴 표시
                    System.out.println("========= 메뉴 =========");
                    System.out.println("1. 회원가입");
                    System.out.println("2. 로그인");
                    System.out.println("3. 종료");
                    System.out.print("선택: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // 입력 버퍼 비우기

                    switch (choice) {
                        case 1: // 3-1. 회원가입
                            신규_사용자 신규_사용자객체 = (신규_사용자) 팩토리객체.객체생성("신규_사용자");
                            메인객체.사용자회원가입(어댑터객체, 신규_사용자객체);

                            // 3-2. 성격 테스트 실행
                            String 성격테스트결과 = 신규_사용자객체.성격테스트();

                            // 3-3. AI 캐릭터 불러오기
                            메인객체.AI캐릭터_불러오기(어댑터객체, 성격테스트결과, AI캐릭터객체);

                            // 3-4. 게임 상태 저장
                            메인객체.게임상태저장(어댑터객체, 사용자객체, AI캐릭터객체);
                            System.out.println("회원가입이 완료되었습니다. 로그인 창으로 돌아갑니다.");
                            break;

                        case 2: // 4. 로그인
                            메인객체.사용자로그인(어댑터객체, 사용자객체);

                            // 4-1. 게임 상태 로드
                            메인객체.게임상태로드(어댑터객체, 사용자객체, AI캐릭터객체);
                            System.out.println("로그인 성공! 게임이 로드되었습니다.");
                            break;

                        case 3: // 종료
                            System.out.println("프로그램을 종료합니다.");
                            scanner.close();
                            return;

                        default:
                            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                    }

                    // 5. 실시간 채팅 시작
                    메인객체.실시간채팅(사용자객체, 생성형AI객체, AI캐릭터객체);
                    메인객체.엔딩결정(AI캐릭터객체);
                    //게임종료
                    return;
                }
            } catch (SQLException e) {
                System.err.println("SQL 오류: " + e.getMessage());
            }
        } else {
            System.out.println("DB 연결 실패. 프로그램을 종료합니다.");
        }
    	
    }
    
    /**
     * 
     */
    public void 초기_데이터베이스연결() {
        // TODO implement here
    	conn = 어댑터객체.데이터베이스연결();
    }
    

    /**
     * @param 저장객체 
     * @param 신규_사용자객체
     * @throws SQLException 
     */
    public void 사용자회원가입(저장 저장객체, 신규_사용자 신규_사용자객체) throws SQLException {
        // TODO implement here
    	String query = 신규_사용자객체.ID+""+신규_사용자객체.비밀번호;
    	저장객체.데이터_저장(query);
    }

    /**
     * @param 로드객체 
     * @param 사용자객체
     * @throws SQLException 
     */
    public void 사용자로그인(로드 로드객체, 사용자 사용자객체) throws SQLException {
        // TODO implement here
        System.out.print("ID 입력: ");
        String userId = scanner.nextLine();

        // 신규 사용자 비밀번호 입력
        System.out.print("비밀번호 입력: ");
        String password = scanner.nextLine();
        

        // 사용자 객체 생성 및 로드 객체 사용
        
        사용자객체 = (사용자) 로드객체.데이터_로드(userId, "사용자", 팩토리객체); // 쿼리문 userid -> 조회

        // 데이터베이스 연결
        if (사용자객체 != null) {
        	try {
                if (conn != null) {
                   
                // 사용자 계정으로 새 연결 생성
                this.conn = DriverManager.getConnection(URL, 사용자객체.ID, 사용자객체.비밀번호);
                }
                
            } catch (SQLException e) {
                //로그인 실패
            }
            //로그인 성공
        } else {
            //사용자 정보 조회 실패
        }
    }


    /**
     * @param 로드객체 
     * @param 캐릭터ID 
     * @param 생성형AI객체
     * @return 
     * @throws SQLException 
     */
    public void AI캐릭터_불러오기(로드 로드객체, String 캐릭터ID, AI캐릭터 AI캐릭터객체) throws SQLException {
        // TODO implement here
    	AI캐릭터객체 = (AI캐릭터) 로드객체.데이터_로드(캐릭터ID, "AI캐릭터", 팩토리객체); // 쿼리문 캐릭터ID -> 조회
    }

    /**
     * @param 수정객체 
     * @param 사용자객체 
     * @param AI캐릭터객체
     * @throws SQLException 
     */
    public void 게임상태저장(수정 수정객체, 사용자 사용자객체, AI캐릭터 AI캐릭터객체) throws SQLException {
        // TODO implement here
    	String query = 사용자객체.ID+""+사용자객체.비밀번호+""+AI캐릭터객체.get캐릭터ID(); //임시쿼리
    	수정객체.데이터_수정(query);
    }

    /**
     * @param 로드객체 
     * @param 사용자객체
     * @throws SQLException 
     */
    public void 게임상태로드(로드 로드객체, 사용자 사용자객체, AI캐릭터 AI캐릭터객체) throws SQLException {
        // TODO implement here
    	사용자객체 = (사용자) 로드객체.데이터_로드(사용자객체.ID, "사용자", 팩토리객체); // 쿼리문 userid -> 조회
    	AI캐릭터객체 = (AI캐릭터) 로드객체.데이터_로드(AI캐릭터객체.get캐릭터ID(), "AI캐릭터", 팩토리객체); // 쿼리문 캐릭터ID -> 조회
    }

    /**
     * @param AI캐릭터객체 
     * @return
     */
    public String 엔딩결정(AI캐릭터 AI캐릭터객체) {
        // TODO implement here
    	if (AI캐릭터객체.get호감도() >= 50) {
            return AI캐릭터객체.get해피엔딩();
         } else {
             return AI캐릭터객체.get배드엔딩();
         }
    }

    /**
     * @param 사용자객체 
     * @param 생성형AI객체
     * @throws SQLException 
     */
    public void 실시간채팅(사용자 사용자객체, 생성형AI 생성형AI객체, AI캐릭터 AI캐릭터객체) throws SQLException {
        // TODO implement here
    	호감도계산 호감도계산객체 = (호감도계산) 팩토리객체.객체생성("호감도계산");
        boolean isChatting = true;
        String userInput;
        String aiResponse;

        // AI 캐릭터의 첫 응답
        생성형AI객체.프롬프트초기화(AI캐릭터객체);

        // 채팅 루프
        while (isChatting) {
            System.out.print("사용자: ");
            userInput = scanner.nextLine();

            // 채팅 종료 명령
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("채팅을 종료합니다.");
                isChatting = false;
                break;
            }

            // 설정 메뉴 명령
            if (userInput.equalsIgnoreCase("설정")) {
                boolean isInSettings = true;

                while (isInSettings) {
                    System.out.println("===== 설정 메뉴 =====");
                    System.out.println("1. 게임 상태 저장");
                    System.out.println("2. 게임 상태 로드");
                    System.out.println("3. 설정 메뉴 종료");
                    System.out.print("선택: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // 입력 버퍼 비우기

                    switch (choice) {
                        case 1:
                            게임상태저장(어댑터객체, 사용자객체, AI캐릭터객체);
                            System.out.println("게임 상태가 저장되었습니다.");
                            break;
                        case 2:
                            게임상태로드(어댑터객체, 사용자객체, AI캐릭터객체);
                            System.out.println("게임 상태가 로드되었습니다.");
                            break;
                        case 3:
                            System.out.println("설정 메뉴를 종료합니다. 채팅으로 돌아갑니다.");
                            isInSettings = false;
                            break;
                        default:
                            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                            break;
                    }
                }

                // 설정 메뉴에서 돌아오면 채팅을 계속 진행
                continue;
            }

            // 호감도 계산
            int 호감도변화값 = 호감도계산객체.호감도반환(userInput, AI캐릭터객체);
            AI캐릭터객체.호감도적용(호감도변화값);

            // AI 응답 생성
            aiResponse = 생성형AI객체.AI응답받기(userInput, AI캐릭터객체.get호감도());
            System.out.println("AI: " + aiResponse);

            // 호감도 변화 출력
            if (호감도변화값 > 0) {
                //호감도상승
            } else if (호감도변화값 < 0) {
                //호감도하락
            }
        }
    }

}