package com.bawei.mengxyan.base;



/**
 * @包名 com.bawei.mengxyan.base
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名BaseActivity
 **/
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    public void assech(V view) {
        this.view = view;
    }

    public void dasech() {
        view = null;
    }

    protected abstract void initModel();
}
