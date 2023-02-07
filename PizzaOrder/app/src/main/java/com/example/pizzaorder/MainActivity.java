package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] pizzaNameArray={
            "Margheritta Pizza",
            "Jamon Pizza",
            "Mortadela Pizza",
            "Husevo Pizza",
            "Hongo Pizza",
            "Insulano Pizza",
            "Regina Pizzazza7",
            "Atunero Pizza"
    };

    int[] pizzaPriceArray={
            24,
            26,
            28,
            26,
            26,
            28,
            28,
            29
    };

    String[] pizzaInfoArray = {
        "kelt tészta, paradicsomszósz, oregano, sajt (500gr).",
        "kelt tészta, paradicsomszósz, sajt, sonka (550gr)",
        "kelt tészta, paradicsomszósz, sajt, virsli (550gr)",
        "kelt tészta, paradicsomszósz, sajt, szalámi, hagyma, tojás (580gr)",
        "kelt tészta, paradicsomszósz, sajt, gomba (560gr)",
        "kelt tészta, paradicsomszósz, sajt, sonka, kukorica, ananász (610gr)",
        "kelt tészta, paradicsomszósz, sajt, sonka, szalámi, kukorica, olajbogyó (620gr)",
        "kelt tészta, paradicsomszósz, sajt, tonhal, fokhagymakrém (550gr)",
    };

    int[] pizzaImageArray ={
            R.drawable.MargherittaIMG,
            R.drawable.JamonIMG,
            R.drawable.MortadelaIMG,
            R.drawable.HusevoIMG,
            R.drawable.InsulanoIMG,
            R.drawable.ReginaIMG,
            R.drawable.AtuneroIMG
    };

    private RecyclerView recyclerView;
    private AdapterP adapterP;
    private List<Pizza> pizzaList;
    private Button orderButton;
    private int totalPrice = 0;

    public void onClearClicked(View view) {
        for (Pizza pizza : pizzaList) {
            pizza.setNumber(0);
        }
        adapterP.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaList = new ArrayList<>();

        for (int i = 0; i < pizzaNameArray.length; i++) {
            pizzaList.add(new Pizza(pizzaNameArray[i], pizzaPriceArray[i], pizzaImageArray[i], pizzaInfoArray[i]));
        }

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterP = new AdapterP(pizzaList, this, pizzaImageArray);

        recyclerView.setAdapter(adapterP);

        orderButton = findViewById(R.id.buttonOrder);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPrice = 0;
                for (Pizza pizza : pizzaList) {
                    totalPrice += pizza.getPrice() * pizza.getNumber();
                }
                if (totalPrice > 0){
                    Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                    intent.putExtra("total_price", totalPrice);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please choose at least one pizza!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    }
}