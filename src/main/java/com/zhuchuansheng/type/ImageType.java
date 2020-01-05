package com.zhuchuansheng.type;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 15:50
 */
public enum ImageType implements BaseType {

    BMP("bmp", "image/x-ms-bmp"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpeg", "image/jpeg"),
    GIF("gif", "image/gif"),
    PNG("png", "image/png"),
    TIF("tif", "image/tiff"),
    TIFF("tiff", "image/tiff"),
    TGA("tga", "image/x-targa"),
    PSD("psd", "image/vnd.adobe.photoshop");

    /**
     * Mime类型
     */
    private String type;

    /**
     * 后缀
     */
    private String suffix;

    ImageType(String suffix, String type) {
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
