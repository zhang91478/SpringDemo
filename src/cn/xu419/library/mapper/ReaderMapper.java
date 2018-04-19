package cn.xu419.library.mapper;

import cn.xu419.library.model.ReaderModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 读者信息的管理，增删改查
 *
 * @author bsz
 * Created on 2018/3/26
 */
public interface ReaderMapper {
    /**
     * 新添加一个读者
     *
     * @param reader
     * 读者除密码外的其他信息
     * @param password
     * 读者的密码，需加密
     */
    public void addReader(@Param("reader") ReaderModel reader, @Param("password") String password);

    /**
     * 更新一个读者的个人信息
     *
     * @param reader
     * 更新一个读者的个人信息
     *
     */
    public void updateReader(@Param("reader") ReaderModel reader);

    /**
     * 获得一个读者除密码外的个人信息
     *
     * @param  account
     * 所查询读者的账号
     * @return 一个用户的基本信息
     */
    public ReaderModel getReaderByAccount(@Param("account") String account);

    /**
     * 删除一个读者信息
     *
     * @param account
     * 所删除读者的账号
     *
     */
    public void deleteReaderByAccount(@Param("account") String account);

    /**
     * 修改用户密码
     *
     * @param account 用户账号
     * @param oldPassWord
     * 用户老密码
     * @param newPassWord
     * 用户新密码
     *
     */
    public void updatePassword(@Param("account") String account,@Param("old") String oldPassWord,@Param("new") String newPassWord);

    /**
     * 通过账户密码查询是否存在此账户
     *
     * @param account
     * 账户
     * @param password
     * 密码
     * @return 是否存在此账户
     *
     */
    public ReaderModel login(@Param("account") String account, @Param("password") String password);

    /**
     *
     * 获得所有用户
     *
     * @return 所有用户
     *
     */
    public List<ReaderModel> getReaders();
}
