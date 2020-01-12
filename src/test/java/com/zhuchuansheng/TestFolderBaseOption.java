package com.zhuchuansheng;

import com.zhuchuansheng.application.option.folder.FolderOption;
import com.zhuchuansheng.entity.FolderObject;
import org.junit.Test;

import javax.annotation.processing.Filer;
import java.io.File;

/**
 *          测试
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 12:20
 */
public class TestFolderBaseOption {


    @Test
    public void testFolderObject(){

        FolderObject folderObject = new FolderObject(new File("F:\\test"));
        System.out.println("文件大小: "+folderObject.getFileSize());
        System.out.println("文件更新时间: "+folderObject.getUpdateDate());
        System.out.println("文件的父路径: "+folderObject.getBaasPath());
        System.out.println("文件的名称: "+folderObject.getFileName());
        System.out.println("文件包含文件的个数: "+folderObject.getContainFile());
        System.out.println("文件包含文件夹的个数: "+folderObject.getContainFolder());
    }

}
