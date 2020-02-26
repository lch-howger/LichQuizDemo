package com.lich.quizdemo;

import android.view.View;

import com.lich.quizdemo.constant.IntentKey;

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
        startActivityString(PrepareActivity.class, IntentKey.PREPARE_ID, "1");
    }

    public void quiz2(View view) {
        startActivityString(PrepareActivity.class, IntentKey.PREPARE_ID, "2");
    }
}
