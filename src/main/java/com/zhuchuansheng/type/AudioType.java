package com.zhuchuansheng.type;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 15:54
 */
public enum AudioType implements BaseType {

    MP3("mp3", "audio/mpeg"),
    MID("mid", "audio/midi"),
    OGG("ogg", "audio/ogg"),
    MP4A("mp4a", "audio/mp4"),
    WAV("wav", "audio/wav"),
    WMA("wma", "audio/x-ms-wma");

    /**
     * Mime类型
     */
    private String type;

    /**
     * 后缀
     */
    private String suffix;

    AudioType(String suffix, String type) {
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
