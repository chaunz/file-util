package com.zhuchuansheng.application.base.folder;

import com.zhuchuansheng.application.base.OptionBase;
import com.zhuchuansheng.entity.ResourceObject;

import java.io.File;
import java.io.Serializable;

/**
 *      文件夹操作的基本类
 *
 *              包含对文件夹的基本操作
 *                  增, 删, 改, 查
 *
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:23
 */
public class FolderBaseOption implements OptionBase, Serializable {


    @Override
    public boolean saveResource(ResourceObject resourceObject) {

        //获取目标文件
        File target = resourceObject.getTarget();

        System.out.println(target);

        return false;
    }

    @Override
    public boolean queryResource() {
        return false;
    }

    @Override
    public boolean deleteResource(ResourceObject resourceObject) {
        return false;
    }

    @Override
    public boolean updateResource(ResourceObject resourceObject) {
        return false;
    }
}
