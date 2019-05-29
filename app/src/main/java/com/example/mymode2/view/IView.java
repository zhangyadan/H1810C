package com.example.mymode2.view;

import com.example.mymode2.beans.UserBeans;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public interface IView {
    void OnSuccess(UserBeans userBeans);
    void OnFailed(String error);
}
