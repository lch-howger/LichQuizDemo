package com.lich.quizdemo;

import android.view.View;
import android.widget.ListView;

import com.lich.quizdemo.adapter.StatAdapter;
import com.lich.quizdemo.entity.ResultEntity;
import com.lich.quizdemo.util.StatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class StatActivity extends BaseActivity {

    private ListView lv;
    private List<ResultEntity> list = new ArrayList<>();
    private StatAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stat;
    }

    @Override
    public void initViews() {
        lv = findViewById(R.id.lv);
        adapter = new StatAdapter(list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<ResultEntity> resultList = StatUtil.getResultList();
        list.clear();
        list.addAll(resultList);
        adapter.notifyDataSetChanged();
    }
}
