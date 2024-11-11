package Database;

import java.io.*;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;

import java.sql.*;
import Factory.팩토리_인터페이스;
import Main.호감도계산;

/**
 * 
 */
public class 데이터베이스_어댑터 implements 저장, 수정, 로드 {

    /**
     * Default constructor
     */
    public 데이터베이스_어댑터() {
    	
    }
    public static final String URL = "";
    public static final String ROOT_USER = "root";
    public static final String ROOT_PASSWORD = "password";
    Connection conn;
    
    /**
     * 
     */
    public Connection 데이터베이스연결() {
    	// TODO implement here
    	try {
            // 루트 계정으로 데이터베이스 연결
            conn = DriverManager.getConnection(URL, ROOT_USER, ROOT_PASSWORD);
            return conn;
        } catch (SQLException e) {
            // DB 연결 실패
        }
    	return null;
    }

    /**	
     * @param 쿼리문
     * @throws SQLException 
     */
    public void 데이터_저장(String 쿼리문) throws SQLException {
        // TODO implement 저장.데이터_저장() here
    	String query = "데이터 저장 SQL";
    	try(PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, 쿼리문);
    	}
    }

    /**
     * @param 쿼리문
     * @throws SQLException 
     */
    public void 데이터_수정(String 쿼리문) throws SQLException {
        // TODO implement 수정.데이터_수정() here
    	String query = "데이터 수정 SQL";
    	try(PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, 쿼리문);
    	}
    }

    /**
     * @param 쿼리문 
     * @param 팩토리_인터페이스_객체 
     * @return
     * @throws SQLException 
     */
    public Object 데이터_로드(String 쿼리문, String 객체타입, 팩토리_인터페이스 팩토리_인터페이스_객체) throws SQLException {
        // TODO implement 로드.데이터_로드() here
    	String query = "사용자 정보 조회 SQL";
    	try(PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, 쿼리문);
            
            Object 객체 = 팩토리_인터페이스_객체.객체생성(객체타입);
            
            try (ResultSet rs = stmt.executeQuery()) {
            	if (rs.next()) {
                    // 사용자 객체일 경우
                    if (객체 instanceof 사용자) {
                        사용자 사용자객체 = (사용자) 객체;
                        //setter 메소드로 인스턴스 필드 값 저장
                        return 사용자객체;
                    }
                    else if (객체 instanceof AI캐릭터) {
                    	AI캐릭터 AI캐릭터객체 = (AI캐릭터) 객체;
                    	//setter 메소드로 인스턴스 필드 값 저장
                        return AI캐릭터객체;
                    }
            	}
            }    	
        return null;
            
    	}
    }
}