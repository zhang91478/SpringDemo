package cn.xu419.library.service;

/**
 * @author bsz
 * Created on 2018/3/27
 */
public interface IReaderPersist<T> {
    /*--------------以下是针对Reader的增删改操作------------------*/
    /**
     * 新添加一个读者
     *
     * @param reader
     * 读者除密码外的其他信息
     * @param password
     * 读者的密码，需加密
     */
    public void addReader(T reader,String password);

    /**
     * 更新一个读者的个人信息
     *
     * @param reader
     * 更新一个读者的个人信息
     *
     */
    public void updateReader(T reader);

    /**
     * 通过账号删除一个读者
     *
     * @param account
     * 一个读者的账号
     */
    public void deleteReaderByAccount(String account);

    /**
     * 修改用户密码
     *
     * @param oldPassWord
     * 用户老密码
     * @param newPassWord
     * 用户新密码
     *
     */
    public void updatePassword(String oldPassWord,String newPassWord);
}
