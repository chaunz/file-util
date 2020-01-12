package com.zhuchuansheng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.security.krb5.internal.rcache.DflCache;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

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
public class FolderObject extends ResourceObject implements Serializable {


    /**
     *      当前文件夹中的文件个数
     */
    private Integer containFile;

    /**
     *      当前文件夹中文件夹的个数
     *
     */
    private Integer containFolder;

    public FolderObject(File target) {
        super(target);
        this.init();
    }



    /**
     *      文件对象初始化
     *
     */
    private void init(){
        File target = this.getTarget();
        this.setFileName(target.getName());         // 文件名字
        this.setBaasPath(target.getParent());       // 文件的父路径
        this.setFileSize((int) target.length());    // 文件大小
        this.setUpdateDate(target.lastModified());  // 文件最后一次更新的时间
        int[] fileAndFolderNumber = this.getFileAndFolderNumber();
        this.setContainFile(fileAndFolderNumber[0]);
        this.setContainFolder(fileAndFolderNumber[1]);
    }



    /**
     *      计算当球文件夹下的文件个数和文件夹个数
     *
     * @return
     */
    private int[] getFileAndFolderNumber(){
        File target = this.getTarget();
        File[] files = target.listFiles();
        int[] num = {0, 0};
        for (File file : files) {
            if(file.isFile()){
                num[0]++;
            }else{
                num[1]++;
            }
        }
        return num;
    }


}
