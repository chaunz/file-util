package com.zhuchuansheng.util;

import java.util.Calendar;

/**
 *     时间工具类
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 14:43
 */
public class GetDate {


    /**
     * <h1>获取当前时间<h1/>
     * <p>
     *     获取当前的时间,是根据Calendar类获取的时间格式,<br/>
     *     返回值为一个int类型的数组,数组长度为: length = 4<br/>
     *     第一个值: 为年<br/>
     *     第二个值: 为月<br/>
     *     第三个值: 为日<br/>
     *     第四个值: 为时<br/>
     * </p>
     *
     * @return
     */
    public static Integer[] getDate(){

        Integer[] date = new Integer[4];
        Calendar instance = Calendar.getInstance();
        date[0] = instance.get(Calendar.YEAR);//获取年份  
        date[1] =instance.get(Calendar.MONTH) + 1;//获取月份  
        date[2] =instance.get(Calendar.DATE);//获取日  
        date[3] =instance.get(Calendar.HOUR);//小时
        return date;
    }

}
