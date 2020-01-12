package com.zhuchuansheng.type;

/**
 *
 *          类型的规范
 *
 * @author zhuchuansheng
 * @date: 2020/1/12
 * @time: 11:02
 */
public interface ResourceType {

    String getSuffix();

    void setSuffix(String suffix);

    String getType();

    void setType(String type);
}
