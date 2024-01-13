package com.example.ucsm.studentrecordmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ucsm.studentrecordmanagement.R;
import com.example.ucsm.studentrecordmanagement.WebsiteActivity;
import com.example.ucsm.studentrecordmanagement.model.ComputerUniversity;
import java.util.List;

/**
 * Created by nclwin on 10/30/16.
 */

public class CUAdapter extends RecyclerView.Adapter<CUAdapter.MyViewHolder> {
    private Context mContext;
    private List<ComputerUniversity> cuList;


    @Override
    public CUAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.information_card, parent, false);

        return new CUAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CUAdapter.MyViewHolder holder, final int position) {
        ComputerUniversity CU=cuList.get(position);

        holder.CUname.setText(CU.getCUname());
        Glide.with(mContext).load(CU.getCUImage()).into(holder.CUImage);

        holder.CUImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,WebsiteActivity.class);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });
        holder.CUname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,WebsiteActivity.class);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView CUname;
        public ImageView CUImage;

        public MyViewHolder(View view) {
            super(view);
           CUname = (TextView) view.findViewById(R.id.title);
            CUImage = (ImageView) view.findViewById(R.id.thumbnail);


        }
    }

    public CUAdapter(Context mContext, List<ComputerUniversity> cuList) {
        this.mContext = mContext;
        this.cuList = cuList;
    }
}
