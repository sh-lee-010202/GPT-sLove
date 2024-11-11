package Main;

import java.io.*;
import java.util.*;

import Actor.AI캐릭터;

/**
 * 
 */
public class 호감도계산 {

    /**
     * Default constructor
     */
    public 호감도계산() {
    }

    /**
     * 
     */
    private List<String> 불용어;

    /**
     * 
     */
    private List<String> 토큰화_문자열;

    /**
     * @param 사용자_입력 
     * @return
     */
    public List<String> 토큰화(String 사용자_입력) {
        // TODO implement here
    	List<String> 토큰 = Arrays.asList(사용자_입력.split(" "));
    	
    	for (String i : 토큰) {
            if (!불용어.contains(i)) {
                토큰화_문자열.add(i);
            }
        }
    	return 토큰화_문자열;
    }
    /**
     * @param word1
     * @param word2
     * @return
     */
    private double 코사인유사도계산(String word1, String word2) {
        // TODO implement here
        return 0.0;
    }

    /**
     * @param 토큰화_문자열 
     * @param AI캐릭터객체 
     * @return
     */
    public int 호감도반환(String 사용자_입력, AI캐릭터 AI캐릭터객체) {
    	double 좋아하는단어점수 = 0;
        double 싫어하는단어점수 = 0;
        double 비율 = 0;
        List<String> 토큰화_문자열 = 토큰화(사용자_입력);
        
        for(String token:토큰화_문자열) { //리스트끼리 유사도 누적 계산
            for(String favWord:AI캐릭터객체.get좋아하는단어())  {
                좋아하는단어점수 += 코사인유사도계산(token, favWord);
            }
            for(String disWord:AI캐릭터객체.get싫어하는단어())  {
                싫어하는단어점수 += 코사인유사도계산(token, disWord);
            }
        }

        비율 = 좋아하는단어점수 / (좋아하는단어점수 + 싫어하는단어점수);  // 비율 계산
        if(비율 >= 0.5) return 10;
        else return -10;
    }

}