package com.zhuchuansheng.type.image;

import com.zhuchuansheng.type.ResourceType;

/**
 *      图片类型
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 11:43
 */
public enum ImageType implements ResourceType {

    BMP("bmp", "image/x-ms-bmp"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpeg", "image/jpeg"),
    GIF("gif", "image/gif"),
    PNG("image/png", "image/png"),
    TIF("tif", "image/tiff"),
    TIFF("tiff", "image/tiff"),
    TGA("tga", "image/x-targa"),
    PSD("psd", "image/vnd.adobe.photoshop");


    /**
     *      类型的后缀
     */
    private String suffix;

    /**
     *      Mimn类型
     */
    private String type;

    ImageType(String suffix, String type) {
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
