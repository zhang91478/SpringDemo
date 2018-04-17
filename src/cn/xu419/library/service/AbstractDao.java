package cn.xu419.library.service;


import cn.xu419.library.common.CommonFactory;
import cn.xu419.library.constant.PermissionEnum;
import cn.xu419.library.constant.ReaderEnum;
import cn.xu419.library.mapper.BookMapper;
import cn.xu419.library.mapper.ReaderMapper;
import cn.xu419.library.mapper.RecordMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public abstract class AbstractDao {
    final Logger logger = Logger.getLogger(this.getClass());

    //BookMapper接口
    @Autowired
    protected BookMapper bookMapper;

    @Autowired
    protected ReaderMapper readerMapper;

    @Autowired
    protected RecordMapper recordMapper;

    /**
     * 检查性别是否合法
     *
     * @param sex
     * 性别
     * @return boolean
     *
     */
    public Boolean isSexLegal(String sex){
        return inEnum(sex,CommonFactory.SEX_MAP,ReaderEnum.SEX_LIST.type);
    }

    /**
     * 检查职位是否合法
     *
     * @param position
     * 职位
     * @return boolean
     *
     */
    public Boolean isPositionLegal(String position){
        return inEnum(position,CommonFactory.POSITION_MAP,ReaderEnum.POSITION_LIST.type);
    }

    /**
     * 检查是否在白名单中
     *
     * @param account
     * 用户账户
     * @return boolean
     *
     */
    public Boolean checkBlackPermission(String account){
        return inEnum(account,CommonFactory.BLACK_MAP, PermissionEnum.BLACK_LIST.type);
    }

    /**
     * 检查是否在黑名单中
     *
     * @param account
     * 用户账户
     * @return boolean
     *
     */
    public Boolean checkWhitePermission(String account){
        return inEnum(account,CommonFactory.WHITE_MAP, PermissionEnum.WHITE_LIST.type);
    }



    /**
     * 检查字符串是否在枚举中
     *
     * @param s
     * 需要检查是否是枚举类型元素的字符串
     * @param m
     * 初始化之后的枚举类型对应Map
     * @param type
     * 需要检查的枚举类型的类型
     * @return boolean
     *
     */
    private Boolean inEnum(String s, Map<String,List<String>> m,String type){
        if (StringUtils.isEmpty(s)) {
            return Boolean.FALSE;
        }

        List<String> list = m.get(type);

        if (CollectionUtils.isEmpty(list)) {
            return Boolean.FALSE;
        }
        if (list.contains(s)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
