package com.lich.quizdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.lich.quizdemo.util.StringUtil;

/**
 * Created by lichhowger on 2020/2/26.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public BaseActivity ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;

        setContentView(getLayoutId());
        initViews();
    }

    public abstract int getLayoutId();

    public abstract void initViews();

    public void startActivity(Class clazz) {
        Intent intent = new Intent(ctx, clazz);
        startActivity(intent);
    }

    public String getString(EditText editText) {
        String str = editText.getText().toString().trim();
        return str;
    }

    public void showToast(String text) {
        if (!StringUtil.isEmpty(text)) {
            Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show();
        }
    }

    public void showReminderDialog(String content) {
        new AlertDialog.Builder(this).setMessage(content).setPositiveButton("好的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    public void startActivityString(Class clazz, String key, String value) {
        Intent intent = new Intent(ctx, clazz);
        intent.putExtra(key, value);
        startActivity(intent);
    }
}
