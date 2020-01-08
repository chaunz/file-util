package com.zhuchuansheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class FileObject extends ResourceObject implements Serializable {

    private String fileType;
    private Date updateDate;
    private Date lastVisitDate;

}
