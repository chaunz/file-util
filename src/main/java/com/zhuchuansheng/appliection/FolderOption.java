package com.zhuchuansheng.appliection;

import com.zhuchuansheng.entity.FolderObject;
import com.zhuchuansheng.exception.NotFolderException;
import com.zhuchuansheng.util.GetDate;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <h1>文件夹对象操作</h1>
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 8:49
 */
public class FolderOption {

    /**
     * 文件夹对象
     */
    private FolderObject folderObject;

    /**
     * <h1>初始化文件夹操作对象</h1>
     * <p>
     *     传递一个文件夹对象,初始化文件夹对象
     * </p>
     * @param folderObject
     */
    public FolderOption(FolderObject folderObject){
        this.folderObject = folderObject;
    }

    /**
     * <h1>删除文件夹中的所有文件</h1>
     * <p>
     *      如果: all = true      该文件夹也会被删除<br/>
     *           all = false     只是清空文件夹中的文件,文件夹不会被删除
     * </p>
     * @param all       删除的范围
     * @throws IOException
     */
    public void deleteFolderAll(boolean all) throws IOException {

        if(all)
            FileUtils.cleanDirectory(this.folderObject.getTarget());
        else
            FileUtils.deleteDirectory(folderObject.getTarget());
    }


    /**
     * <h1>删除当前目录中的空文件夹</h1>
     * <p>
     *          all为 true 时, 表示只删除空文件夹<br/>
     *          all为 false 时, 表示空文件夹, 文件都会被删除
     * </p>
     * @param all  选项
     * @throws NotFolderException
     * @throws IOException
     */
    public void deleteFolderEmpty(boolean all) throws NotFolderException, IOException {

        this.isDirectory(this.folderObject.getTarget());

        String[] names = this.filterFileByEmpty();
        if(names != null && names.length > 0){
            for (String name : names) {
                File file = new File(this.folderObject.getBasePath(), name);
                if(!all){
                    if(file.isDirectory()){
                        file.delete();
                    }
                }else{
                    file.delete();
                }
            }
        }
    }


    /**
     * <h1>删除当前文件下的全部空文件</h1>
     * <P>
     *
     *      <font color="red">注意: 这里使用的是递归删除,所以文件夹中的文件过大,就不要使用了</font>
     * </P>
     */
    public void deleteFolderAllEmpty(){
        int num = 0;
        Collection<File> folderListAll = this.getFolderListAll();
        for (File file : folderListAll) {
            if(file.exists()) {
                if (file.length() == 0)
                    file.delete();
                else
                    num += 1;
            }
        }
        if(folderListAll.size() == num){
            return;
        }
        deleteFolderAllEmpty();
    }



    /**
     * <h1>创建文件夹</h1>
     *
     */
    public void createFolder(){

        //获取当前时间
        Integer[] date = GetDate.getDate();
        StringBuilder str = new StringBuilder();
        str.append(date[0].toString()+"年"+"\\");
        str.append(date[1].toString()+"月"+date[2].toString()+"日"+"\\");
        str.append(date[3]+"时");
        String basePath = this.folderObject.getBasePath();
        File file = new File(basePath, str.toString());
        if (!file.isDirectory()){
            file.mkdirs();
        }
    }





    /**
     *  <h1>文件夹的复制</h1>
     *
     * @param dec      复制到的文件夹
     * @throws IOException
     * @throws NotFolderException
     */
    public void copy(File dec) throws IOException, NotFolderException {

        this.isDirectory(dec);

        FileUtils.copyDirectory(this.folderObject.getTarget(), dec);
    }


    /**
     * <h1>获取指定后缀的文件</h1>
     *
     * @param suffix        后缀
     * @return
     */
    public String[] getFileBySuffix(String suffix){

        String[] list = this.folderObject.getTarget().list(new SuffixFileFilter(suffix));
        return list;
    }


    /**
     * <h1>获取不为空的文件</h1>
     *
     * @return
     */
    public String[] filterEmptyFile(){

        String[] list = this.folderObject.getTarget().list(EmptyFileFilter.NOT_EMPTY);
        return list;
    }


    /**
     * <h1>获取为空的文件</h1>
     *
     * @return
     */
    public String[] filterFileByEmpty(){

        String[] list = this.folderObject.getTarget().list(EmptyFileFilter.EMPTY);
        return list;
    }





    /**
     * <h1>移动文件夹</h1>
     *
     * @param dec       移动的目标
     * @throws NotFolderException
     * @throws IOException
     */
    public void moveFolder(File dec) throws NotFolderException, IOException {

        this.isDirectory(dec);

        FileUtils.moveFileToDirectory(this.folderObject.getTarget(), dec, true);
    }


    /**
     * <h1>获取文件夹剩余的空间大小</h1>
     * <p>
     *     <font color="red">以字节为单位</font>
     * </p>
     * @return
     * @throws IOException
     */
    public Long folderFreeSpace() throws IOException {

        long spaceKb = FileSystemUtils.freeSpaceKb(folderObject.getTarget().toString());
        return spaceKb;
    }


    /**
     * <h1>获取文件夹中的全部的文件</h1>
     *
     * @return
     */
    public Collection<File> getFolderListAll(){

        Collection<File> files = FileUtils.listFilesAndDirs(this.folderObject.getTarget(), TrueFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE);
        return files;
    }



    /**
     * <h1>判断是否为一个文件夹</h1>
     *
     * @param file      文件夹
     * @throws NotFolderException
     */
    private void isDirectory(File file) throws NotFolderException {

        if(!file.isDirectory())
            throw new NotFolderException();
    }

}
