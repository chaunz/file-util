package com.zhuchuansheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 8:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FileObject implements Serializable {

    /**
     *  目标文件
     */
    private File target;

    /**
     *  文件夹名称
     */
    private String fileName;

    /**
     *  文件夹大小
     */
    private Long fileSize;

    /**
     *  文件夹最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 基本路径
     */
    private String basePath;
}
