package com.bwie.yuel143.base;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:44
 *@Description:${DESCRIPTION}
 * */

import com.bwie.yuel143.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.Iview> implements Contract.Presenter {
    protected WeakReference<V> weakReference;

    public BasePresenter() {
        inisModel();
    }

    protected void onAttach(V iview) {
        weakReference = new WeakReference<>(iview);
    }

    protected void onDesAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected abstract void inisModel();

    protected V get() {
        return weakReference.get();
    }
}
