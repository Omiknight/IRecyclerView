package com.cins.irecyclerview.demo6;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 万能Adapter方案
 * Created by Eric on 2017/4/11.
 */

public abstract class QuickAdapter<T> extends RecyclerView.Adapter<QuickAdapter.VH>{

    private List<T> mDatas;

    public QuickAdapter(List<T> datas) {
        this.mDatas = datas;
    }
    //根据 viewType 返回布局 ID
    public abstract int getLayoutId(int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return VH.get(parent, getLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        convert(holder, mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //convert()做具体的bind操作
    public abstract void convert(VH holder, T data, int position);

    /**
     *  通过 SparseArray<View> 存储 item view 的控件，getView(int id) 的功能就是通过 id 获得对应的 View
     * （首先在 mViews 中查询是否存在，如果没有，那么 findViewById() 并放入 mViews 中，避免下次再执行 findViewById()）。
     */
    static class VH extends RecyclerView.ViewHolder{
        private SparseArray<View> mViews;
        private View mConvertView;

        private VH(View itemView) {
            super(itemView);
            mConvertView = itemView;
            mViews = new SparseArray<>();
        }

        public static VH get(ViewGroup parent, int layoutId) {
            View convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            return new VH(convertView);
        }

        public <T extends View> T getView(int id){
            View v = mViews.get(id);
            if(v == null){
                v = mConvertView.findViewById(id);
                mViews.put(id, v);
            }
            return (T)v;
        }

        public void setText(int id, String value){
            TextView view = getView(id);
            view.setText(value);
        }
    }
}
