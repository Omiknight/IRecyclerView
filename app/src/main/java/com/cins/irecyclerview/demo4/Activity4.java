package com.cins.irecyclerview.demo4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.cins.irecyclerview.R;
import com.cins.irecyclerview.demo1.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.cins.irecyclerview.R.id.rv;

/**
 * 坑：RecyclerView局部更新时，闪屏
 * Created by Eric on 2017/4/11.
 */

public class Activity4 extends AppCompatActivity {
    private RecyclerView mRv;
    private List<Image> mData;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        mRv = (RecyclerView) findViewById(rv);
        mData = initData();
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ImageAdapter(mData);
        //解决办法很简单，在rv.setAdapter()之前调用((SimpleItemAnimator)rv.getItemAnimator()).setSupportsChangeAnimations(false)禁用change动画
        ((SimpleItemAnimator)mRv.getItemAnimator()).setSupportsChangeAnimations(false);
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    public List<Image> initData() {
        List<Image> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Image image = new Image();
            image.id = R.drawable.bg;
            image.name = "bg";
            list.add(image);
        }
        return list;
    }
}
