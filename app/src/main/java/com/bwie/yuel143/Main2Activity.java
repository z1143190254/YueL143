package com.bwie.yuel143;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_1;
    private Button button_1;
    private Myline myline;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        edit_1 = (EditText) findViewById(R.id.edit_1);
        button_1 = (Button) findViewById(R.id.button_1);
        myline = (Myline) findViewById(R.id.myline);

        button_1.setOnClickListener(this);
        myline.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                name = edit_1.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    myline.onAddAth(name);
                }
                break;
            case R.id.myline:
                Intent intent = getIntent();
                intent.putExtra("name", name);
                setResult(100, intent);
                finish();
                break;

        }
    }


}
