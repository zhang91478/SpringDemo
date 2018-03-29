package cn.xu419.library.mapper;

import cn.xu419.library.model.ReaderModel;
import org.apache.ibatis.annotations.Param;

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
     *
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
     * @param oldPassWord
     * 用户老密码
     * @param newPassWord
     * 用户新密码
     *
     */
    public void updatePassword(@Param("old") String oldPassWord,@Param("new") String newPassWord);

}
