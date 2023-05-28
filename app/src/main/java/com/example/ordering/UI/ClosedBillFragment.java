package com.example.ordering.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporder.R;
import com.example.ordering.adapters.ClosedBillAdapter;
import com.example.ordering.models.ClosedBillModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClosedBillFragment extends Fragment {
    private RecyclerView closed_bill_rec;

    public List<ClosedBillModel> lists;
    public ClosedBillAdapter closedBillAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        lists = new ArrayList<>();
        closedBillAdapter = new ClosedBillAdapter(lists);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_closed_bill, container, false);
        closed_bill_rec=view.findViewById(R.id.closed_bill_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        closed_bill_rec.setLayoutManager(layoutManager);
        closed_bill_rec.setAdapter(closedBillAdapter);

        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference("closedBill");
        ordersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    String itemName = orderSnapshot.getKey();
                    Log.e("Firebase", "Lỗi: " + itemName);
                    ClosedBillModel n1=new ClosedBillModel(itemName);
                    lists.add(n1);
                    Log.e("Firebase", "Lỗi: " + lists);
                    closedBillAdapter.notifyDataSetChanged();}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Lỗi: " + databaseError.getMessage());
            }
        });

        return view;
    }
}
