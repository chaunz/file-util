package com.zhuchuansheng.exception;

/**
 *      不是一个文件夹异常
 *
 * @author zhuchuansheng
 * @date: 2020/1/3
 * @time: 19:34
 */
public class NotFolderException extends Exception {

    public NotFolderException(){
        super("不是一个文件夹");
    }

    public NotFolderException(String message){
        super(message);
    }
}
