package com.zhuchuansheng.type;

/**
 *      文件小类型
 *
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 11:05
 */
public enum TextType implements BaseType, BaseFileType {

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
     * Mime类型
     */
    private String type;

    /**
     * 后缀
     */
    private String suffix;

    TextType(String suffix, String type) {
        this.type = type;
        this.suffix = suffix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "TextType{" +
                "type='" + type + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
