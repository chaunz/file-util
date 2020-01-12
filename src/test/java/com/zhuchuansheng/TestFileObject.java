package com.zhuchuansheng;

import com.zhuchuansheng.entity.FileObject;
import org.junit.Test;

import java.io.File;

/**
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 10:49
 */
public class TestFileObject {



    @Test
    public void testFileObject(){

        FileObject fileObject = new FileObject(new File("F:\\test\\aa.txt"));
        System.out.println("文件的名称: "+fileObject.getFileName());
        System.out.println("文件的大小: "+fileObject.getFileSize());
        System.out.println("文件的父路径: "+fileObject.getBaasPath());
        System.out.println("文件的更新时间: "+fileObject.getUpdateDate());
        System.out.println("文件类型: "+fileObject.getFileType());
        System.out.println("文件的后缀: "+fileObject.getFileSuffix());
    }

}
