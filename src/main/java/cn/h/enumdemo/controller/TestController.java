package cn.h.enumdemo.controller;

import cn.h.enumdemo.enums.ColorEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/test")
public class TestController {

    public static void main(String[] args) throws Exception {
        /**
         * 拿到颜色集合对象
         */
        List<ColorEnum> colorEnumList =ColorEnum.getEnumsList();
        for(ColorEnum colorEnum:colorEnumList)
        {
            System.out.println(colorEnum.toString()+"-"+colorEnum.getName()+"-"+colorEnum.getVal()+"-");
        }

        /**
         * 直接拿到enum
         */
        ColorEnum colorEnum=ColorEnum.BLUE;
        System.out.println("直接拿到的枚举:"+colorEnum.toString()+"-"+colorEnum.getName()+"-"+colorEnum.getVal()+"-");
        /**
         * 拿到对象根据name
         */
        colorEnum=ColorEnum.getByT("黄");
        System.out.println("根据“黄”拿到了:"+colorEnum.toString()+"-"+colorEnum.getName()+"-"+colorEnum.getVal()+"-");
        /**
         * 拿到对象根据val
         */
        colorEnum=ColorEnum.getByT(1);
        System.out.println("根据“1”拿到了:"+colorEnum.toString()+"-"+colorEnum.getName()+"-"+colorEnum.getVal()+"-");
    }

    /**
     * 客户端拿到颜色集合
     *
     * @return
     */
    @RequestMapping("getColors")
    public Object getColors() {
       return ColorEnum.getMapList();
    }

}
