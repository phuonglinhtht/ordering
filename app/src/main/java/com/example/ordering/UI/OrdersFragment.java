package com.example.ordering.UI;

import android.os.Bundle;
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

public class OrdersFragment extends Fragment {
    private OrdersAdapter ordersAdapter;
    private RecyclerView orderRecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root=inflater.inflate(R.layout.fragment_orders,container,false);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
       // orderRecyclerView.setLayoutManager(layoutManager);
        //orderRecyclerView.setAdapter(ordersAdapter);
        return root;
    }
}
