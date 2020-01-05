package com.zhuchuansheng.exception;

/**
 *      不是一个文件夹异常
 *
 * @author zhuchuansheng
 * @date: 2020/1/3
 * @time: 19:34
 */
public class NotFileException extends Exception {

    public NotFileException(){
        super("不是一个文件");
    }

    public NotFileException(String message){
        super(message);
    }
}
