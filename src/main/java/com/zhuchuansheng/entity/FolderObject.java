package com.zhuchuansheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *      文件夹对象
 *
 *          包含文件夹的属性和方法
 * @containFile   包含文件个数
 * @containFolder  包含文件夹个数
 * @author zhuchuansheng
 * @date: 2020/1/8
 * @time: 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderObject extends ResourceObject implements Serializable {

    private Integer containFile;
    private Integer containFolder;

}
