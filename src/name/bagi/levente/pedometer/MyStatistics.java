package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Intent;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Люда on 29.05.2015.
 */
public class MyStatistics extends Activity {
    private SharedPreferences mSettings;
    PedometerSettings settings;

    private WritableWorkbook wwb;
    private WritableSheet ws1;
/*
    String data_f;
    int step_f;
    int balans_f;
    double wheight_f;*/


    //float mBodyWeight;
    //int mSteps;
    ArrayList<String> arrayDates;
    ArrayList<Double> arrayWeight;
    ArrayList<Integer> arraySteps;
    ArrayList<Integer> arrayBalance;

    private TextView textDate;
    private TextView textSteps;
    private TextView textBalans;
    private TextView textWeight;
    String currentDateTimeString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mystatistics);

       /* mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        PedometerSettings settings = new PedometerSettings(mSettings);

        mBodyWeight = settings.getBodyWeight();*/

        //Intent i = getIntent();
        //mSteps = i.getIntExtra("mStep",0);

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

        // Current_Date = new Date();
        //currentDateTimeString = (String) DateFormat.format("dd/MM/yy", new Date());
        //int i_string=0;//количесво строк в файле

        /**чтение из файла*/
       /* File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/Monitoring/NEXT_STEP.xls");
        try {
            Workbook existingWorkbook = Workbook.getWorkbook(dir);
            wwb = Workbook.createWorkbook(dir, existingWorkbook);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        ws1 = wwb.getSheet(0);

        for (int i = 0; i < Pedometer.i_string; i++)
        {
            data_f = ws1.getWritableCell(0, i).getContents();//дошли до конца файла и взяли значение
            textDate.setText(textDate.getText()+data_f+"\n");// даты из предыдущей строки+new

            textSteps.setText(textSteps.getText()+ws1.getWritableCell(1, i).getContents()+"\n");// шаги из предыдущей строки+new

            textBalans.setText(textBalans.getText()+ws1.getWritableCell(2, i).getContents()+"\n");// баланс из предыдущей строки+new

            textWeight.setText(textWeight.getText()+ws1.getWritableCell(3, i).getContents()+"\n");// вес из предыдущей строки+new
        }
*/




        for (int i = 0; i<arrayDates.size();i++)
        {
            textDate.setText(textDate.getText()+arrayDates.get(i)+"\n");
            textSteps.setText(textSteps.getText()+Integer.toString(arraySteps.get(i))+"\n");
            textBalans.setText(textBalans.getText()+Integer.toString(arrayBalance.get(i))+"\n");
            textWeight.setText(textWeight.getText()+Double.toString(arrayWeight.get(i))+"\n");
        }
    }
}