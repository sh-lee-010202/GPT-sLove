package Actor;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class AI캐릭터 {

    /**
     * Default constructor
     */
    public AI캐릭터() {
    }

    /**
     * 
     */
    private String 캐릭터ID;

    /**
     * 
     */
    private String 이름;

    /**
     * 
     */
    private String 성격;

    /**
     * 
     */
    private int 호감도;

    /**
     * 
     */
    private String 해피엔딩;

    /**
     * 
     */
    private String 배드엔딩;

    /**
     * 
     */
    private List<String> 좋아하는단어;

    /**
     * 
     */
    private List<String> 싫어하는단어;
    
    /**
     * @param 점수
     */
    public List<String> get좋아하는단어() {
        // TODO implement here
    	return 좋아하는단어;
    }
    /**
     * @param 점수
     */
    public List<String> get싫어하는단어() {
        // TODO implement here
    	return 싫어하는단어;
    }
    

    /**
     * @param 점수
     */
    public void 호감도적용(int 점수) {
        // TODO implement here
    }
	public int get호감도() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String get캐릭터ID() {
		return 캐릭터ID;
	}
	public String get해피엔딩() {
		// TODO Auto-generated method stub
		return 해피엔딩;
	}
	public String get배드엔딩() {
		// TODO Auto-generated method stub
		return 배드엔딩;
	}
	public String get성격() {
		return 성격;
	}

}