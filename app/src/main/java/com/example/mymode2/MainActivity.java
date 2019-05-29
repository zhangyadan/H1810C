package com.example.mymode2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mymode2.adapters.MyAdapter;
import com.example.mymode2.beans.UserBeans;
import com.example.mymode2.model.Model;
import com.example.mymode2.presenter.Presenter;
import com.example.mymode2.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRexy;
    private ArrayList<UserBeans.DataBean.DatasBean> list;
    private MyAdapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        Presenter presenter = new Presenter(new Model(), this);
        presenter.getData();
    }

    private void initView() {
        mRexy = (RecyclerView) findViewById(R.id.Rexy);

        mRexy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MyAdapter(list, this);
        mRexy.setAdapter(adapter);


    }

    @Override
    public void OnSuccess(UserBeans userBeans) {
        List<UserBeans.DataBean.DatasBean> datas = userBeans.getData().getDatas();
        list.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFailed(String error) {
        Log.i(TAG, "OnFailed: "+error);
    }
}
