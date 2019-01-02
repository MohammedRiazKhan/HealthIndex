package khanmr.healthindex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DietScreen extends AppCompatActivity {

    private RecyclerView dietRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Diet");

        Intent receiveBmi = getIntent();
        String interp = receiveBmi.getStringExtra("diet");

        ArrayList<Diet> diets = new ArrayList<>();

        if(interp.equals("Underweight")){

            diets.add(new Diet(R.drawable.ic_bf, "Breakfast", "Eggs + Sausage"));
            diets.add(new Diet(R.drawable.ic_cutlery, "Lunch", "Meal"));
            diets.add(new Diet(R.drawable.ic_fish, "Snack", "Whole Fish"));
            diets.add(new Diet(R.drawable.ic_meat, "Supper", "Steak"));

        }

        else if(interp.equals("Normal")){

            diets.add(new Diet(R.drawable.ic_bf, "Breakfast", "Eggs Toast"));
            diets.add(new Diet(R.drawable.ic_cutlery, "Lunch", "Meal"));
            diets.add(new Diet(R.drawable.ic_fish, "Snack", "Half Fish"));
            diets.add(new Diet(R.drawable.ic_meat, "Supper", "Steak"));



        }

        else if(interp.equals("Overweight")){

            diets.add(new Diet(R.drawable.ic_bf, "Breakfast", "Eggs + Sausage"));
            diets.add(new Diet(R.drawable.ic_cutlery, "Lunch", "Meal"));
            diets.add(new Diet(R.drawable.ic_fish, "Snack", "Quarter Fish"));
            diets.add(new Diet(R.drawable.ic_meat, "Supper", "Steak"));




        }

        else if(interp.equals("Obese")){


            diets.add(new Diet(R.drawable.ic_bf, "Breakfast", "Eggs + Sausage"));
            diets.add(new Diet(R.drawable.ic_cutlery, "Lunch", "Meal"));
            diets.add(new Diet(R.drawable.ic_fish, "Snack", "Whole Fish"));
            diets.add(new Diet(R.drawable.ic_meat, "Supper", "Steak"));



        }



        dietRecyclerView = findViewById(R.id.dietRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new DietAdapter(diets);

        dietRecyclerView.setLayoutManager(layoutManager);
        dietRecyclerView.setAdapter(adapter);


    }
}
