package com.bawei.mengxyan.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.mengxyan.R;
import com.bawei.mengxyan.base.BaseActivity;
import com.bawei.mengxyan.base.BasePresenter;
import com.bawei.mengxyan.presenter.bean.EBean;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SysActivity extends BaseActivity {


    @BindView(R.id.s_image)
    ImageView sImage;
    @BindView(R.id.s_button)
    Button sButton;
    @BindView(R.id.s_s)
    Button sS;
    @BindView(R.id.s_b)
    Button sB;

    @Override
    protected int layoutId() {
        return R.layout.activity_sys;
    }

    @Override
    protected void initDate() {
        CodeUtils.init(this);
    }

    @Override
    protected void initView() {
        sImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CodeUtils.analyzeByImageView(sImage, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SysActivity.this, "" + result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SysActivity.this, "xxxxxxx", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected BasePresenter protectedPresenter() {
        return null;
    }


    @OnClick(R.id.s_button)
    public void onViewClicked() {
        Bitmap image = CodeUtils.createImage("14789325", 444, 444, null);
        sImage.setImageBitmap(image);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.s_s, R.id.s_b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.s_s:
                EventBus.getDefault().post(new EBean("的开发计划", 2));
                break;
            case R.id.s_b:
                EventBus.getDefault().post("字符串");
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEbean(EBean eBean) {
        Toast.makeText(this, "" + eBean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void getSteing(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
