package com.zhuchuansheng.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public abstract class ResourceObject implements Serializable {

    /**
     * 文件夹   当前文件夹下的所有文件        String
     *
     * 文件     修改文件时间                Date        updateDate
     *         最后一次访问时间             Date        lastVisitDate
     *         文件类型                    String      fileType
     */
    private String fileName;
    private String absolutePath;
    private File target;                //当前对象
    private Double fileSize;
    private Date createDate;
}
