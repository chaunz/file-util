package com.zhuchuansheng.appliection;

import com.zhuchuansheng.entity.FileObject;
import com.zhuchuansheng.entity.FolderObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 *      文件操作
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 8:13
 */
public class Option {

    /**
     * 表示, 判断是否为文件
     */
    private boolean isFile = false;


    /**
     *      获取文件对象
     *
     * @param file      初始化文件
     * @return
     * @throws Exception
     */
    public Object getObject(File file) throws Exception {

        return inti(file);
    }


    /**
     *      获取文件对象
     *
     * @param path      初始化文件路径
     * @return
     * @throws Exception
     */
    public Object getObject(String path) throws Exception {

        return inti(new File(path));
    }



    /**
     *      获取操作对象
     *
     * @param folderObject      文件夹对象
     * @return
     * @throws IOException
     */
    public FolderOption getOption(FolderObject folderObject) throws IOException {

        return new FolderOption(folderObject);
    }


    /**
     *      获取操作对象
     *
     * @param fileObject      文件对象
     * @return
     * @throws IOException
     */
    public FileOption getOption(FileObject fileObject) throws IOException {

        return new FileOption(fileObject);
    }

    /**
     *      文件初始化
     *
     * @param file      初始化的文件
     * @return
     * @throws FileNotFoundException
     */
    private Object inti(File file) throws FileNotFoundException {

        this.isExistence(file);
        //返回对象
        Object object;

        String fileName = file.getName();           // 获取文件名
        long size = FileUtils.sizeOf(file);         // 获取文件大小
        long time = file.lastModified();            // 获取最后一次更新的时间毫秒数

        //判断是否为文件夹
        if(file.isDirectory()) {
            //构建文件夹对象
            object = new FolderObject(file, fileName, size, new Date(time), file.getPath());
        }else{
            this.isFile = true;
            String parent = file.getParent();
            //获取文件后缀
            String extension = FilenameUtils.getExtension(fileName);
            //构建文件对象
            object = new FileObject(file, fileName, size, new Date(time), extension, parent);
        }
        return object;
    }



    /**
     *      判断文件是否存在
     *
     * @param file         判断的文件
     * @throws FileNotFoundException
     */
    private void isExistence(File file) throws FileNotFoundException {
        if(!file.exists())
            throw new FileNotFoundException("文件不存在异常");
    }
}
