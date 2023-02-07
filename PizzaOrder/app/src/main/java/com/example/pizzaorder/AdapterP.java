package com.example.pizzaorder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterP extends RecyclerView.Adapter<AdapterP.ViewHolder> {
    private List<Pizza> pizzaList;
    private int[] imageArray;
    private int number;
    private Context context;

    public AdapterP(List<Pizza> pizzaList, Context context, int[] imageArray) {
        this.pizzaList = pizzaList;
        this.context = context;
        this.imageArray = imageArray;
        this.number = 0;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            final Pizza pizza = pizzaList.get(position);
            holder.nameTextView.setText(pizza.getName());
            holder.priceTextView.setText(String.valueOf(pizza.getPrice())+" RON");
            holder.pizzaImageView.setImageResource(pizza.getImage());
            holder.numberTextView.setText(String.valueOf(pizza.getNumber()));
            pizza.setImageId(imageArray[position]);

            holder.minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pizza.getNumber() > 0) {
                        pizza.setNumber(pizza.getNumber() - 1);
                        holder.numberTextView.setText(String.valueOf(pizza.getNumber()));
                    }
                }
            });

            holder.plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pizza.setNumber(pizza.getNumber() + 1);
                    holder.numberTextView.setText(String.valueOf(pizza.getNumber()));
                }
            });

            holder.pizzaImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    Pizza selectedPizza = pizzaList.get(position);
                    Intent intent = new Intent(context, PizzaInfoActivity.class);
                    intent.putExtra("pizza", selectedPizza);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return pizzaList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView pizzaImageView;
            TextView nameTextView;
            TextView priceTextView;
            Button plusButton;
            Button minusButton;
            TextView numberTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                pizzaImageView = itemView.findViewById(R.id.pizza_image_view);
                nameTextView = itemView.findViewById(R.id.name_text_view);
                priceTextView = itemView.findViewById(R.id.price_text_view);
                plusButton = itemView.findViewById(R.id.plus_button);
                minusButton = itemView.findViewById(R.id.minus_button);
                numberTextView = itemView.findViewById(R.id.number_text_view);
            }
        }
}
