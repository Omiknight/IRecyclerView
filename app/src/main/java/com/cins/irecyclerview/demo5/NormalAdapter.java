package com.cins.irecyclerview.demo5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cins.irecyclerview.R;

import java.util.List;

/**
 * Created by Eric on 2017/4/11.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH>{
    private List<String> mDatas;

    public NormalAdapter(List<String> datas) {
        mDatas = datas;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_5, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        public final TextView title;
        public VH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
