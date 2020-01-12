package com.zhuchuansheng.application.base;

import com.zhuchuansheng.entity.ResourceObject;

import java.io.File;

/**
 *      资源操作的规范
 *
 *             包含了对象资源的基本操作规范
 *
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:26
 */
public interface OptionBase {

    /**
     *      添加文件
     *
     * @param resourceObject
     */
    boolean saveResource(ResourceObject resourceObject);

    /**
     *      查找文件
     * @return
     */
    boolean queryResource();


    /**
     *      删除文件
     * @param resourceObject        删除的文件
     * @return
     */
    boolean deleteResource(ResourceObject resourceObject);


    /**
     *      修改文件
     *
     * @param resourceObject       修改的文件
     * @return
     */
    boolean updateResource(ResourceObject resourceObject);
}
