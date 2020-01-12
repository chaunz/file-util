package com.zhuchuansheng.type;

import com.zhuchuansheng.type.archive.ArchiveType;
import com.zhuchuansheng.type.compress.CompressType;
import com.zhuchuansheng.type.image.ImageType;
import com.zhuchuansheng.type.txt.TextType;

import java.util.ArrayList;
import java.util.List;

/**
 *      注册Mime类型
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 14:14
 */
public class RegisterType {


    /**
     *  获取注册的Mime类型
     *
     * @return
     */
    public static List<Class<? extends ResourceType>> registerMimeType(){

        //定义结果
        ArrayList<Class<? extends ResourceType>> classArrayList = new ArrayList<>();
        //添加参数
        classArrayList.add(ArchiveType.class);
        classArrayList.add(CompressType.class);
        classArrayList.add(ImageType.class);
        classArrayList.add(TextType.class);

        return classArrayList;
    }


}
