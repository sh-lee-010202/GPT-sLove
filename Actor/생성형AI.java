package Actor;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class 생성형AI {

    /**
     * Default constructor
     */
    public 생성형AI() {
    }

    /**
     * 
     */
    private String 사용자_입력;

    /**
     * 
     */
    private int 호감도_변화;

    /**
     * @param AI캐릭터객체
     */
    public void 프롬프트초기화(AI캐릭터 AI캐릭터객체) {
        // TODO implement here
    	String init_prompt = AI캐릭터객체.get성격()+AI캐릭터객체.get싫어하는단어()+AI캐릭터객체.get싫어하는단어();
    }

    /**
     * @param 사용자_입력 
     * @param 호감도_변화 
     * @return
     */
    public String AI응답받기(String 사용자_입력, int 호감도_변화) {
        // TODO implement here
    	String prompt = "사용자 입력: " + 사용자_입력 + "\n호감도 변화: " + 호감도_변화;
        return "";
    }

}