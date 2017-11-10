package com.example.segundoauqui.foodcatolog.view.mainview;

import com.example.segundoauqui.foodcatolog.BasePresenter;
import com.example.segundoauqui.foodcatolog.BaseView;

/**
 * Created by segundoauqui on 11/9/17.
 */

public interface MainViewContract {

    interface View extends BaseView {

        void onDataSaved(boolean isSaved);
        void sendToView(String s);
    }
    interface Presenter extends BasePresenter<View> {
        void saveDataToCloud(String s);
        void getDataToCloud();
    }
}
