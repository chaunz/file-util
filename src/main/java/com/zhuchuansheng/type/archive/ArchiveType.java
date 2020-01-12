package com.zhuchuansheng.type.archive;

import com.zhuchuansheng.type.ResourceType;

/**
 *      文本类型
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 11:07
 */
public enum ArchiveType implements ResourceType {

    AI("AI", "application/postscript"),
    EPS("eps", "application/postscript"),
    EXE("exe", "application/octet-stream"),
    DOC("doc", "application/vnd.ms-word"),
    XLS("xls", "application/vnd.ms-excel"),
    PPT("ppt", "application/vnd.ms-powerpoint"),
    PPS("pps", "application/vnd.ms-powerpoint"),
    PDF("pdf", "application/pdf"),
    XML("xml", "application/xml"),
    ODT("odt", "application/vnd.oasis.opendocument.text"),
    SWF("swf", "application/x-shockwave-flash");

    /**
     *      类型的后缀
     */
    private String suffix;

    /**
     *      Mimn类型
     */
    private String type;

    ArchiveType(String suffix, String type) {
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
