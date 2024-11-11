package Actor;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class 신규_사용자 extends 사용자 {

    /**
     * Default constructor
     */
    public 신규_사용자() {
    }

    /**
     * 
     */
    public int[] 테스트_선택값;

    /**
     * @return
     */
    public String 성격테스트() {
        // TODO implement here
    	int selectedChoice = 테스트_선택값[0];

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