package com.zhuchuansheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * <h1>文件夹的实体类</h1>
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 8:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FolderObject implements Serializable {

    /**
     *  目标文件
     */
    private File target;

    /**
     *  文件夹名称
     */
    private String folderName;

    /**
     *  文件夹大小
     */
    private Long folderSize;

    /**
     *  文件夹最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 基本路径
     */
    private String basePath;
}
