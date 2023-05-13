package com.example.ordering.adapters;

import com.example.homework7.R;
import com.example.ordering.models.HomeVerModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeVerModel> list;
    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list){
        this.context=context;
        this.list= list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.rating.setImageResource(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,rating;
        TextView name,price;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView= itemView.findViewById(R.id.ver_img);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            rating=itemView.findViewById(R.id.rating);
        }
    }
}
