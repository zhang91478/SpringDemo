package cn.xu419.library.common;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.xu419.library.constant.PermissionEnum;
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
    public static final Map<String,List<String>> SEX_MAP;

    /**
     *
     * 职位
     */
    public static final Map<String,List<String>> POSITION_MAP;

    /**
     *
     * 黑名单
     */
    public static final Map<String,List<String>> WHITE_MAP;

    /**
     *
     * 白名单
     */
    public static final Map<String,List<String>> BLACK_MAP;

    static {
        SEX_MAP = Maps.newHashMap();
        SEX_MAP.put(ReaderEnum.SEX_LIST.type, Arrays.asList("man","woman"));
        POSITION_MAP = Maps.newHashMap();
        POSITION_MAP.put(ReaderEnum.POSITION_LIST.type,Arrays.asList("student","teacher","manager"));
        WHITE_MAP = Maps.newHashMap();
        WHITE_MAP.put(PermissionEnum.WHITE_LIST.type,Arrays.asList("2015011381","2015011382"));
        BLACK_MAP = Maps.newHashMap();
        BLACK_MAP.put(PermissionEnum.BLACK_LIST.type,Arrays.asList("2015011383","2015011384"));
    }
}
