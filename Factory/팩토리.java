package Factory;

import java.io.*;
import java.util.*;

import Actor.AI캐릭터;
import Actor.사용자;
import Actor.생성형AI;
import Database.데이터베이스_어댑터;
import System.게임상태관리;
import System.로그인관리;
import System.시뮬레이션게임;
import System.호감도계산;

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
     * @param 객체타입 
     * @return
     */
    public Object 객체생성(String 객체타입) {
        // TODO implement 팩토리_인터페이스.객체생성() here
    	switch (객체타입) {
    	case "사용자":
    		return new 사용자();
    	case "AI캐릭터":
    		return new AI캐릭터();
    	case "생성형AI":
    		return new 생성형AI();
    	case "호감도계산":
    		return new 호감도계산();
    	case "DB":
    		return new 데이터베이스_어댑터();
    	case "게임상태관리":
    		return new 게임상태관리();
    	case "로그인관리":
    		return new 로그인관리();
    	case "시뮬레이션":
    		return new 시뮬레이션게임();
    	default:
        
	}
    return null;
    }

}