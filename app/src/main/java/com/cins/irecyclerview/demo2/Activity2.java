package com.cins.irecyclerview.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cins.irecyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView局部刷新
 * Created by Eric on 2017/4/10.
 */

public class Activity2 extends AppCompatActivity {
    public static final String ACTION_UPDATE_PROGRESS = "action_update_progress";
    public static final String KEY_POSITION = "key_position";
    public static final String KEY_PROGRESS = "key_progress";

    private ListView mListView;
    private List<Job> mData;
    private DownloadAdapter mAdapter;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int position = intent.getIntExtra(KEY_POSITION, -1);
            int progress = intent.getIntExtra(KEY_PROGRESS, -1);
            if(position != -1 && progress != -1) {
                Job job = mData.get(position);
                job.progress = progress;
                mAdapter.notifyItemChanged(mListView, position);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mListView = (ListView) findViewById(R.id.lv);
        mAdapter = new DownloadAdapter(this, initData());
        mListView.setAdapter(mAdapter);
        IntentFilter filter = new IntentFilter(ACTION_UPDATE_PROGRESS);
        registerReceiver(mReceiver, filter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    List<Job> initData(){
        String[] urls = this.getResources().getStringArray(R.array.download_array);
        mData = new ArrayList<>();
        for(String url : urls){
            Job job = new Job();
            job.name = url.substring(0,10);
            job.progress = 0;
            job.url = url;
            mData.add(job);
        }
        return mData;
    }
}
