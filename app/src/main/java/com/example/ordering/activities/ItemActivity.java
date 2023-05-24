package com.example.ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework7.R;
import com.example.ordering.common.SharedPreference;
import com.example.ordering.models.ItemModel;

public class ItemActivity extends AppCompatActivity {
    TextView name;
    TextView price;
    TextView credit;
    ImageView item_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.item);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        credit=findViewById(R.id.credit);
        item_img=findViewById(R.id.item_img);
        Intent intent = getIntent();
        int imageItem = intent.getIntExtra("ImageItem", 0);
        String nameItem = intent.getStringExtra("NameItem");
        String priceItem = intent.getStringExtra("PriceItem");
        name.setText(nameItem); price.setText(priceItem);
        item_img.setImageResource(imageItem);
        if (name.equals("Trà sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (nameItem.equals("Trà sữa Thái Đỏ")) {credit.setText("Trà Thái đỏ hay còn có tên gọi khác là trà sữa Thái đỏ, trà đá Thái Lan hoặc trà Thái, đây là loại thức uống phổ biến của người dân Thái Lan. Trà khi pha ra có nước mà hổ phách vô cùng đẹp mắt và có hương thơm nhẹ, rất thích hợp làm nguyên liệu để pha trà sữa.");}
        else if (nameItem.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}
        else if (name.equals("Trà Sữa Trân Châu Đường Đen")) {credit.setText("Là sự kết hợp hoàn hảo giữa sữa tươi không đường và trân châu đường đen. Hương vị thanh mát, nhẹ nhàng của sữa tươi hòa quyện với trân châu dẻo dai, ngọt ngào đã tạo nên sức hấp dẫn không thể chối từ của loại đồ uống này..");}

    }

}
