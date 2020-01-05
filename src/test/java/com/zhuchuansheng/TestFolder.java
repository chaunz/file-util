package com.zhuchuansheng;

import com.zhuchuansheng.appliection.FileOption;
import com.zhuchuansheng.appliection.FolderOption;
import com.zhuchuansheng.appliection.Option;
import com.zhuchuansheng.entity.FileObject;
import com.zhuchuansheng.entity.FolderObject;
import com.zhuchuansheng.type.FileType;
import com.zhuchuansheng.type.TextType;
import com.zhuchuansheng.type.Type;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhuchuansheng
 * @date: 2020/1/3
 * @time: 19:16
 */
public class TestFolder {

    @Test
    public void test() throws Exception {

        Option option = new Option();
        //"1、组长的职责.txt"
        FolderObject folderObject = (FolderObject) option.getObject(new File("E:\\222\\test"));
        //获取文件夹操作对象
        FolderOption folderOption = option.getOption(folderObject);
        //删除文件夹中的文件
//        folderOption.deleteFileAll(true);
        //文件夹的复制
//        folderOption.copy(new File("E:\\222\\aa"));
        //获取文件剩余的空间大小
//        Long aLong = folderOption.folderFreeSpace();
//        System.out.println(aLong);
//        Collection<File> listAll = folderOption.getFolderListAll();
//        for (File file : listAll) {
//            System.out.println(file);
//        }
        //获取指定后缀文件
//        String[] txts = folderOption.getFileBySuffix("txt");
//        for (String txt : txts) {
//            System.out.println(txt);
//        }

    }


    @Test
    public void test1() throws Exception {
        Option option = new Option();
        FileObject fileObject = (FileObject) option.getObject(new File("E:\\222\\test", "新建文本文档.txt"));
        FileOption fileOption = option.getOption(fileObject);
        //判断文件中的内容是否相同
//        boolean b = fileOption.compareFile(new File("E:\\222\\aa", "新建文本文档.txt"));
//        System.out.println(b);
        //按照行读取文件内容
//        List<String> fileReadByLine = fileOption.getFileReadByLine();
//        for (String s : fileReadByLine) {
//            System.out.println(s);
//        }
        //写内容到文件中
//        fileOption.writeStringToFileByAppend("追加");
//        fileOption.writeStringToFile("覆盖");
        boolean b = fileOption.mimeTypeIdentical(Type.TEXT_TYPE);
        System.out.println(b);
    }


    @Test
    public void test2() throws IOException, InstantiationException, IllegalAccessException {

        FileType fileType = new FileType();
//        String mimeType = fileType.getMimeType(new File("E:\\222\\test", "新建文本文档.txt"));
//        System.out.println(mimeType);
        boolean b = fileType.mimeTypeIdentical(new File("E:\\222\\test", "新建文本文档.txt"), Type.TEXT_TYPE);
        System.out.println(b);
    }


    @Test
    public void test3() throws IOException {

        TextType txt = TextType.TXT;
        System.out.println(txt);
    }

}
