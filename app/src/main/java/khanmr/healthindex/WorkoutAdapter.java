package khanmr.healthindex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {


    private ArrayList<Workout> workoutsList;

    public WorkoutAdapter(ArrayList<Workout> workouts){

        workoutsList = workouts;

    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item_card_row, parent, false);

        WorkoutViewHolder workoutViewHolder = new WorkoutViewHolder(v);

        return workoutViewHolder;

    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position) {

        Workout currentItem = workoutsList.get(position);

        holder.iconView.setImageResource(currentItem.getImageId());
        holder.name.setText(currentItem.getName());
        holder.desc.setText(currentItem.getDesc());

    }

    @Override
    public int getItemCount() {
        return workoutsList.size();
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder{

        public ImageView iconView;
        public TextView name;
        public TextView desc;

        public WorkoutViewHolder(View itemView){

            super(itemView);
            iconView = itemView.findViewById(R.id.workoutImage);
            name = itemView.findViewById(R.id.workoutNameTextView);
            desc = itemView.findViewById(R.id.workoutDescTextView);

        }

    }

}
