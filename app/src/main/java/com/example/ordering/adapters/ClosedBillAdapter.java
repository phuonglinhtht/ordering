package com.example.ordering.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.activities.Closed_billActivity;
import com.example.ordering.activities.OrderActivity;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.ClosedBillModel;

import java.util.List;

public class ClosedBillAdapter extends RecyclerView.Adapter<ClosedBillAdapter.ViewHolder>  {
    private List<ClosedBillModel> lists;

    @NonNull
    @Override
    public ClosedBillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.closed_bill_item,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ClosedBillAdapter.ViewHolder holder, int position) {
        ClosedBillModel list = lists.get(position);
        holder.name.setText(list.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Closed_billActivity.class);
                intent.putExtra("closed_bill_id",list.getName()); // Chuyển id đơn hàng được chọn
                v.getContext().startActivity(intent);
            }
        });
    }


    public ClosedBillAdapter(List<ClosedBillModel> lists) {
        this.lists = lists;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.bill_item_namem);
        }
    }
}
