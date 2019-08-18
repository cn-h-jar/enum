package cn.h.enumdemo.enums;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 颜色
 */
public enum ColorEnum {
    RED(1, "红"), GREEN(2, "绿"), YELLOW(3, "黄"), BLUE(4, "蓝");

    int val;
    String name;

    /**
     * 返回List结合
     *
     * @return
     */
    public static List<ColorEnum> getEnumsList() {
        List<ColorEnum> enumList = new ArrayList<>();
        ColorEnum[] ms = ColorEnum.values();
        for (ColorEnum bagTypeEnum : ms) {
            enumList.add(bagTypeEnum);
        }
        return enumList;
    }

    /**
     * 提供给客户端做json数据
     *
     * @return
     */
    public static List<Map> getMapList() {
        List<Map> res = new ArrayList<>();
        Map map;
        List<ColorEnum> bagTypeEnumList = getEnumsList();
        for (ColorEnum bagTypeEnum : bagTypeEnumList) {
            map = new HashMap();
            map.put("name", bagTypeEnum.name);
            map.put("key", bagTypeEnum);
            map.put("val", bagTypeEnum.val);
            res.add(map);
        }
        return res;
    }

    /**
     * 获取枚举根据name
     *
     * @return
     */
    public static ColorEnum getByT(String name) throws Exception {
        ColorEnum res = null;
        List<ColorEnum> bagTypeEnumList = getEnumsList();
        for (ColorEnum bagTypeEnum : bagTypeEnumList) {
            if (bagTypeEnum.name.equals(name)) return res = bagTypeEnum;
        }
        if (res == null) throw new Exception("根据name获取类型 -"+name+"- 未匹配到枚举");
        return res;
    }

    /**
     * 获取枚举根据val
     *
     * @return
     */
    public static ColorEnum getByT(long val) throws Exception {
        ColorEnum res = null;
        List<ColorEnum> bagTypeEnumList = getEnumsList();
        for (ColorEnum bagTypeEnum : bagTypeEnumList) {
            if (val==bagTypeEnum.getVal()) return res = bagTypeEnum;
        }
        if (res == null) throw new Exception("根据val获取类型 -"+val+"- 未匹配到枚举");
        return res;
    }


    public int getVal() {
        return val;
    }
    public String getName() {
        return name;
    }

    ColorEnum(int val, String name) {
        this.val = val;
        this.name = name;
    }

}