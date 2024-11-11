package Factory;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface 팩토리_인터페이스 {

    /**
     * @return
     */
    public 팩토리 팩토리객체반환();

    /**
     * @param 문자열 
     * @return
     */
    public Object 객체생성(String 문자열);

}