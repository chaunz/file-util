package com.zhuchuansheng.util;

import com.zhuchuansheng.type.RegisterType;
import com.zhuchuansheng.type.ResourceType;
import com.zhuchuansheng.type.archive.ArchiveType;
import javafx.scene.shape.Arc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 12:43
 */
public class MimeUtil {


    /**
     *      资源类型
     */
    private static Map<String, String> stringStringMap;

    /**
     *      资源对象类型
     */
    private static Map<String, ResourceType> resourceTypeMap;

    /**
     *  初始化
     */
    static {

        stringStringMap = new HashMap<>();
        resourceTypeMap = new HashMap<>();
        List<Class<? extends ResourceType>> classes = RegisterType.registerMimeType();
        for (Class<? extends ResourceType> clazz : classes) {

            ResourceType[] enumConstants = clazz.getEnumConstants();
            for (ResourceType enumConstant : enumConstants) {

                stringStringMap.put(enumConstant.getSuffix(), enumConstant.getType());
                resourceTypeMap.put(enumConstant.getSuffix(), enumConstant);
            }
        }
    }


    /**
     *      根据文件后缀获取文件的mime类型
     *
     * @param suffix
     * @return
     */
    public static String getMimeBySuffix(String suffix){

        return stringStringMap.get(suffix);
    }

}
