package com.cins.irecyclerview.demo4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cins.irecyclerview.R;

import java.util.List;

/**
 * Created by Eric on 2017/4/11.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.VH> {


    List<Image> mData;

    public ImageAdapter(List<Image> data) {
        mData = data;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_4, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        final Image image = mData.get(position);
        holder.mTextView.setText(image.name);
        holder.mImageView.setImageResource(image.id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.name = "kadfj";
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        public VH(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
