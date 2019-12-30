package com.bawei.mengxyan.model;

import com.bawei.mengxyan.contract.IContract;
import com.bawei.mengxyan.presenter.bean.Bean;
import com.bawei.mengxyan.util.NetUtil;
import com.google.gson.Gson;

/**
 * @包名 com.bawei.mengxyan.model
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名HomeModel
 **/
public class HomeModel implements IContract.IModel {
    @Override
    public void homeDaet(ImView imView) {
        NetUtil.getInstance().getJson("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=10&keyword=%E6%89%8B%E6%9C%BA", new NetUtil.ImyCback() {
            @Override
            public void doGetSering(String s) {
                imView.homeSuccess(new Gson().fromJson(s, Bean.class));
            }

            @Override
            public void doErro(Throwable throwable) {
                imView.homeFil(throwable);
            }
        });
    }
}
