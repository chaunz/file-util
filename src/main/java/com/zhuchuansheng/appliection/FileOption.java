package com.zhuchuansheng.appliection;

import com.zhuchuansheng.entity.FileObject;
import com.zhuchuansheng.exception.NotFileException;
import com.zhuchuansheng.type.FileType;
import com.zhuchuansheng.type.Type;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 9:50
 */
public class FileOption {

    /**
     * 文件对象
     */
    private FileObject fileObject;

    /**
     * 初始化文件对象
     * @param fileObject
     */
    public FileOption(FileObject fileObject){
        this.fileObject = fileObject;
    }


    /**
     *      判断两个文件内容是否相同
     *
     * @param dec       比较文件
     * @return
     * @throws NotFileException
     * @throws IOException
     */
    public boolean compareFile(File dec) throws NotFileException, IOException {

        this.isExistence(dec);
        this.isFile(dec);

        boolean b = FileUtils.contentEquals(this.fileObject.getTarget(), dec);
        return b;
    }


    /**
     *      写字符串到文件中
     *              实在文件后面追加
     *              默认使用编码是UTF-8
     *
     * @param content       内容
     * @throws IOException
     */
    public void writeStringToFileByAppend(String content) throws IOException {

        FileUtils.writeStringToFile(this.fileObject.getTarget(), content, "UTF-8", true);
    }

    /**
     *      写字符串到文件中
     *              实在文件后面追加
     *
     * @param content       内容
     * @param encoding      指定编码
     * @throws IOException
     */
    public void writeStringToFileByAppend(String content, String encoding) throws IOException {

        FileUtils.writeStringToFile(this.fileObject.getTarget(), content, encoding, true);
    }


    /**
     *      写字符串到文件中
     *           是覆盖原来写的
     *           默认使用编码是UTF-8
     *
     * @param content       内容
     * @throws IOException
     */
    public void writeStringToFile(String content) throws IOException {

        FileUtils.writeStringToFile(this.fileObject.getTarget(), content, "UTF-8", false);
    }


    /**
     *      写字符串到文件中
     *           是覆盖原来写的
     *
     * @param content       内容
     * @param encoding      指定编码
     * @throws IOException
     */
    public void writeStringToFile(String content, String encoding) throws IOException {

        FileUtils.writeStringToFile(this.fileObject.getTarget(), content, encoding, false);
    }



    /**
     *      按照行读取文件中的内容
     *
     * @return
     * @throws IOException
     */
    public List<String> getFileReadByLine() throws IOException {

        List<String> list = FileUtils.readLines(this.fileObject.getTarget());
        return list;
    }


    /**
     *      判断该文件Mime类型是否属于指定Mime类型
     *
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     * @throws InstantiationException
     */
    public boolean mimeTypeIdentical(Type type) throws IllegalAccessException, IOException, InstantiationException {

        boolean b = new FileType().mimeTypeIdentical(this.fileObject.getTarget(), type);
        return b;
    }





    /**
     *      将目标文件复制到指定的文件中
     *
     * @param dec
     * @throws IOException
     */
    public void copy(File dec) throws IOException, NotFileException {

        if(dec.isDirectory())
            throw new NotFileException();

        FileUtils.copyFile(this.fileObject.getTarget(), dec);
    }

    /**
     *      将目标文件复制到指定的文件中
     *
     * @param path
     * @throws IOException
     */
    public void copy(String path) throws IOException, NotFileException {
        File dec = new File(path);
        if(dec.isDirectory())
            throw new NotFileException();

        FileUtils.copyFile(this.fileObject.getTarget(), dec);
    }


    /**
     *          获取文件的类型
     *
     * @return
     * @throws IOException
     */
    public String getFileType() throws IOException {

        String mimeType = new FileType().getMimeType(this.fileObject.getTarget());
        return mimeType;
    }


    /**
     *      文件复制
     *             如果文件符合类型才可以复制
     *
     * @param dec       复制到的位置
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     * @throws InstantiationException
     * @throws NotFileException
     */
    public boolean copy(File dec, Type type) throws IllegalAccessException, IOException, InstantiationException, NotFileException {

        //确定文件的类型
        boolean b = this.mimeTypeIdentical(type);
        if(!b)
            return false;
        this.copy(dec);
        return true;
    }


    /**
     *      文件复制
     *             如果文件符合类型才可以复制
     *
     * @param path       复制到的位置
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     * @throws InstantiationException
     * @throws NotFileException
     */
    public boolean copy(String path, Type type) throws IllegalAccessException, IOException, InstantiationException, NotFileException {

        return this.copy(new File(path), type);
    }


    /**
     *      文件复制
     *             如果文件符合类型才可以复制
     *
     * @param dec       复制到的位置
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     * @throws InstantiationException
     * @throws NotFileException
     */
    public boolean copyAuto(File dec, Type type) throws IllegalAccessException, IOException, InstantiationException, NotFileException {

        //确定文件的类型
        boolean b = this.mimeTypeIdentical(type);
        if(!b)
            return false;
        //组成新名字
        long time = new Date().getTime();
        String fileName = this.fileObject.getFileName();
        //开始复制
        this.copy(new File(dec.toString(), time+"-"+fileName));
        return true;
    }


    /**
     *      文件复制
     *             如果文件符合类型才可以复制
     *
     * @param path       复制到的位置
     * @param type      类型
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     * @throws InstantiationException
     * @throws NotFileException
     */
    public boolean copyAuto(String path, Type type) throws IllegalAccessException, IOException, InstantiationException, NotFileException {

        return this.copyAuto(new File(path), type);
    }




    /**
     *      判断是否为文件
     *
     * @param file
     * @throws NotFileException
     */
    private void isFile(File file) throws NotFileException {

        if(file == null) {
            if (!this.fileObject.getTarget().isFile())
                throw new NotFileException();
        }else{
            if (!file.isFile())
                throw new NotFileException();
        }
    }


    /**
     *      判断文件是否存在
     *
     * @param file
     * @throws FileNotFoundException
     */
    private void isExistence(File file) throws FileNotFoundException {
        if(file == null) {
            if (!this.fileObject.getTarget().exists())
                throw new FileNotFoundException("文件不存在异常");
        }else{
            if (!file.exists())
                throw new FileNotFoundException("文件不存在异常");
        }
    }


}
