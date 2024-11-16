package System;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import Actor.사용자;
import Database.로드;
import Database.저장;
import Factory.팩토리_인터페이스;
import Main.Main;

/**
 * 
 */
public class 로그인관리 {

	/**
     * Default constructor
     */
    public 로그인관리() {
    }
    Scanner scanner;

    /**
     * @param 저장객체 
     * @param id 
     * @param pw 
     * @param 객체 
     * @return
     * @throws SQLException 
     */
    public void 사용자회원가입(저장 저장객체, String id, String pw, String 성격테스트) throws SQLException {
        // TODO implement here
    	String query = id+pw+성격테스트;
    	저장객체.데이터_저장(query);
    }

    /**
     * @param 로드객체 
     * @param id 
     * @param pw 
     * @return
     * @throws SQLException 
     */
    public Object 사용자로그인(로드 로드객체, String id, String pw, 팩토리_인터페이스 팩토리인터페이스객체) throws SQLException {
        // TODO implement here
    	System.out.print("ID 입력: ");
        String userId = scanner.nextLine();

        // 신규 사용자 비밀번호 입력
        System.out.print("비밀번호 입력: ");
        String password = scanner.nextLine();
        
        사용자 사용자객체 = (사용자) 팩토리인터페이스객체.객체생성("사용자");
        사용자객체 = (사용자) 로드객체.데이터_로드(userId, "사용자", 팩토리인터페이스객체); // 쿼리문 userid -> 조회
        return 사용자객체;
        
    }

    /**
     * @param id 
     * @return
     */
    public void 사용자로그아웃() {
        // TODO implement here
        
    }

}