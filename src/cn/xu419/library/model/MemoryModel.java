package cn.xu419.library.model;

import java.sql.Timestamp;

/**
 * @author bsz
 * Created on 2018/3/31
 */
public class MemoryModel {
    private Integer MaxMemory;
    private Integer TotalMemory;
    private Integer FreeMemory;
    private Timestamp time;

    public MemoryModel() {
    }

    public MemoryModel(Integer maxMemory, Integer totalMemory, Integer freeMemory, Timestamp time) {
        MaxMemory = maxMemory;
        TotalMemory = totalMemory;
        FreeMemory = freeMemory;
        this.time = time;
    }

    public Integer getMaxMemory() {
        return MaxMemory;
    }

    public void setMaxMemory(Integer maxMemory) {
        MaxMemory = maxMemory;
    }

    public Integer getTotalMemory() {
        return TotalMemory;
    }

    public void setTotalMemory(Integer totalMemory) {
        TotalMemory = totalMemory;
    }

    public Integer getFreeMemory() {
        return FreeMemory;
    }

    public void setFreeMemory(Integer freeMemory) {
        FreeMemory = freeMemory;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "MemoryModel{" +
                "MaxMemory=" + MaxMemory +
                ", TotalMemory=" + TotalMemory +
                ", FreeMemory=" + FreeMemory +
                ", time=" + time +
                '}';
    }
}
