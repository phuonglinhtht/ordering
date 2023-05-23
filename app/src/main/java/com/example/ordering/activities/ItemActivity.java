package com.example.ordering.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework7.R;
import com.example.ordering.common.SharedPreference;
import com.example.ordering.models.ItemModel;

public class ItemActivity extends AppCompatActivity {
    TextView name;
    TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.item);
        SetData();
    }
    private void SetData() {
        ItemModel item = SharedPreference.getInstance(getApplicationContext()).getItem();
        if(item.name!= null) name.setText(item.name);
        if(item.price != null) price.setText(item.price);
        if (item.name=="Trà sữa truyền thống")
            item.item_image= R.drawable.bubble_tea_1;item.credit="Trà Sữa Truyền Thống với đậm vị trà hòa kết hợp cùng vị béo thơm của sữa mang đến một thức uống thơm ngon được nhiều người ưa thích.";
    }

}
