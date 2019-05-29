package com.example.mymode2.presenter;

import com.example.mymode2.beans.UserBeans;
import com.example.mymode2.callback.ICallback;
import com.example.mymode2.model.Model;
import com.example.mymode2.view.IView;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class Presenter implements IPersenter,ICallback{
    private Model mModelm;
    private IView mIViewm;

    public Presenter(Model model, IView IView) {
        mModelm = model;
        mIViewm = IView;
    }

    @Override
    public void getData() {
        mModelm.getData(this);
    }

    @Override
    public void OnSuccess(UserBeans userBeans) {
        mIViewm.OnSuccess(userBeans);
    }

    @Override
    public void OnFailed(String error) {
        mIViewm.OnFailed(error);
    }
}
