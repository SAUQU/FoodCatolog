package com.example.segundoauqui.foodcatolog;

/**
 * Created by segundoauqui on 11/9/17.
 */

public interface BasePresenter  <V extends  BaseView> {
    void attachView(V view);
    void detachView();

}
