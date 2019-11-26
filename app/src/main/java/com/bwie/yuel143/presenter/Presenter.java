package com.bwie.yuel143.presenter;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:44
 *@Description:${DESCRIPTION}
 * */

import com.bwie.yuel143.Contract;
import com.bwie.yuel143.base.BasePresenter;
import com.bwie.yuel143.imodel.IMolder;

public class Presenter extends BasePresenter {

    private Contract.IMolder iMolder;

    @Override
    protected void inisModel() {
        iMolder = new IMolder();
    }

    @Override
    public void onstart(String url) {
        iMolder.onget(url, new Contract.MycallBack() {
            @Override
            public void onsuccess(String json) {
                get().onsuccess(json);
            }

            @Override
            public void onerror(String error) {
                get().onerror(error);
            }
        });
    }
}
