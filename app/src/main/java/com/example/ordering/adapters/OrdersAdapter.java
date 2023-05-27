package com.example.ordering.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.activities.ItemActivity;
import com.example.ordering.activities.OrderActivity;
import com.example.ordering.models.OrderModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    private List<OrderModel> orders;

    public OrdersAdapter(List<OrderModel> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder holder, int position) {
        OrderModel order = orders.get(position);
        holder.name.setText(order.getNote());
        holder.cost.setText(order.getTotalPrice());
        holder.stt.setText(order.getStt());
        DatabaseReference orderRef = FirebaseDatabase.getInstance().getReference("orders");
        orderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<OrderModel> newList = new ArrayList<>();
                // Lấy dữ liệu từ DataSnapshot và thêm vào newList
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    OrderModel order = orderSnapshot.getValue(OrderModel.class);
                    newList.add(order);
                }
                OrdersAdapter adapter = new OrdersAdapter(newList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Lỗi: " + databaseError.getMessage());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("order_id", order.getId()); // Chuyển id đơn hàng được chọn
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cost, stt, name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.order_name);
            cost = itemView.findViewById(R.id.order_cost);
            stt = itemView.findViewById(R.id.order_stt);
        }
    }
}
