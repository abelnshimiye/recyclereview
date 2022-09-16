package com.example.meeting;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int image[];
    String description[], nameoflanguage[];
    Context context;

    public MyAdapter(int[] image, String[] description, String[] nameoflanguage, Context context) {
        this.image = image;
        this.description = description;
        this.nameoflanguage = nameoflanguage;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textname.setText(nameoflanguage[position]);
        holder.textdescription.setText(description[position]);
        holder.myImage.setImageResource(image[position]);

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("nameoflaguage",nameoflanguage[position]);
                intent.putExtra("description",description[position]);
                intent.putExtra("image",image[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textname, textdescription;
        ImageView myImage;
        ConstraintLayout row;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.textView_name);
            textdescription = itemView.findViewById(R.id.textView_description);
            myImage = itemView.findViewById(R.id.imageView_laguage);
            row = itemView.findViewById(R.id.row);
        }
    }

}
