package com.example.ordering.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.CartAdapter;
import com.example.ordering.models.CartModel;
import com.example.ordering.models.OrderModel;
import com.example.ordering.models.cart;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class CartFragment extends Fragment{
    private RecyclerView cartRecyclerView;
    private List<CartModel> lists;
    private CartAdapter  cartAdapter;
    TextView total;
    ImageView load;
    private EditText note;
    ConstraintLayout btnOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lấy danh sách sản phẩm từ Cart
        lists = cart.getInstance().getProducts();
        cartAdapter = new CartAdapter(lists);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        cartRecyclerView = view.findViewById(R.id.cart_rec);
        note=view.findViewById(R.id.cart_note);
        total=view.findViewById(R.id.total);
        int totalPrice = 0;
        for (CartModel item : lists) {
            int num = Integer.parseInt(item.getPrice());
            totalPrice += num;
        }
        String strNum = Integer.toString(totalPrice);
        total.setText(strNum);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        cartRecyclerView.setLayoutManager(layoutManager);
        cartRecyclerView.setAdapter(cartAdapter);

        load = view.findViewById(R.id.load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CartFragment fragment = new CartFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        btnOrder=view.findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cart_note = note.getText().toString();
                lists = cart.getInstance().getProducts();
                String totalPrice = strNum;
                OrderModel order = new OrderModel(lists,cart_note,totalPrice,"Chưa thanh toán...");

                //đưa dữ liệu order lên firebase
                DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("orders");
                String orderId = ordersRef.push().getKey(); // Tạo một key duy nhất cho đơn hàng
                ordersRef.child(orderId).setValue(order);

                lists.clear();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment fragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
