package com.bawei.mengxyan.presenter;

import com.bawei.mengxyan.base.BasePresenter;
import com.bawei.mengxyan.contract.IContract;
import com.bawei.mengxyan.model.HomeModel;
import com.bawei.mengxyan.presenter.bean.Bean;

/**
 * @包名 com.bawei.mengxyan.model
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名HomeModel
 **/
public class HomePresenter extends BasePresenter<IContract.IView> implements IContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void homeDaet() {
        homeModel.homeDaet(new IContract.IModel.ImView() {
            @Override
            public void homeSuccess(Bean bean) {
                view.homeSuccess(bean);
            }

            @Override
            public void homeFil(Throwable throwable) {
                view.homeFil(throwable);
            }
        });
    }
}
