package khanmr.healthindex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietViewHolder> {


    private ArrayList<Diet> dietsList;

    public DietAdapter(ArrayList<Diet> diets){

        dietsList = diets;

    }

    @Override
    public DietViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_item_card_row, parent, false);

        DietViewHolder workoutViewHolder = new DietViewHolder(v);

        return workoutViewHolder;

    }

    @Override
    public void onBindViewHolder(DietViewHolder holder, int position) {

        Diet currentItem = dietsList.get(position);

        holder.iconView.setImageResource(currentItem.getImageId());
        holder.name.setText(currentItem.getName());
        holder.desc.setText(currentItem.getDesc());

    }

    @Override
    public int getItemCount() {
        return dietsList.size();
    }

    public static class DietViewHolder extends RecyclerView.ViewHolder{

        public ImageView iconView;
        public TextView name;
        public TextView desc;

        public DietViewHolder(View itemView){

            super(itemView);
            iconView = itemView.findViewById(R.id.dietImage);
            name = itemView.findViewById(R.id.dietNameTextView);
            desc = itemView.findViewById(R.id.dietDescTextView);

        }

    }

}
