package com.example.ordering.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.models.CartModel;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder>  {

    private List<CartModel> lists;
    @NonNull
    @Override
    public BillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BillAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BillAdapter.ViewHolder holder, int position) {
        CartModel list = lists.get(position);
        holder.name.setText(list.getName());
        holder.price.setText(list.getPrice());
    }


    @Override
    public int getItemCount() {
        if (lists == null) {
            return 0;
        }
        return lists.size();}
    public BillAdapter(List<CartModel> lists) {
        this.lists = lists;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,price;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.bill_item_name);
            price=itemView.findViewById(R.id.bill_item_price);
        }
    }
}
