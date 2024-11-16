package System;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface 호감도계산인터페이스 {

    /**
     * @param 사용자_입력 
     * @param 좋아하는단어 
     * @param 싫어하는단어 
     * @return
     */
    public int 호감도반환(String 사용자_입력, List<String> 좋아하는단어, List<String> 싫어하는단어);

}