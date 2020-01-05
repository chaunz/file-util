package com.zhuchuansheng.type;

/**
 * @author zhuchuansheng
 * @date: 2020/1/5
 * @time: 11:11
 */
public enum  Type {

    /**
     * 图片类型
     */
    IMAGES_TYPE(com.zhuchuansheng.type.ImageType.class),
    /**
     * 文档类型
     */
    TEXT_TYPE(com.zhuchuansheng.type.TextType.class),
    /**
     * 音频类型
     */
    AUDIO_TYPE(com.zhuchuansheng.type.AudioType.class);

    private Class type;

    Type(Class type) {
        this.type = type;
    }

    public Class getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                '}';
    }
}
