package com.example.ordering.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.example.homework7.R;
import com.example.ordering.models.HomeHorModel;
import com.example.ordering.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>{

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check =true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_1, "Trà sữa truyền thống", R.drawable.best_seller, "20.000"));
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_2, "Trà sữa matcha", R.drawable.transform, "25.000"));
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_3, "Trà sữa ô long kem trứng", R.drawable.best_seller, "30.000"));
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_4, "Trà sữa Thái Xanh", R.drawable.transform, "20.000"));
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_5, "Trà sữa Thái Đỏ", R.drawable.transform, "20.000"));
            homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_6, "Trà sữa Trân Châu Đường Đen", R.drawable.transform, "35.000"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    row_index = position;
                    notifyDataSetChanged();

                    if(position==0){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_1,"Trà sữa truyền thống",R.drawable.best_seller,"20.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_2,"Trà sữa matcha",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_3,"Trà sữa ô long kem trứng",R.drawable.best_seller,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_4,"Trà sữa Thái Xanh",R.drawable.transform,"20.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_5,"Trà sữa Thái Đỏ",R.drawable.transform,"20.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bubble_tea_6,"Trà sữa Trân Châu Đường Đen",R.drawable.transform,"35.000"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position ==1){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_1,"Trà Chanh Ổi",R.drawable.best_seller,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_2,"Trà Xoài",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_3,"Trà Chanh Dây",R.drawable.best_seller,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_4,"Trà Bưởi",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_5,"Trà Đào",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_6,"Trà Dâu",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_7,"Trà Vải",R.drawable.best_seller,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_8,"Trà Dưa Hấu",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_9,"Trà Thanh Long",R.drawable.best_seller,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tea_10,"Trà Trái Cây Nhiệt Đới",R.drawable.transform,"30.000"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position ==2){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_1,"Cà Phê Đen Đá",R.drawable.best_seller,"20.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_2,"Cà Phê Sữa Đá",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_3,"Bạc Xĩu",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_4,"Coffee Jelly",R.drawable.transform,"35.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_5,"Frothy Whipped Coffee",R.drawable.transform,"40.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.coffee_6,"Cà Phê Trứng",R.drawable.best_seller,"30.000"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position ==3){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_1,"Mango - Berry Smoothie",R.drawable.best_seller,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_2,"Kiwi Smoothie",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_3,"Watermelon Smoothie",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_4,"Mango - Banana Smoothie",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_5,"Light Oreo Smoothie",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_6,"Green Tea Matcha Smoothie",R.drawable.best_seller,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_7,"Avocado - Banana Smoothie",R.drawable.best_seller,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_8,"Rainbow Smoothie",R.drawable.best_seller,"40.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.smoothie_9,"Creamy Peach Smoothie",R.drawable.transform,"35.000"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position ==4){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_1,"Bánh Rán",R.drawable.best_seller,"10.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_2,"French Opera Cake",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_3,"Bánh Mì Bơ Tỏi",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_4,"Panna Cotta Xoài",R.drawable.transform,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_5,"Bánh Sừng Trâu",R.drawable.transform,"30.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_6,"Bánh Dâu",R.drawable.best_seller,"25.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_7,"Bánh Flan",R.drawable.best_seller,"10.000"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cake_8,"Bánh Mì Hoa Cúc",R.drawable.best_seller,"30.000"));

                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                }
            });
            if (select){
                if (position==0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else {
                if (row_index==position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                } else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);           }
            }
        }

    @Override
    public int getItemCount(){
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
