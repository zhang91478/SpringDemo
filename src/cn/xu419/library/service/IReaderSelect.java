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
     * @return  一个读者的基本信息
     */
    public T getReaderByAccount(String account);


    /**
     * 登陆
     *
     * @param account
     * 登陆账号
     * @param password
     * 登陆密码
     * @return 登陆
     *
     */
    public T login(String account,String password);

    /**
     * 获取所有用户
     *
     * @return 所有用户
     *
     */
    public List<T> getReaders();



}
