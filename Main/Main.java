package Main;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;
import Database.데이터베이스_어댑터;
import Factory.팩토리;
import System.게임상태관리;
import System.로그인관리;
import System.시뮬레이션게임;

/**
 * 
 */
public class Main {

    /**
     * Default constructor
     */
	static Scanner scanner = new Scanner(System.in);
    static Connection conn = null;
    
    public static void main(String[] args) {
    	데이터베이스_어댑터 어댑터객체 = new 데이터베이스_어댑터();
    	팩토리 팩토리객체 = new 팩토리();
    	사용자 사용자객체 = (사용자) 팩토리객체.객체생성("사용자");
    	AI캐릭터 AI캐릭터객체 = (AI캐릭터) 팩토리객체.객체생성("AI캐릭터");
    	생성형AI 생성형AI객체 = (생성형AI) 팩토리객체.객체생성("생성형AI");
    	게임상태관리 게임상태관리객체 = (게임상태관리) 팩토리객체.객체생성("게임상태관리");
    	로그인관리 로그인관리객체 = (로그인관리) 팩토리객체.객체생성("로그인관리");
    	시뮬레이션게임 시뮬레이션객체 = (시뮬레이션게임) 팩토리객체.객체생성("시뮬레이션");
    	
    	
    	if (conn != null) {
    		어댑터객체.데이터베이스연결();
            System.out.println("DB 연결 성공");

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
                        	String 성격테스트결과 = 사용자객체.성격테스트();
                            
                            로그인관리객체.사용자회원가입(어댑터객체, 사용자객체.ID, 사용자객체.비밀번호, 성격테스트결과);

                            // 3-2. 성격 테스트 실행
                            

                            // 3-3. AI 캐릭터 불러오기
                            AI캐릭터객체 = 게임상태관리객체.AI캐릭터_불러오기(어댑터객체, 성격테스트결과,팩토리객체);

                            // 3-4. 게임 상태 저장
                            게임상태관리객체.게임상태저장(어댑터객체, 사용자객체.ID, AI캐릭터객체);
                            System.out.println("회원가입이 완료. 로그인 창으로 돌아갑니다.");
                            break;

                        case 2: // 4. 로그인
                            로그인관리객체.사용자로그인(어댑터객체, 사용자객체.ID, 사용자객체.비밀번호, 팩토리객체);

                            // 4-1. 게임 상태 로드
                            게임상태관리객체.게임상태로드(어댑터객체, 사용자객체.ID, AI캐릭터객체, 팩토리객체);
                            System.out.println("로그인 성공 게임이 로드되었습니다.");
                            break;

                        case 3: // 종료
                            System.out.println("프로그램을 종료합니다.");
                            scanner.close();
                            return;

                        default:
                            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                    }

                    // 5. 실시간 채팅 시작
                    시뮬레이션객체.실시간채팅(사용자객체, AI캐릭터객체, 팩토리객체);
                    시뮬레이션객체.엔딩결정(AI캐릭터객체);
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

}