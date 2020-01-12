package com.zhuchuansheng.entity;

import com.zhuchuansheng.util.MimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.rtf.RTFEditorKit;
import java.io.File;
import java.io.PipedReader;
import java.io.Serializable;
import java.util.Date;

/**
 *      文件的对象
 *
 *           包含文件的属性和方法
 * @lastVisitDate   最后访问时间
 * @updateDate   最后修改时间
 * @fileType   文件类型
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:22
 */

@Data
public class FileObject extends ResourceObject implements Serializable {

    /**
     *  文件的Minm类型
     */
    private String fileType;

    /**
     *  文件的后缀
     */
    private String fileSuffix;

    /**
     * 文件之间的分隔符
     */
    private static final String PARTITION = ".";

    public FileObject(File target) {
        super(target);
        this.init();
    }


    private void init(){
        File target = this.getTarget();
        String targetName = target.getName();
        this.setFileName(targetName);        // 设置文件的名称
        this.setBaasPath(target.getParent());      // 设置文件的父路径
        this.setFileSize((int) target.length());   // 设置文件的大小
        this.setUpdateDate(target.lastModified()); // 设置文件更新的时间
        String suffix = targetName.substring(targetName.indexOf(FileObject.PARTITION) + 1, targetName.length());
        this.setFileSuffix(suffix);
        String mimeBySuffix = MimeUtil.getMimeBySuffix(this.fileSuffix);
        this.setFileType(mimeBySuffix);
    }
}
