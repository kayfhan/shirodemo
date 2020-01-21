package me.kay.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 13:50
 */
public class FastjsonTest {
    private String id;
    private String string;
    /**
     * 格式化日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 转换为json时不包括该属性
     */
    @JSONField(serialize = false)
    private String ignore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
