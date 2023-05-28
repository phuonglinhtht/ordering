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

import com.example.apporder.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Closed_billActivity extends AppCompatActivity {
    TextView name_closed_bill_item;
    ListView list_closed_bill_item_count,list_closed_bill_item_name;
    String id_bill;

    private DatabaseReference orderRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.closed_bill);
        name_closed_bill_item = findViewById(R.id.name_closed_bill_item);
        list_closed_bill_item_count = findViewById(R.id.list_closed_bill_item_count);
        list_closed_bill_item_name = findViewById(R.id.list_closed_bill_item_name);
        Intent intent = getIntent();
        if (intent != null) {
            id_bill = intent.getStringExtra("closed_bill_id");
            // Khởi tạo DatabaseReference để truy vấn đơn hàng từ Firebase
            orderRef = FirebaseDatabase.getInstance().getReference().child("closedBill").child(id_bill);
            // Thêm ValueEventListener để lắng nghe sự thay đổi dữ liệu của đơn hàng
            orderRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Lấy dữ liệu từ DataSnapshot và thêm vào danh sách
                        List<String> itemList = new ArrayList<>();
                        List<String> itemList1 = new ArrayList<>();
                        for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                            Long itemValue = itemSnapshot.getValue(Long.class);
                            String count = String.valueOf(itemValue);
                            itemList.add(count);
                            String name=itemSnapshot.getKey();
                            itemList1.add(name);
                        }
                        // Tạo Adapter và gắn danh sách vào Adapter
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Closed_billActivity.this, android.R.layout.simple_list_item_1, itemList);
                        // Gắn Adapter cho ListView
                        list_closed_bill_item_count.setAdapter(adapter);
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(Closed_billActivity.this, android.R.layout.simple_list_item_1, itemList1);
                        // Gắn Adapter cho ListView
                        list_closed_bill_item_name.setAdapter(adapter1);
                        name_closed_bill_item.setText(id_bill);
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
