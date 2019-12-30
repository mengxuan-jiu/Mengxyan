package com.bawei.mengxyan.contract;

import android.widget.ImageView;

import com.bawei.mengxyan.presenter.bean.Bean;

/**
 * @包名 com.bawei.mengxyan.contract
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名IContract
 **/
public interface IContract {
    interface IView {
     void homeSuccess(Bean bean);
     void homeFil(Throwable throwable);
    }


    interface IPresenter {
   void homeDaet();
    }

    interface IModel {
        void homeDaet(ImView imView);

        interface ImView {
            void homeSuccess(Bean bean);
            void homeFil(Throwable throwable);
        }
    }
}
