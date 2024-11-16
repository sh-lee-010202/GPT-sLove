package System;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import Actor.AI캐릭터;
import Database.로드;
import Database.수정;
import Factory.팩토리_인터페이스;

/**
 * 
 */
public class 게임상태관리 {

    /**
     * Default constructor
     */
    public 게임상태관리() {
    }

    /**
     * @param 수정객체 
     * @param id 
     * @param AI캐릭터객체 
     * @return
     * @throws SQLException 
     */
    public void 게임상태저장(수정 수정객체, String id, AI캐릭터 AI캐릭터객체) throws SQLException {
        // TODO implement here
    	String query = id+""+AI캐릭터객체.get캐릭터ID(); //임시쿼리
    	수정객체.데이터_수정(query);
    }

    /**
     * @param 로드객체 
     * @param id 
     * @param AI캐릭터객체 
     * @return
     * @throws SQLException 
     */
    public Object 게임상태로드(로드 로드객체, String id, AI캐릭터 AI캐릭터객체, 팩토리_인터페이스 팩토리인터페이스객체) throws SQLException {
        // TODO implement here
    	AI캐릭터객체 = (AI캐릭터) 로드객체.데이터_로드(AI캐릭터객체.get캐릭터ID(), "AI캐릭터", 팩토리인터페이스객체); // 쿼리문 캐릭터ID -> 조회
    	return AI캐릭터객체;
    }

    /**
     * @param 로드객체 
     * @param 캐릭터ID 
     * @return
     * @throws SQLException 
     */
    public AI캐릭터 AI캐릭터_불러오기(로드 로드객체, String 캐릭터ID, 팩토리_인터페이스 팩토리인터페이스객체) throws SQLException {
        // TODO implement here
    	AI캐릭터 AI캐릭터객체 = (AI캐릭터) 팩토리인터페이스객체.객체생성("AI캐릭터");
    	AI캐릭터객체 = (AI캐릭터) 로드객체.데이터_로드(캐릭터ID, "AI캐릭터", 팩토리인터페이스객체); // 쿼리문 캐릭터ID -> 조회
    	return AI캐릭터객체;
    }

}