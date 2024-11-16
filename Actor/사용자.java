package Actor;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class 사용자 implements 성격테스트 {

    /**
     * Default constructor
     */
    public 사용자() {
    }

    /**
     * 
     */
    public String ID;

    /**
     * 
     */
    public String 비밀번호;

    /**
     * 
     */
    public ArrayList<Integer> 테스트_선택값;

    /**
     * @return
     */
    public String 성격테스트() {
        // TODO implement 성격테스트.성격테스트() here
    	int selectedChoice = 테스트_선택값.get(0);

        switch (selectedChoice) {
            case 0:
                return "0"; // 캐릭터 ID 0
            case 1:
                return "1"; // 캐릭터 ID 1
            case 2:
                return "2"; // 캐릭터 ID 2
            case 3:
                return "3"; // 캐릭터 ID 3
            default: 
            	return "";
        }
    }

}