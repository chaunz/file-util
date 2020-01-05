package com.zhuchuansheng.type;

import com.zhuchuansheng.entity.FileObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 10:46
 */
public class FileType {


    /**
     *      获取文件的Mime类型
     *
     * @param file      文件
     * @return
     * @throws IOException
     */
    public String getMimeType(File file) throws IOException {

        Path path = Paths.get(file.toURI());
        String type = Files.probeContentType(path);
        return type;
    }


    /**
     *      该文件类型与指定的Mime类型是否相同
     *
     * @param file      文件
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     */
    public boolean mimeTypeIdentical(File file,Type type) throws IllegalAccessException, InstantiationException, IOException {

        //获取枚举类
        BaseType[] enumConstants = (BaseType[]) type.getType().getEnumConstants();
        for (BaseType enumConstant : enumConstants) {

            if(enumConstant.getType().equals(this.getMimeType(file))){
                return true;
            }
        }
        return false;
    }

}
