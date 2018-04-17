package cn.xu419.library.mapper;

import cn.xu419.library.model.MemoryModel;
import org.apache.ibatis.annotations.Param;

/**
 * @author bsz
 * Created on 2018/3/31
 */
public interface MemoryMapper {
    public void addMemoryInfo(@Param("info")MemoryModel info);
    public void getMemory(@Param("amount") Integer amount);
}
