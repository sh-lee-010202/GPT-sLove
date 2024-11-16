package System;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;
import Actor.성격테스트;
import Database.데이터베이스_어댑터;
import Factory.팩토리_인터페이스;

/**
 * 
 */
public class 시뮬레이션게임 {
	Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor
     */
    public 시뮬레이션게임() {
    }

    /**
     * @param 호감도계산객체 
     * @param 사용자객체 
     * @param AI캐릭터객체 
     * @return
     */
    public int 호감도계산메소드(호감도계산 호감도계산객체, 사용자 사용자객체, AI캐릭터 AI캐릭터객체) {
        // TODO implement here
        return 0;
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
     * @param id 
     * @param AI캐릭터객체 
     * @return
     * @throws SQLException 
     */
    public void 실시간채팅(사용자 사용자객체, AI캐릭터 AI캐릭터객체, 팩토리_인터페이스 팩토리인터페이스객체) throws SQLException {
        // TODO implement here
    	호감도계산 호감도계산객체 = (호감도계산) 팩토리인터페이스객체.객체생성("호감도계산");
        boolean isChatting = true;
        String userInput;
        String aiResponse;

        // AI 캐릭터의 첫 응답
        생성형AI 생성형AI객체 = (생성형AI) 팩토리인터페이스객체.객체생성("생성형AI");
        
        데이터베이스_어댑터 어댑터객체 = (데이터베이스_어댑터) 팩토리인터페이스객체.객체생성("DB");
        게임상태관리 게임상태관리객체 = (게임상태관리) 팩토리인터페이스객체.객체생성("게임상태관리");

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
                            게임상태관리객체.게임상태저장(어댑터객체, 사용자객체.ID, AI캐릭터객체);
                            System.out.println("게임 상태가 저장되었습니다.");
                            break;
                        case 2:
                            게임상태관리객체.게임상태로드(어댑터객체, 사용자객체.ID, AI캐릭터객체, 팩토리인터페이스객체);
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
            int 호감도변화값 = 호감도계산객체.호감도반환(userInput, AI캐릭터객체.get좋아하는단어(), AI캐릭터객체.get싫어하는단어());
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

    /**
     * @param 성격테스트객체 
     * @return
     */
    public String 성격테스트_진행(성격테스트 성격테스트객체) {
        // TODO implement here
        return 성격테스트객체.성격테스트(); 
    }

}