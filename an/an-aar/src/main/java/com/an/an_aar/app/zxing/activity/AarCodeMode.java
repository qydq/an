package com.an.an_aar.app.zxing.activity;

import java.io.Serializable;

/**********************************************************
 * @文件名称：CodeMode
 * @文件作者：staryumou@163.com
 * @创建时间：2016/8/25
 * @文件描述：null
 * @修改历史：2016/8/25
 **********************************************************/
public class AarCodeMode implements Serializable {
    private String code;
    private String strs[];
    private String age;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
