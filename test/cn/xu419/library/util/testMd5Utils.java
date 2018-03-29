package cn.xu419.library.util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author bsz
 * Created on 2018/3/29
 */
public class testMd5Utils {
    @Test
    public void testTransToMd5(){
        String s = "bring";
        System.out.println(Md5Utils.transToMd5(s));
        assertTrue(Md5Utils.isSame(s,Md5Utils.transToMd5(s)));
    }


}
