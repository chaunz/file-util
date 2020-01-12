package com.zhuchuansheng.type.txt;

import com.zhuchuansheng.type.ResourceType;

/**
 *     文本类型
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 11:33
 */
public enum TextType implements ResourceType {


    TXT("txt", "text/plain"),
    PHP("php", "text/x-php"),
    HTML("html", "text/html"),
    HTM("htm", "text/html"),
    JS("js", "text/javascript"),
    CSS("css", "text/css"),
    RTF("rtf", "text/rtf"),
    RTFD("rtfd", "text/rtfd"),
    PY("py", "text/x-python"),
    JAVA("java", "text/x-java-source"),
    RB("rb", "text/x-ruby"),
    SH("sh", "text/x-shellscript"),
    PL("pl", "text/x-perl"),
    SQL("sql", "text/x-sql");


    /**
     *      类型的后缀
     */
    private String suffix;

    /**
     *      Mimn类型
     */
    private String type;

    TextType(String suffix, String type) {
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
