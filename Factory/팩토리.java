package Factory;

import java.io.*;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;
import Actor.신규_사용자;
import Main.호감도계산;

/**
 * 
 */
public class 팩토리 implements 팩토리_인터페이스 {

    /**
     * Default constructor
     */
    public 팩토리() {
    }

    /**
     * 
     */
    private 팩토리 셀프객체;

    /**
     * @return
     */
    public 팩토리 팩토리객체반환() {
        // TODO implement 팩토리_인터페이스.팩토리객체반환() here
        return null;
    }

    /**
     * @param 문자열 
     * @return
     */
    public Object 객체생성(String 객체타입) {
        // TODO implement 팩토리_인터페이스.객체생성() here
    	switch (객체타입) {
        	case "사용자":
        		return new 사용자();
        	case "신규_사용자":
        		return new 신규_사용자();
        	case "AI캐릭터":
        		return new AI캐릭터();
        	case "생성형AI":
        		return new 생성형AI();
        	case "호감도계산":
        		return new 호감도계산();
        	default:
            
    	}
        return null;
    }

}