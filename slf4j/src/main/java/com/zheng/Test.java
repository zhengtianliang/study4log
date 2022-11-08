package com.zheng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhengTianLiang
 * @date: 2022/10/11 22:49
 * @desc:
 */
public class Test {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        for (int[] range : CommonUtil.range(list.size(),2)){
//            System.out.println(1);
//            System.out.println(list.subList(range[0],range[1]));
//        }


        String orderInfoResp = null;
        int retry = 0;
        while (orderInfoResp==null){
            retry++;
            if (retry==5){
                orderInfoResp = "2";
                System.out.println(2);
                return;
            }
        }
        System.out.println(1);
    }
}
