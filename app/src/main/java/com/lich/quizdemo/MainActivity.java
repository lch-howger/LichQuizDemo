package com.lich.quizdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    public void edit(View view) {
        startActivity(EditActivity.class);
    }

    public void start(View view) {
        startActivity(QuizActivity.class);
    }

    public void stat(View view) {
        startActivity(StatActivity.class);
    }
}
