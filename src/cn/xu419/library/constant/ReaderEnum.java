package cn.xu419.library.constant;


/**
 * @author bsz
 * Created on 2018/3/29
 */
public enum ReaderEnum {
    SEX_LIST("sex","性别"),
    POSITION_LIST("position","职位"),
    WHITE_LIST("black","黑名单"),
    BLACK_LIST("black","黑名单");

    /**
     * 类型
     */
    public String type;

    /**
     * 描述
     */
    public String desc;

    ReaderEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 获得枚举类型
     *
     * @param type 类型
     *
     * @return 枚举
     *
     */
    public static ReaderEnum fromType(String type){
        if (type == null) {
            return null;
        }
        for (ReaderEnum readerEnum : ReaderEnum.values()) {
            if (readerEnum.getType().equals(type)){
                return readerEnum;
            }

        }
        return null;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
