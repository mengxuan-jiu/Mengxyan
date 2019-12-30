package com.bawei.mengxyan.view.activity;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mengxyan.R;
import com.bawei.mengxyan.base.BaseActivity;
import com.bawei.mengxyan.contract.IContract;
import com.bawei.mengxyan.presenter.HomePresenter;
import com.bawei.mengxyan.presenter.bean.Bean;
import com.bawei.mengxyan.view.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<HomePresenter> implements IContract.IView {


    @BindView(R.id.m_recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDate() {
        mPresenter.homeDaet();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter protectedPresenter() {
        return new HomePresenter();
    }

    @Override
    public void homeSuccess(Bean bean) {
mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Bean.ResultBean> list = bean.getResult();
        MyAdapter myAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnClickListener(new MyAdapter.SetOnClickListener() {
            @Override
            public void onClickListener(int i) {
                Intent intent = new Intent(MainActivity.this,SysActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void homeFil(Throwable throwable) {

    }


}
