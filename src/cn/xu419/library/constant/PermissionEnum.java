package cn.xu419.library.constant;

/**
 * @author bsz
 * Created on 2018/3/31
 */
public enum PermissionEnum {
    // 枚举定义
    WHITE_LIST("white", "白名单"),
    BLACK_LIST("black", "黑名单");
    /**
     * 类型
     */
    public String type;
    /**
     * 描述
     */
    public String desc;

    /**
     * 根据类型来获取枚举
     *
     * @param type
     *            类型
     * @return 目标枚举
     */
    public static PermissionEnum fromType(String type) {
        if (type == null) {
            return null;
        }
        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
            if (permissionEnum.getType().equals(type)) {
                return permissionEnum;
            }
        }
        return null;
    }

    PermissionEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
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
