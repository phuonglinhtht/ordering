package com.example.ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.BillAdapter;
import com.example.ordering.adapters.CartAdapter;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.OrderModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity {
    private List<CartModel> productlist;
    TextView Id_bill;
    public String id_bill;
    public RecyclerView bill_rec;
    TextView Note_bill;
    TextView Total_bill;
    private DatabaseReference orderRef;
    private BillAdapter billAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.bill);
        Id_bill = findViewById(R.id.bill_id);
        Note_bill = findViewById(R.id.bill_note);
        Total_bill = findViewById(R.id.bill_total);
        bill_rec=findViewById(R.id.bill_list);

        Intent intent = getIntent();
        if (intent != null) {
            id_bill = intent.getStringExtra("order_id");
            // Khởi tạo DatabaseReference để truy vấn đơn hàng từ Firebase
            orderRef = FirebaseDatabase.getInstance().getReference().child("orders").child(id_bill);
            // Thêm ValueEventListener để lắng nghe sự thay đổi dữ liệu của đơn hàng
            orderRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Lấy dữ liệu của đơn hàng từ DataSnapshot và hiển thị
                        OrderModel order = dataSnapshot.getValue(OrderModel.class);
                        if (order != null) {
                            Id_bill.setText(id_bill);
                            Note_bill.setText(order.getNote());
                            Total_bill.setText(order.getTotalPrice());
                            productlist = order.getProductList();
                            LinearLayoutManager layoutManager = new LinearLayoutManager(BillActivity.this);
                            bill_rec.setLayoutManager(layoutManager);
                            billAdapter = new BillAdapter(productlist);
                            bill_rec.setAdapter(billAdapter);
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
    }
}
