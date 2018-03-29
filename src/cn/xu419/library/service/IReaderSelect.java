package cn.xu419.library.service;

import java.util.List;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IReaderSelect<T> {
    /*--------------以下是针对Reader的查操作------------------*/
    /**
     * 获得一个读者除密码外的个人信息
     *
     * @param  account
     * 所查询读者的账号
     *
     */
    public T getReaderByAccount(String account);


}
