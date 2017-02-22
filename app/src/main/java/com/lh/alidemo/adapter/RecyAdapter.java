package com.lh.alidemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lh.alidemo.R;

/**
 * Created by Liaohuan on 2017/2/22.
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.RecyViewHolder> {
    public RecyAdapter(Context context) {
        mContext = context;
    }

    Context mContext;


    @Override
    public RecyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recy_item, parent, false);

        return new RecyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyViewHolder holder, int position) {
        holder.mTextView.append(position+"");
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class RecyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public RecyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
