package cn.xu419.library.common;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.xu419.library.constant.ReaderEnum;
import com.google.common.collect.Maps;



/**
 * @author bsz
 * Created on 2018/3/29
 */
public class CommonFactory {
    /**
     *
     * 性别
     */
    public static final Map<String,List<String>> SEX_MAX;

    /**
     *
     * 职位
     */
    public static final Map<String,List<String>> POSITION_MAP;

    static {
        SEX_MAX = Maps.newHashMap();
        SEX_MAX.put(ReaderEnum.SEX_LIST.type, Arrays.asList("man","woman"));
        POSITION_MAP = Maps.newHashMap();
        POSITION_MAP.put(ReaderEnum.POSITION_LIST.type,Arrays.asList("student","teacher","manager"));
    }
}
