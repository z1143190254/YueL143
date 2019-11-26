package com.bwie.yuel143.until;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:38
 *@Description:${DESCRIPTION}
 * */

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwie.yuel143.app.Appcotion;

public class Until {
    private static final Until ourInstance = new Until();
    private final RequestQueue requestQueue;

    public static Until getInstance() {
        return ourInstance;
    }

    private Until() {
        requestQueue = Volley.newRequestQueue(Appcotion.context);
    }

    public void onget(String url, final Mycallback mycallback) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallback.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallback.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public void onpost(String url, final Mycallback mycallback) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallback.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallback.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface Mycallback {
        void onsuccess(String json);

        void onError(String error);
    }
}
