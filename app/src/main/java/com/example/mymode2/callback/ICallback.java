package com.example.mymode2.callback;

import com.example.mymode2.beans.UserBeans;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public interface ICallback {
    void OnSuccess(UserBeans userBeans);
    void OnFailed(String error);
}
