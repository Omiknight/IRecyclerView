package com.cins.irecyclerview.demo4;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cins.irecyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决闪烁和点击 Item 变色
 * Created by Eric on 2017/4/11.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.VH> {

  List<Image> mData;
  //1、定义一个集合，用来记录选中
  private List<Boolean> isClicks;

  public ImageAdapter(List<Image> data) {
    mData = data;

    //3、为集合添加值
    isClicks = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      isClicks.add(false);
    }
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_4, parent, false);
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(final VH holder, final int position) {
    final Image image = mData.get(position);
    holder.mTextView.setText(image.name);
    holder.mImageView.setImageResource(image.id);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        image.name = "kadfj";

        int position = holder.getLayoutPosition(); // 1
        for (int i = 0; i < isClicks.size(); i++) {
          isClicks.set(i, false);
        }
        isClicks.set(position, true);
        notifyDataSetChanged();

        //notifyItemChanged(position);
      }
    });

    //5、记录要更改属性的控件
    holder.itemView.setTag(holder.mTextView);

    //6、判断改变属性
    if (isClicks.get(position)) {
      holder.mTextView.setTextColor(Color.parseColor("#ff0000"));
    } else {

      holder.mTextView.setTextColor(Color.parseColor("#000000"));
    }
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
