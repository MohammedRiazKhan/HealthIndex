package khanmr.healthindex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class WorkoutScreen extends AppCompatActivity {

    private RecyclerView workoutRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exercise");

        Intent receiveBmi = getIntent();
        String interp = receiveBmi.getStringExtra("workout");

        ArrayList<Workout> workouts = new ArrayList<>();

        if(interp.equals("Underweight")){

            workouts.add(new Workout(R.drawable.ic_exercise_2, "Sit Ups", "15 Situps"));
            workouts.add(new Workout(R.drawable.run, "Slow Jog", "5m Jog"));
            workouts.add(new Workout(R.drawable.ic_weights, "1KG Weight", "2 Sets, 10 Reps"));
            workouts.add(new Workout(R.drawable.ic_cycling, "Slow Cycling", "1 Million Km"));
            workouts.add(new Workout(R.drawable.ic_hiking, "Small Hike", "Mt Everest"));
            workouts.add(new Workout(R.drawable.ic_swim, "Swim", "20m"));
            workouts.add(new Workout(R.drawable.ic_run, "Sprint", "10 Minutes"));
            workouts.add(new Workout(R.drawable.ic_walk, "Walk", "Walk a kilometre"));

        }

        else if(interp.equals("Normal")){


            workouts.add(new Workout(R.drawable.ic_exercise_2, "Sit Ups", "10 Situps"));
            workouts.add(new Workout(R.drawable.run, "Slow Jog", "2.5m Jog"));
            workouts.add(new Workout(R.drawable.ic_weights, "1KG Weight", "3 Sets, 10 Reps"));
            workouts.add(new Workout(R.drawable.ic_cycling, "Slow Cycling", "1km"));
            workouts.add(new Workout(R.drawable.ic_hiking, "Hike", "1hr"));
            workouts.add(new Workout(R.drawable.ic_swim, "Swim", "20 min"));
            workouts.add(new Workout(R.drawable.ic_run, "Sprint", "5 min"));
            workouts.add(new Workout(R.drawable.ic_walk, "Walk", "10 min"));


        }

        else if(interp.equals("Overweight")){

            workouts.add(new Workout(R.drawable.ic_exercise_2, "Sit Ups", "20 Situps"));
            workouts.add(new Workout(R.drawable.run, "Jog", "15m Jog"));
            workouts.add(new Workout(R.drawable.ic_weights, "500g Weight", "2 Sets, 12 Reps"));
            workouts.add(new Workout(R.drawable.ic_cycling, "Cycling", "0.5 Km"));
            workouts.add(new Workout(R.drawable.ic_hiking, "Hike", "30 min"));
            workouts.add(new Workout(R.drawable.ic_swim, "Swim", "20 min"));
            workouts.add(new Workout(R.drawable.ic_run, "Sprint", "5 min"));
            workouts.add(new Workout(R.drawable.ic_walk, "Walk", "1hr"));
        }

        else if(interp.equals("Obese")){


            workouts.add(new Workout(R.drawable.ic_exercise_2, "Sit Ups", "20 Situps"));
            workouts.add(new Workout(R.drawable.run, "Jog", "10m Jog"));
            workouts.add(new Workout(R.drawable.ic_weights, "500g Weight", "4 Sets, 4 Reps"));
            workouts.add(new Workout(R.drawable.ic_cycling, "Cycling", "0.5 Km"));
            workouts.add(new Workout(R.drawable.ic_hiking, "Hike", "40 min"));
            workouts.add(new Workout(R.drawable.ic_swim, "Swim", "30 min"));
            workouts.add(new Workout(R.drawable.ic_run, "Sprint", "10 min"));
            workouts.add(new Workout(R.drawable.ic_walk, "Walk", "2hr"));


        }

        workoutRecyclerView = findViewById(R.id.workoutRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new WorkoutAdapter(workouts);

        workoutRecyclerView.setLayoutManager(layoutManager);
        workoutRecyclerView.setAdapter(adapter);

    }
}
