package com.bwie.yuel143;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwie.yuel143.adapter.MyBase;
import com.bwie.yuel143.base.BaseActivity;
import com.bwie.yuel143.base.BasePresenter;
import com.bwie.yuel143.bean.StudentBean;
import com.bwie.yuel143.presenter.Presenter;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends BaseActivity {

    private EditText edit;
    private Button button;
    private RecyclerView recy;
    private String name;


    @Override
    protected void startCoding() {

    }

    @Override
    protected void inisView() {
        edit = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.button);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new GridLayoutManager(this, 2));
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 100);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode(name) + "&page=1&count=5";
                menter.onstart(url);
            }
        });
    }

    @Override
    protected BasePresenter inisPresenter() {
        return new Presenter();
    }

    @Override
    protected int inisid() {
        return R.layout.activity_main;
    }

    @Override
    public void onsuccess(String json) {
        StudentBean studentBean = new Gson().fromJson(json, StudentBean.class);
        List<StudentBean.ResultBean> result = studentBean.getResult();
        MyBase myBase = new MyBase(MainActivity.this, result);
        recy.setAdapter(myBase);
        myBase.onSetClick(new MyBase.Click() {
            @Override
            public void onsetClick(int posion) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onerror(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 100) {
            name = data.getStringExtra("name");
        }
        edit.setText(name);
    }
}
