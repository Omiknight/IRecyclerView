package com.cins.irecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cins.irecyclerview.demo1.Activity1;
import com.cins.irecyclerview.demo2.Activity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jump(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_1:
                intent.setClass(this,Activity1.class);
                break;
            case R.id.btn_2:
                intent.setClass(this,Activity2.class);
                break;
        }
        startActivity(intent);
    }
}
