package com.zhuchuansheng.application.option.file;

import com.zhuchuansheng.application.base.file.FileBaseOption;
import com.zhuchuansheng.entity.ResourceObject;

import java.io.Serializable;

/**
 *      文件的操作类
 *
 *              封装了对象文件的基本操作和其他操作
 *
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:30
 */
public class FileOption extends FileBaseOption implements Serializable {


    @Override
    public boolean saveResource(ResourceObject resourceObject) {
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
