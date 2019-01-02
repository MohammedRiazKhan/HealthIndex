package khanmr.healthindex;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class BMIDialog extends AppCompatDialogFragment {

    private TextInputLayout height, weight;
    private FragmentDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.bmi_dialog, null);

        builder.setView(view)
                .setTitle("Calculate BMI")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        double heights = 0, weights = 0;

                        String heightOf = height.getEditText().getText().toString().trim();

                        if(heightOf.isEmpty()){

                            height.setError("Height can't be empty");

                        }
                        else{

                            height.setError(null);
                            heights = Double.parseDouble(heightOf);

                        }

                        String weightOf = weight.getEditText().getText().toString().trim();

                        if(weightOf.isEmpty()){

                            weight.setError("Weight can't be empty");

                        }
                        else{

                            weight.setError(null);
                            weights = Double.parseDouble(weightOf);

                        }

                        if(!heightOf.isEmpty() && !weightOf.isEmpty()){

                            heights = Double.parseDouble(heightOf);
                            weights = Double.parseDouble(weightOf);

                            listener.receiveValues(heights, weights);

                        }


                    }
                });


        height = (TextInputLayout) view.findViewById(R.id.height);
        weight = (TextInputLayout) view.findViewById(R.id.weight);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (FragmentDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Implement example dialog listener");
        }

    }

    public interface FragmentDialogListener{

        void receiveValues(double height, double weight);

    }



}
