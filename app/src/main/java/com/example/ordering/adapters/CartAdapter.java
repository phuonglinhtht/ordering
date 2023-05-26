package com.example.ordering.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework7.R;
import com.example.ordering.models.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>  {

    private List<CartModel> lists;
    public ConstraintLayout btnDel;

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        CartModel list = lists.get(position);
        holder.imageView.setImageResource(list.getImage());
        holder.name.setText(list.getName());
        holder.price.setText(list.getPrice());
        holder.note.setText(list.getNote());
        holder.btnDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Xóa item trong lists tại vị trí nhấn
                lists.remove(position);
                notifyDataSetChanged();
            }
        });
    }
    public CartAdapter(List<CartModel> lists) {
        this.lists = lists;
    }
    @Override
    public int getItemCount() {
        if (lists == null) {
            return 0;
        }
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView,load;
        public TextView name,price;
        public EditText note;
        public TextView total;
        public ConstraintLayout btnDel;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.detailed_img);
            name=itemView.findViewById(R.id.detailed_name);
            price=itemView.findViewById(R.id.detailed_price);
            note=itemView.findViewById(R.id.detailed_note);
            total=itemView.findViewById(R.id.total);
            btnDel=itemView.findViewById(R.id.btnDel);
            load=imageView.findViewById(R.id.load);
        }
    }
}
