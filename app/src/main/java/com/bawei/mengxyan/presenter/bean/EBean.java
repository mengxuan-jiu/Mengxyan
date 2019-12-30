package com.bawei.mengxyan.presenter.bean;

import java.util.List;

/**
 * @包名 com.bawei.mengxyan.presenter
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名Bean
 **/
public class EBean {
String string;
int i;

    public EBean(String string, int i) {
        this.string = string;
        this.i = i;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "EBean{" +
                "string='" + string + '\'' +
                ", i=" + i +
                '}';
    }
}
