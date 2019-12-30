package com.bawei.mengxyan.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mengxyan.R;
import com.bawei.mengxyan.presenter.bean.Bean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @包名 com.bawei.mengxyan.view
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名MyAdapter
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean.ResultBean> list;

    public MyAdapter(List<Bean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.ll, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Bean.ResultBean resultBean = list.get(position);
        holder.llText.setText(resultBean.getCommodityName());
        Glide.with(holder.llImage).load(resultBean.getMasterPic())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(88)))
                .into(holder.llImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_image)
        ImageView llImage;
        @BindView(R.id.ll_text)
        TextView llText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    SetOnClickListener onClickListener;

    public void setOnClickListener(SetOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface SetOnClickListener {
        void onClickListener(int i);
    }

}
