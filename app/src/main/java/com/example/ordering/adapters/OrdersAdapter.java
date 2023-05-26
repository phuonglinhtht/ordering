package com.example.ordering.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.models.OrderModel;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder>  {
    private List<OrderModel> lists;
    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder holder, int position) {
        OrderModel list = lists.get(position);
        holder.cost.setText(list.getTotalPrice());
        holder.stt.setText(list.getStt());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cost,stt;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cost=itemView.findViewById(R.id.order_cost);
            stt=itemView.findViewById(R.id.order_stt);
        }
    }
}
