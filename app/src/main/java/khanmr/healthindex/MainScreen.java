package khanmr.healthindex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BMIDialog.FragmentDialogListener {


    private FloatingActionButton fab;
    private TextView resultTextView, resultView, nothingToShowView, interpretationView, interpretaion;

    String interp = "";
    double bmi = 0;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        initGenComponents();
        initComponents();

        prefs = getSharedPreferences("BMI", MODE_PRIVATE);

        if(prefs.contains("interp")){

            getPrefs();

        }

    }

    private void initGenComponents(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BMIDialog bmiDialog = new BMIDialog();
                bmiDialog.show(getSupportFragmentManager(), "FragmentDialog");

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void initComponents(){

        resultTextView = (TextView) findViewById(R.id.resultText);
        resultView = (TextView) findViewById(R.id.result);

        nothingToShowView = (TextView) findViewById(R.id.nothingToShowView);

        interpretationView = (TextView) findViewById(R.id.interpretationText);
        interpretaion = (TextView) findViewById(R.id.interpretation);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.dietV) {

            Intent diet = new Intent(this, DietScreen.class);
            diet.putExtra("diet", interp);
            startActivity(diet);
            return true;
        }
        else  if (id == R.id.exV) {

            Intent work = new Intent(this, WorkoutScreen.class);
            work.putExtra("workout", interp);
            startActivity(work);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.diet) {

            Intent diet = new Intent(this, DietScreen.class);
            diet.putExtra("diet", interp);
            startActivity(diet);

        }
        else if (id == R.id.workout) {

            Intent work = new Intent(this, WorkoutScreen.class);
            work.putExtra("workout", interp);
            startActivity(work);

        }
        else if (id == R.id.info) {

            Intent info = new Intent(this, About.class);
            startActivity(info);

        }
        else if (id == R.id.help) {

            Intent help = new Intent(this, Help.class);
            startActivity(help);

        }
        else if (id == R.id.save) {

            saveToText();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void receiveValues(double height, double weight) {

        double bmiCalc = (weight / height) / height;

        calculateAndInterpret(bmiCalc);

    }

    private void calculateAndInterpret(double bmiCalc){

        bmi = Math.round(bmiCalc * 100.0) / 100.0;

        if(bmi < 18.5){

            interp = "Underweight";

        }
        else if(bmi >= 18.5 && bmi <= 24.9){

            interp = "Normal";

        }
        else if(bmi >= 25 && bmi <= 29.9){

            interp = "Overweight";

        }
        else if(bmi >= 30){

            interp = "Obese";

        }

        resultTextView.setText("Result");
        resultView.setText(String.valueOf(bmi));

        nothingToShowView.setText("");

        interpretationView.setText("Interpretation");
        interpretaion.setText(interp);

        setPrefs();

    }

    private  void setPrefs(){

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("interp", interp);
        editor.putString("index", String.valueOf(bmi));

        editor.apply();

    }

    private void getPrefs(){

        nothingToShowView.setText("");
        resultTextView.setText("Result");


        bmi = Double.parseDouble(prefs.getString("index", ""));
        resultView.setText(String.valueOf(bmi));

        interpretationView.setText("Interpretation");
        interp = prefs.getString("interp", "");

        interpretaion.setText(interp);

    }


    public void saveToText(){

        FileOutputStream fos = null;

        String file = "bmi-logs.txt";

        String text = "BMI for: " + getCurrentDate() + "\n Value: " + resultView.getText() + "\n Interpretation: " + interpretaion.getText() + "\n\n";


        try {
            fos = openFileOutput(file, MODE_PRIVATE);
            fos.write(text.getBytes());

            Toast.makeText(this, "Saved to" + getFilesDir() + "/" + file, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public String getCurrentDate(){

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(d);

    }

}
