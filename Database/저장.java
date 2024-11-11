package Database;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public interface 저장 {

    /**
     * @param 쿼리문
     * @throws SQLException 
     */
    public void 데이터_저장(String 쿼리문) throws SQLException;

}