package com.zhuchuansheng.type.compress;

import com.zhuchuansheng.type.ResourceType;

/**
 *          压缩格式
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 11:29
 */
public enum CompressType implements ResourceType {

    GZ("gz", "application/x-gzip"),
    TGZ("tgz", "application/x-gzip"),
    BZ("bz", "application/x-bzip2"),
    BZ2("bz2", "application/x-bzip2"),
    TBZ("tbz", "application/x-bzip2"),
    ZIP("zip", "application/zip"),
    RAR("rar", "application/x-rar"),
    TAR("tar", "application/x-tar");


    /**
     *      类型的后缀
     */
    private String suffix;

    /**
     *      Mimn类型
     */
    private String type;

    CompressType(String suffix, String type) {
        this.suffix = suffix;
        this.type = type;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResourceType{" +
                "suffix='" + suffix + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
