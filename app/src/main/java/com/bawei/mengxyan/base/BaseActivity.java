package com.bawei.mengxyan.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.mengxyan.R;

import butterknife.ButterKnife;

/**
 * @包名 com.bawei.mengxyan.base
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名BaseActivity
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=protectedPresenter();
        if (mPresenter != null) {
            mPresenter.assech(this);
        }
        ButterKnife.bind(this);
        initView();
        initDate();
    }

    protected abstract int layoutId();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract P protectedPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dasech();
        }
    }
}
