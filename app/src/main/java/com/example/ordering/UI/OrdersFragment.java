package com.example.ordering.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.CartAdapter;
import com.example.ordering.adapters.OrdersAdapter;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.OrderModel;
import com.example.ordering.models.cart;
import com.example.ordering.models.order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {
    private OrdersAdapter ordersAdapter;
    private List<OrderModel> lists;
    private RecyclerView orderRecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                orderRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Lỗi: " + databaseError.getMessage());
            }
        });

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root=inflater.inflate(R.layout.fragment_orders,container,false);
        orderRecyclerView = root.findViewById(R.id.order_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        orderRecyclerView.setLayoutManager(layoutManager);
        orderRecyclerView.setAdapter(ordersAdapter);
        return root;
    }
}
