package com.example.ordering.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.OrdersAdapter;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.OrderModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersFragment extends Fragment {
    private OrdersAdapter ordersAdapter;
    private List<OrderModel> lists;
    private RecyclerView orderRecyclerView;
    private ConstraintLayout btnClosed;
    private EditText closed_bil_note;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseReference orderRef = FirebaseDatabase.getInstance().getReference("orders");
        orderRef.orderByKey().limitToLast(50).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<OrderModel> newList = new ArrayList<>();
                // Lấy dữ liệu từ DataSnapshot và thêm vào newList
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    OrderModel order = orderSnapshot.getValue(OrderModel.class);
                    newList.add(order);
                }
                Collections.reverse(newList); // đảo ngược thứ tự ở đây
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
        closed_bil_note = root.findViewById(R.id.closed_bill_note);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        orderRecyclerView.setLayoutManager(layoutManager);
        orderRecyclerView.setAdapter(ordersAdapter);

        btnClosed=root.findViewById(R.id.btnClosed);
        btnClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy tham chiếu đến nút "orders" trong cơ sở dữ liệu
                DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("orders");

                HashMap<String, Integer> itemQuantities = new HashMap<>();
                final int[] totalQuantity = {0};
                final double[] totalRevenue = {0};
                ordersRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //tính tổng tiền tất cả các đơn hàng
                        for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                            OrderModel order = orderSnapshot.getValue(OrderModel.class);
                            // Lặp qua tất cả các mặt hàng trong đơn hàng và tính toán tổng số lượng của chúng
                            for (CartModel cartItem : order.getProductList()) {
                                String itemName = cartItem.getName();
                                int itemQuantity = 1;

                                if (itemQuantities.containsKey(itemName)) {
                                    int currentQuantity = itemQuantities.get(itemName);
                                    itemQuantities.put(itemName, currentQuantity + itemQuantity);
                                } else {
                                    itemQuantities.put(itemName, itemQuantity);
                                }
                                totalQuantity[0] += itemQuantity;
                            }
                            int num=Integer.parseInt(order.getTotalPrice());
                            totalRevenue[0] += num;
                            // Xóa đơn hàng khỏi cơ sở dữ liệu
                            orderSnapshot.getRef().removeValue();
                        }
                        DatabaseReference summaryRef = FirebaseDatabase.getInstance().getReference("closedBill");
                        String orderId = closed_bil_note.getText().toString();

                        // Lưu trữ tổng số lượng của từng mặt hàng vào child này
                        for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
                            String itemName = entry.getKey();
                            int itemQuantity = entry.getValue();
                            summaryRef.child(orderId).child(itemName).setValue(itemQuantity);
                        }
                        // Lưu trữ tổng số lượng của tất cả các đơn vào child này
                        summaryRef.child(orderId).child("totalQuantity").setValue(totalQuantity[0]);
                        summaryRef.child(orderId).child("totalRevenue").setValue(totalRevenue[0]);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("Firebase", "Lỗi: " + databaseError.getMessage());
                    }
                });
            }
        });

        return root;
    }
}
