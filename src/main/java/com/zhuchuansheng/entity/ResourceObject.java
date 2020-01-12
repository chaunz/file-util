package com.zhuchuansheng.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 *      资源操作的抽象类
 *
 *             规范了资源的属性及方法
 *
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:20
 */
@Data
public abstract class ResourceObject implements Serializable {

    /**
     * 文件夹   当前文件夹下的所有文件        String
     *
     * 文件     修改文件时间                Date        updateDate
     *         最后一次访问时间             Date        lastVisitDate
     *         文件类型                    String      fileType
     */
    /**
     *  当前文件的名称
     */
    private String fileName;
    /**
     * 文件的上一层的路径
     */
    private String baasPath;
    /**
     * 目标文件
     */
    private File target;                //当前对象
    /**
     * 文件的大小   单位: KB
     */
    private Integer fileSize;

    /**
     *  文件创建的时间
     */
    private Long updateDate;

    public ResourceObject(File target) {
        this.target = target;
    }
}
