package com.bwie.yuel143.imodel;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:43
 *@Description:${DESCRIPTION}
 * */

import com.bwie.yuel143.Contract;
import com.bwie.yuel143.until.Until;

public class IMolder implements Contract.IMolder {


    @Override
    public void onget(String url, final Contract.MycallBack mycallBack) {
        Until.getInstance().onget(url, new Until.Mycallback() {
            @Override
            public void onsuccess(String json) {
                mycallBack.onsuccess(json);
            }

            @Override
            public void onError(String error) {
                mycallBack.onerror(error);
            }
        });
    }

    @Override
    public void onpost(String url, Contract.MycallBack mycallBack) {

    }
}
