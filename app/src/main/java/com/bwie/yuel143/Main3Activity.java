package com.bwie.yuel143;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button color;
    private Button alert;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        color = (Button) findViewById(R.id.color);
        alert = (Button) findViewById(R.id.alert);
        web = (WebView) findViewById(R.id.web);

        color.setOnClickListener(this);
        alert.setOnClickListener(this);
        web.addJavascriptInterface(new JsDemo(), "android");
        web.loadUrl("https://abnerming8.github.io/abnerming.html");
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.color:
                web.loadUrl("javascript:changeColor('#8402')");
                break;
            case R.id.alert:
                web.loadUrl("javascript:toast()");
                break;
        }
    }

    class JsDemo {
        @JavascriptInterface
        public void show() {
            Toast.makeText(Main3Activity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
        }

    }
}
