package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Люда on 29.05.2015.
 */
public class MyStatistics extends Activity {

    ArrayList<String> arrayDates;
    ArrayList<Double> arrayWeight;
    ArrayList<Integer> arraySteps;
    ArrayList<Integer> arrayBalance;

    private TextView textDate;
    private TextView textSteps;
    private TextView textBalans;
    private TextView textWeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mystatistics);

        arrayDates = (ArrayList<String>)getIntent().getSerializableExtra("arrayDates");
        arrayWeight = (ArrayList<Double>)getIntent().getSerializableExtra("arrayWeight");
        arraySteps = (ArrayList<Integer>)getIntent().getSerializableExtra("arraySteps");
        arrayBalance = (ArrayList<Integer>)getIntent().getSerializableExtra("arrayBalance");

        outValues();
    }

    public void outValues(){
        textDate = (TextView) findViewById(R.id.textDate);
        textSteps = (TextView) findViewById(R.id.textSteps);
        textBalans = (TextView) findViewById(R.id.textBalans);
        textWeight = (TextView) findViewById(R.id.textWeight);

        for (int i = 0; i<arrayDates.size();i++)
        {
            textDate.setText(textDate.getText()+arrayDates.get(i)+"\n");
            textSteps.setText(textSteps.getText()+Integer.toString(arraySteps.get(i))+"\n");
            textBalans.setText(textBalans.getText()+Integer.toString(arrayBalance.get(i))+"\n");
            textWeight.setText(textWeight.getText()+Double.toString(arrayWeight.get(i))+"\n");
        }
    }
}