package Database;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import Factory.팩토리_인터페이스;

/**
 * 
 */
public interface 로드 {

    /**
     * @param 쿼리문 
     * @param 객체타입 
     * @param 팩토리_인터페이스_객체 
     * @return
     * @throws SQLException 
     */
    public Object 데이터_로드(String 쿼리문, String 객체타입, 팩토리_인터페이스 팩토리_인터페이스_객체) throws SQLException;

}