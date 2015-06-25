package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Intent;

/**
 * Created by Люда on 29.05.2015.
 */
public class BMI extends Activity {

    private SharedPreferences mSettings;
    PedometerSettings settings;

    float mBodyWeight;
    float mHeight;
    double mBMI;
    float mWrist;
    int mAge;
    boolean mSex;

    int somatotype;
    double mIdealWeight;


    private TextView text_bmi;
    private TextView text_bmi_r;
    private TextView somatotype1;
    private TextView ideal_weight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        PedometerSettings settings = new PedometerSettings(mSettings);

        mHeight     = settings.getHeight();
        mBodyWeight = settings.getBodyWeight();
        mWrist = settings.getWristSize();
        mSex = settings.isSex();
        mAge = (int)settings.getAge();

        outValues();
        ideal_weight();
    }

    public void outValues(){
        mBMI = (double)mBodyWeight/(((double)mHeight*(double)mHeight)/10000.0);
        text_bmi = (TextView) findViewById(R.id.text_bmi);
        text_bmi_r = (TextView) findViewById(R.id.text_bmi_r);
        somatotype1 = (TextView) findViewById(R.id.somatotype);
        ideal_weight = (TextView) findViewById(R.id.ideal_weight);

        text_bmi.setText( ("ИМТ: "+ ((double)((int)(mBMI*10)))/10));

        if(mBMI<16.0){
            text_bmi_r.setText("Выраженный дефицит массы тела");
        }
        else if(mBMI>=16.0 && mBMI<18.0){
            text_bmi_r.setText("Недостаточная масса тела");
        }
        else if(mBMI>=18.0 && mBMI<25.0){
            text_bmi_r.setText("Нормальный вес");
        }
        else if(mBMI>=25.0 && mBMI<30.0){
            text_bmi_r.setText("Избыточная масса тела (предожирение)");
        }
        else if(mBMI>=30.0 && mBMI<35.0){
            text_bmi_r.setText("Ожирение 1 степени");
        }
        else if(mBMI>=35.0 && mBMI<40.0){
            text_bmi_r.setText("Ожирение 2 степени");
        }
        else if(mBMI>=40.0){
            text_bmi_r.setText("Ожирение 3 степени (морбидное)");
        }
    }
    public void ideal_weight () {
        if (!mSex)//если женщина
        {
            if (mWrist>=15.0 && mWrist<=17.0){
                somatotype1.setText("Ваш тип телосложения: нормостенический (нормальный)");//normal
                somatotype = 0;
            }
            else if (mWrist>17.0){
                somatotype1.setText("Ваш тип телосложения: гиперстенический (ширококостный)");//гиперстенический (ширококостный)
                somatotype = 1;
            }
            else if (mWrist<15.0){
                somatotype1.setText("Ваш тип телосложения: астенический (тонкокостный)");//астенический (тонкокостный)
                somatotype = 2;
            }

        }
        else
        {
            if (mWrist>=18.0 && mWrist<=20.0){
                somatotype1.setText("Ваш тип телосложения: нормостенический (нормальный)");//нормостенический (нормальный)
                somatotype = 0;
            }
            else if (mWrist>20.0){
                somatotype1.setText("Ваш тип телосложения: гиперстенический (ширококостный)");//гиперстенический (ширококостный)
                somatotype = 1;
            }
            else if (mWrist<18.0){
                somatotype1.setText("Ваш тип телосложения: астенический (тонкокостный)");//астенический (тонкокостный)
                somatotype = 2;
            }
        }

        if (mAge < 40)
        {
            if (somatotype == 0)//если нормальный
            {
                mIdealWeight =  mHeight - 110;
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }
            if (somatotype == 1)//если широкий
            {
                mIdealWeight =  (mHeight - 110) + (((mHeight - 110)/100)*10);
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }

            if (somatotype == 2)//если тонкий
            {
                mIdealWeight =  (mHeight - 110) - (((mHeight - 110)/100)*10);
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }

        }
        else{
            if (somatotype == 0)//если нормальный
            {
                mIdealWeight =  mHeight - 100;
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }
            if (somatotype == 1)//если широкий
            {
                mIdealWeight =  (mHeight - 100) + (((mHeight - 100)/100)*10);
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }

            if (somatotype == 2)//если тонкий
            {
                mIdealWeight =  (mHeight - 100) - (((mHeight - 100)/100)*10);
                ideal_weight.setText("Ваш идеальный вес: "+mIdealWeight + " кг.");//vivod
            }
        }
    }
}