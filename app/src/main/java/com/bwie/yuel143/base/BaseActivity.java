package com.bwie.yuel143.base;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:46
 *@Description:${DESCRIPTION}
 * */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bwie.yuel143.Contract;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.Iview {
    protected P menter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (inisid() != 0) {
            setContentView(inisid());
            inisView();
            menter = inisPresenter();
            menter.onAttach(this);
        }
        startCoding();
    }

    protected abstract void startCoding();

    protected abstract void inisView();

    protected abstract P inisPresenter();

    protected abstract int inisid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        menter.onDesAttach();
    }
}
