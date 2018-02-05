package com.cins.irecyclerview.demo1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.widget.Toast;
import com.cins.irecyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Eric on 2017/4/9.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {

    //final List<Integer> list = new ArrayList<>();

    //1、定义一个集合，用来记录选中
    private List<Boolean> isClicks;

    private List<ObjectModel> mDatas;
    public NormalAdapter(List<ObjectModel> data) {
        this.mDatas = data;

        //3、为集合添加值
        isClicks = new ArrayList<>();
        for(int i = 0;i<mDatas.size();i++){
            isClicks.add(false);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        ObjectModel model = mDatas.get(position);
        holder.number.setText(model.number + "");
        holder.title.setText(model.title);

        holder.title.setTag(position);


        //
        //if (list.contains(position)) {
        //    holder.title.setTextColor(R.color.colorAccent);
        //} else {
        //    holder.title.setTextColor(R.color.colorPrimary);
        //}

        holder.title.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor") @Override
            public void onClick(View view) {
                //item 点击事件
                //if (!list.contains(holder.title.getTag())) {
                //    list.add(position);
                //    holder.title.setTextColor(R.color.bk_color_ddtalk_blue);
                //    notifyDataSetChanged();
                //} else {
                //    for (int i = 0;i <list.size();i++) {
                //        if (list.get(i) == holder.title.getTag()) {
                //            list.remove(i);
                //            holder.title.setTextColor(R.color.colorPrimary);
                //        }
                //    }
                //}

                int position = holder.getLayoutPosition(); // 1
                for(int i = 0; i <isClicks.size();i++){
                    isClicks.set(i,false);
                }
                isClicks.set(position,true);
                notifyDataSetChanged();

                //holder.title.setText("xisfjdajfkjh");
                //notifyItemChanged(position);
                Toast.makeText(view.getContext(),"dd",Toast.LENGTH_SHORT).show();
            }
        });

        //5、记录要更改属性的控件
        holder.itemView.setTag(holder.title);
        holder.itemView.setTag(holder.number);
        //6、判断改变属性
        if(isClicks.get(position)){
            holder.title.setTextColor(Color.parseColor("#ff0000"));
            holder.number.setBackgroundColor(Color.parseColor("#f0f0f0"));
        }else{
            holder.number.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.title.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public final TextView number;
        public VH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            number = (TextView) itemView.findViewById(R.id.number);
        }
    }

}
