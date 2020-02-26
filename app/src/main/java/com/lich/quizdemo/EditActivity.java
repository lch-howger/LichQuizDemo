package com.lich.quizdemo;

import android.view.View;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class EditActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    public void initViews() {

    }

    public void pool(View view) {
        startActivity(PoolActivity.class);
    }

    public void quiz1(View view) {

    }

    public void quiz2(View view) {

    }
}
