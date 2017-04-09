package com.cins.irecyclerview.demo1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cins.irecyclerview.R;

import java.util.List;

/**
 * Created by Eric on 2017/4/9.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {

    private List<ObjectModel> mDatas;
    public NormalAdapter(List<ObjectModel> data) {
        this.mDatas = data;
    }

    @Override
    public NormalAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(NormalAdapter.VH holder, int position) {
        ObjectModel model = mDatas.get(position);
        holder.number.setText(model.number + "");
        holder.title.setText(model.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //item 点击事件
            }
        });
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
