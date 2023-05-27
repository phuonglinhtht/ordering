package com.example.ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.CartAdapter;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.OrderModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private List<CartModel> productlist;
    RecyclerView order_rec;
    TextView order_totalPrice;
    private CartAdapter cartAdapter;
    TextView order_stt;
    TextView order_name;
    public ConstraintLayout btnPay;
    private String orderId;
    private DatabaseReference orderRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
                setContentView(R.layout.order);
        order_name=findViewById(R.id.order_note);
        order_totalPrice=findViewById(R.id.order_total);
        order_rec=findViewById(R.id.order_rec);
        Intent intent = getIntent();
        if (intent != null) {
            orderId = intent.getStringExtra("order_id");
            // Khởi tạo DatabaseReference để truy vấn đơn hàng từ Firebase
            orderRef = FirebaseDatabase.getInstance().getReference().child("orders").child(orderId);
            // Thêm ValueEventListener để lắng nghe sự thay đổi dữ liệu của đơn hàng
            orderRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Lấy dữ liệu của đơn hàng từ DataSnapshot và hiển thị
                        OrderModel order = dataSnapshot.getValue(OrderModel.class);
                        if (order != null) {
                            order_name.setText(order.getNote());
                            order_totalPrice.setText(order.getTotalPrice());
                            productlist=order.getProductList();
                            LinearLayoutManager layoutManager = new LinearLayoutManager(OrderActivity.this);
                            order_rec.setLayoutManager(layoutManager);
                            cartAdapter = new CartAdapter(productlist);
                            order_rec.setAdapter(cartAdapter);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Xử lý lỗi khi truy vấn Firebase bị hủy
                    Log.e("Firebase", "Lỗi: " + databaseError.getMessage());
                }
            });
        }
        btnPay=findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, BillActivity.class);
                intent.putExtra("order_id", orderId); // Truyền thông tin đơn hàng
                startActivity(intent);
            }
        });
    }
}
