package com.example.futsalexplorer.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.futsalexplorer.R;
import com.example.futsalexplorer.model.venue;

import java.util.ArrayList;
import java.util.List;

public class adapt extends RecyclerView.Adapter<adapt.view>{

    List<venue> data;
    private ArrayList<venue> dataList;
    private LayoutInflater inflater;

    public adapt(List<venue> dataList, Context context) {
        this.dataList = (ArrayList<venue>) dataList;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public adapt.view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo, parent, false);
        return new view(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapt.view holder, int position) {

        final venue data = dataList.get(position);

        holder.text1.setText(data.getFutsal_name());
        holder.text2.setText(data.getFutsal_description());
        Glide.with(holder.photo1.getContext()).load("http://10.0.2.2/api/image/"+ data.getImage()).into(holder.photo1);


    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
    class view extends RecyclerView.ViewHolder{
        ImageView photo1;
        TextView text1, text2;

        public view(@NonNull View itemView) {
            super(itemView);
            photo1 = itemView.findViewById(R.id.photo1);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);

        }
    }
    public void updateList(ArrayList<venue> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
}
