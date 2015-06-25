package name.bagi.levente.pedometer;

import android.app.Activity;
//import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.preference.PreferenceManager;
import android.widget.TextView;

/**
 * Created by Люда on 29.05.2015.
 */
public class DecryptionBurned extends Activity {

    private SharedPreferences mSettings;
    PedometerSettings settings;

    private TextView textview_basal_metabolism;
    private TextView textview_all_calories;
    private TextView textview_run_walkView;
    private TextView textview_View_other_loads;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decryptionburned);

        resetValues();
    }

    public void resetValues(){
        textview_basal_metabolism = (TextView) findViewById(R.id.view__basal_metabolism);
        textview_all_calories = (TextView) findViewById(R.id.all_calories);
        textview_run_walkView = (TextView) findViewById(R.id.run_walkView);
        textview_View_other_loads = (TextView) findViewById(R.id.View_other_loads);

        textview_basal_metabolism.setText( Integer.toString(Pedometer.bmr2));

        textview_run_walkView.setText(Integer.toString(Pedometer.mmCaloriesValue));

        textview_View_other_loads.setText(Integer.toString(Pedometer.other2));

        textview_all_calories.setText(Integer.toString(Pedometer.allCal));
    }
}