package com.zhuchuansheng;

import com.zhuchuansheng.appliection.FileOption;
import com.zhuchuansheng.appliection.FolderOption;
import com.zhuchuansheng.appliection.Option;
import com.zhuchuansheng.entity.FileObject;
import com.zhuchuansheng.entity.FolderObject;
import com.zhuchuansheng.type.Type;

import java.io.File;

/**
 *          测试
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 12:20
 */
public class Test {


    /**
     *      测试文件对象
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject(new File("E:\\222\\test", "新建文本文档.txt"));
        System.out.println("文件名称: "+fileObject.getFileName());
        System.out.println("文件大小: "+fileObject.getFileSize());
        System.out.println("文件更新时间: "+fileObject.getLastUpdateDate());
        FileOption fileOption = option.getOption(fileObject);
        String fileType = fileOption.getFileType();
        System.out.println("文件类型: "+fileType);
        boolean b = fileOption.mimeTypeIdentical(Type.TEXT_TYPE);
        System.out.println("是否text类型: "+b);
    }


    /**
     *      测试文件复制
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test1() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject(new File("E:\\222\\test", "新建文本文档.txt"));
        FileOption fileOption = option.getOption(fileObject);
        boolean copy = fileOption.copy(new File("E:\\222\\aa.txt"), Type.TEXT_TYPE);
        System.out.println("文件复制是否成功: "+copy);
    }


    /**
     *      测试文件复制
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test2() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject(new File("E:\\222\\test", "新建文本文档.txt"));
        FileOption fileOption = option.getOption(fileObject);
        boolean b = fileOption.copyAuto(new File("E:\\222\\test"), Type.TEXT_TYPE);
        System.out.println("文件复制是否成功: "+b);
    }


    /**
     *      测试文件复制
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test3() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject("E:\\222\\test\\新建文本文档.txt");
        FileOption fileOption = option.getOption(fileObject);
        boolean b = fileOption.copyAuto("E:\\222\\test", Type.TEXT_TYPE);
        System.out.println("文件复制是否成功: "+b);
    }


    /**
     *      测试两个文件的内容是否相同
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test4() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject("E:\\222\\test\\新建文本文档.txt");
        FileOption fileOption = option.getOption(fileObject);
        boolean b = fileOption.compareFile(new File("E:\\222\\test\\1.txt"));
        System.out.println("比较两个文件的内容是否相同: "+b);
    }


    /**
     *      测试向文件中写入字符串数据
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test5() throws Exception {

        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject("E:\\222\\test\\新建文本文档.txt");
        FileOption fileOption = option.getOption(fileObject);
        fileOption.writeStringToFile("111", "UTF-8");
    }


    /**
     *      获取当前文件中的全部的文件
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test6() throws Exception {

        Option option = new Option();
        FolderObject folderObject = (FolderObject) option.getObject("E:\\222\\test");
        FolderOption folderOption = option.getOption(folderObject);
        String[] strings = folderOption.filterEmptyFile();
        for (String string : strings) {
            System.out.println("不为空的文件: "+string);
        }
        String[] strings1 = folderOption.filterFileByEmpty();
        for (String s : strings1) {
            System.out.println("空文件: "+s);
        }
    }


    /**
     *      删除当前文件夹中的空文件
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test7() throws Exception {

        Option option = new Option();
        FolderObject folderObject = (FolderObject) option.getObject("E:\\222\\test");
        FolderOption folderOption = option.getOption(folderObject);
        folderOption.deleteFolderEmpty(true);
    }


    /**
     *      创建文件夹目录
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test8() throws Exception {

        Option option = new Option();
        FolderObject folderObject = (FolderObject) option.getObject("E:\\222\\test");
        FolderOption folderOption = option.getOption(folderObject);
        folderOption.createFolder();
    }


    /**
     *      删除当前文件夹下所有的空文件
     *
     * @throws Exception
     */
    @org.junit.Test
    public void test9() throws Exception {

        Option option = new Option();
        FolderObject folderObject = (FolderObject) option.getObject("E:\\222\\test");
        FolderOption folderOption = option.getOption(folderObject);
        folderOption.deleteFolderAllEmpty();
    }

}
