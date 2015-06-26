/*
 *
 */

package name.bagi.levente.pedometer;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.*;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


import java.util.ArrayList;
import java.util.Date;


public class Pedometer extends Activity implements OnClickListener{
	private static final String TAG = "Pedometer";
    private SharedPreferences mSettings;
    private PedometerSettings mPedometerSettings;
    private Utils mUtils;
    
    private TextView mStepValueView;
    private TextView mPaceValueView;
    private TextView mDistanceValueView;
    private TextView mSpeedValueView;
    private TextView mCaloriesValueView;
    private TextView calories_value_pri;
    private TextView raznica_value;

    private int mStepValue;
    private float mDistanceValue;
    private int mCaloriesValue;
    private boolean mIsMetric;
    private boolean mQuitting = false; // Устанавливается, когда пользователь выбрал Выйти из меню, могут быть использованы OnPause, OnStop, OnDestroy



    public static int allCal;
    public static int bmr2;
    double other;
    public static int other2;
    float mBodyWeight;
    float mHeight;
    float mAge;
    boolean mSex;
    public static int raz;
    public static int mmCaloriesValue;
    int calBur;
    float bmr1;
    float bmr;

    public static double allCalories;

    double first_courses;
    double main_dishes;
    double garnishes;
    double desserts;
    double snacks;
    double drinks;

    public static double first_courses1;
    public static double main_dishes1;
    public static double garnishes1;
    public static double desserts1;
    public static double snacks1;
    public static double drinks1;

    private WritableWorkbook wwb;
    private WritableSheet ws1;


    String currentDateTimeString;

    ArrayList<String> arrayDates = new ArrayList<String>();
    ArrayList<Double> arrayWeight = new ArrayList<Double>();
    ArrayList<Integer> arraySteps = new ArrayList<Integer>();
    ArrayList<Integer> arrayBalance = new ArrayList<Integer>();


    
    /**
     * True, когда служба работает..
     */
    private boolean mIsRunning;

    Button add_burned;
    Button decryption_burned;
    Button add_calorie;
    Button decryption_calorie;
    Button bmi;
    Button btn_statistic;
    Button btn_recommendations;


    /** Вызывается, когда активити создается впервые. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "[ACTIVITY] onCreate");
        super.onCreate(savedInstanceState);
        
        mStepValue = 0;
        
        setContentView(R.layout.main);
        
        mUtils = Utils.getInstance();

        add_burned = (Button) findViewById(R.id.add_burned);
        add_burned.setOnClickListener(this);

        decryption_burned = (Button) findViewById(R.id.decryption_burned);
        decryption_burned.setOnClickListener(this);

        add_calorie = (Button) findViewById(R.id.add_calorie);
        add_calorie.setOnClickListener(this);

        decryption_calorie = (Button) findViewById(R.id.decryption_calorie);
        decryption_calorie.setOnClickListener(this);

        bmi = (Button) findViewById(R.id.bmi);
        bmi.setOnClickListener(this);

        btn_statistic = (Button) findViewById(R.id.btn_statistic);
        btn_statistic.setOnClickListener(this);

        btn_recommendations = (Button) findViewById(R.id.btn_recommendations);
        btn_recommendations.setOnClickListener(this);

    }
    
    @Override
    protected void onStart() {
        Log.i(TAG, "[ACTIVITY] onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "[ACTIVITY] onResume");
        super.onResume();
        
        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        mPedometerSettings = new PedometerSettings(mSettings);

        // Чтение из предпочтений, если услуга была работает на последней OnPause
        mIsRunning = mPedometerSettings.isServiceRunning();
        
        // Запуск службы, если это считается стартом приложения
        if (!mIsRunning && mPedometerSettings.isNewStart()) {
            startStepService();
            bindStepService();
        }
        else if (mIsRunning) {
            bindStepService();
        }
        
        mPedometerSettings.clearServiceRunning();

        mStepValueView     = (TextView) findViewById(R.id.step_value);
        mDistanceValueView = (TextView) findViewById(R.id.distance_value);
        mCaloriesValueView = (TextView) findViewById(R.id.calories_value);

        calories_value_pri = (TextView) findViewById(R.id.calories_value_pri);
        raznica_value = (TextView) findViewById(R.id.raznica_value);


        mIsMetric = mPedometerSettings.isMetric();
        ((TextView) findViewById(R.id.distance_units)).setText(getString(R.string.kilometers));

        mBodyWeight = mPedometerSettings.getBodyWeight();
        mHeight = mPedometerSettings.getHeight();
        mAge = mPedometerSettings.getAge();
        mSex = mPedometerSettings.isSex();

        burnedCal();
        calReceived();

        calBur = (int) allCalories;
        calories_value_pri.setText(Integer.toString(calBur));

        raz = calBur-allCal;
        raznica_value.setText(Integer.toString(raz));

        statistic();
    }
    

    
    @Override
    protected void onPause() {
        Log.i(TAG, "[ACTIVITY] onPause");
        if (mIsRunning) {
            unbindStepService();
        }
        if (mQuitting) {
            mPedometerSettings.saveServiceRunningWithNullTimestamp(mIsRunning);
        }
        else {
            mPedometerSettings.saveServiceRunningWithTimestamp(mIsRunning);
        }

        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "[ACTIVITY] onStop");
        super.onStop();
    }

    protected void onDestroy() {
        Log.i(TAG, "[ACTIVITY] onDestroy");
        super.onDestroy();
    }
    
    protected void onRestart() {
        Log.i(TAG, "[ACTIVITY] onRestart");
        super.onDestroy();
    }


    private StepService mService;
    
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mService = ((StepService.StepBinder)service).getService();

            mService.registerCallback(mCallback);
            mService.reloadSettings();
            
        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
        }
    };
    

    private void startStepService() {
        if (! mIsRunning) {
            Log.i(TAG, "[SERVICE] Start");
            mIsRunning = true;
            startService(new Intent(Pedometer.this,
                    StepService.class));
        }
    }
    
    private void bindStepService() {
        Log.i(TAG, "[SERVICE] Bind");
        bindService(new Intent(Pedometer.this, 
                StepService.class), mConnection, Context.BIND_AUTO_CREATE + Context.BIND_DEBUG_UNBIND);
    }

    private void unbindStepService() {
        Log.i(TAG, "[SERVICE] Unbind");
        unbindService(mConnection);
    }
    
    private void stopStepService() {
        Log.i(TAG, "[SERVICE] Stop");
        if (mService != null) {
            Log.i(TAG, "[SERVICE] stopService");
            stopService(new Intent(Pedometer.this,
                  StepService.class));
        }
        mIsRunning = false;
    }
    
    private void resetValues(boolean updateDisplay) {
        if (mService != null && mIsRunning) {
            mService.resetValues();                    
        }
        else {
            mStepValueView.setText("0");
            mPaceValueView.setText("0");
            mDistanceValueView.setText("0");
            mSpeedValueView.setText("0");
            mCaloriesValueView.setText("0");
            calories_value_pri.setText("0");
            raznica_value.setText("0");
            SharedPreferences state = getSharedPreferences("state", 0);
            SharedPreferences.Editor stateEditor = state.edit();
            if (updateDisplay) {
                stateEditor.putInt("steps", 0);
                stateEditor.putInt("pace", 0);
                stateEditor.putFloat("distance", 0);
                stateEditor.putFloat("speed", 0);
                stateEditor.putFloat("calories", 0);
                stateEditor.commit();
            }
        }
    }

    private static final int MENU_SETTINGS = 8;
    private static final int MENU_QUIT     = 9;

    private static final int MENU_PAUSE = 1;
    private static final int MENU_RESUME = 2;
    private static final int MENU_RESET = 3;
    
    /* Создание пунктов меню*/
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (mIsRunning) {
            menu.add(0, MENU_PAUSE, 0, "Пауза")
            .setIcon(android.R.drawable.ic_media_pause)
            .setShortcut('1', 'p');
        }
        else {
            menu.add(0, MENU_RESUME, 0,"Старт")
            .setIcon(android.R.drawable.ic_media_play)
            .setShortcut('1', 'p');
        }
        menu.add(0, MENU_RESET, 0, "Сброс")
        .setIcon(android.R.drawable.ic_menu_close_clear_cancel)
        .setShortcut('2', 'r');
        menu.add(0, MENU_SETTINGS, 0, R.string.settings)
        .setIcon(android.R.drawable.ic_menu_preferences)
        .setShortcut('8', 's')
        .setIntent(new Intent(this, Settings.class));
        menu.add(0, MENU_QUIT, 0,"Выход")
        .setIcon(android.R.drawable.ic_lock_power_off)
        .setShortcut('9', 'q');
        return true;
    }

    /* Обрабатывает Пункт выбора */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_PAUSE:
                unbindStepService();
                stopStepService();
                return true;
            case MENU_RESUME:
                startStepService();
                bindStepService();
                return true;
            case MENU_RESET:
                resetValues(true);
                return true;
            case MENU_QUIT:
                resetValues(false);
                unbindStepService();
                stopStepService();
                mQuitting = true;
                finish();
                return true;
        }
        return false;
    }
 
    // TODO: unite all into 1 type of message
    private StepService.ICallback mCallback = new StepService.ICallback() {
        public void stepsChanged(int value) {
            mHandler.sendMessage(mHandler.obtainMessage(STEPS_MSG, value, 0));
        }
        public void paceChanged(int value) {
            mHandler.sendMessage(mHandler.obtainMessage(PACE_MSG, value, 0));
        }
        public void distanceChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(DISTANCE_MSG, (int)(value*1000), 0));
        }
        public void speedChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(SPEED_MSG, (int)(value*1000), 0));
        }
        public void caloriesChanged(float value) {
            mHandler.sendMessage(mHandler.obtainMessage(CALORIES_MSG, (int)(value), 0));
        }
    };
    
    private static final int STEPS_MSG = 1;
    private static final int PACE_MSG = 2;
    private static final int DISTANCE_MSG = 3;
    private static final int SPEED_MSG = 4;
    private static final int CALORIES_MSG = 5;
    
    private Handler mHandler = new Handler() {
        @Override public void handleMessage(Message msg) {
            switch (msg.what) {
                case STEPS_MSG:
                    mStepValue = (int)msg.arg1;
                    mStepValueView.setText("" + mStepValue);
                    break;
                case DISTANCE_MSG:
                    mDistanceValue = ((int)msg.arg1)/1000f;
                    if (mDistanceValue <= 0) { 
                        mDistanceValueView.setText("0");
                    }
                    else {
                        mDistanceValueView.setText(
                                ("" + (mDistanceValue + 0.000001f)).substring(0, 5)
                        );
                    }
                    break;
                case CALORIES_MSG:
                    mCaloriesValue = msg.arg1;
                   // mmCaloriesValue = mCaloriesValue;
                    if (mCaloriesValue <= 0) {
                        mCaloriesValueView.setText("0");
                    }
                    else {
                        allCal= mCaloriesValue+bmr2 + (int)other2;
                        mmCaloriesValue = mCaloriesValue;
                        mCaloriesValueView.setText("" + (int)allCal);
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_burned:
                Intent intent = new Intent(this, CaloriesBurned.class);
                startActivity(intent);
                break;
            case R.id.decryption_burned:
                intent = new Intent(this, DecryptionBurned.class);
                startActivity(intent);
                break;
            case R.id.add_calorie:
                intent = new Intent(this, AddCalorie.class);
                startActivity(intent);
                break;
            case R.id.decryption_calorie:
                intent = new Intent(this, DecryptionCalorie.class);
                startActivity(intent);
                break;
            case R.id.bmi:
                intent = new Intent(this, BMI.class);
                startActivity(intent);
                break;
            case R.id.btn_statistic:
                intent = new Intent(this, MyStatistics.class);
                intent.putExtra("arrayDates", new ArrayList<String>(arrayDates));
                intent.putExtra("arrayWeight", new ArrayList<Double>(arrayWeight));
                intent.putExtra("arraySteps", new ArrayList<Integer>(arraySteps));
                intent.putExtra("arrayBalance", new ArrayList<Integer>(arrayBalance));
                startActivity(intent);
                break;
            case R.id.btn_recommendations:
                intent = new Intent(this, Recommendations.class);
                intent.putExtra("mStep",mStepValue);
                startActivity(intent);
            default:
                break;
        }

    }

    public float basalMetabolicRate () {
        if (!mSex)//если женщина
        {
            bmr = 6*(mHeight-mAge)+13*mBodyWeight-200;
        }
        else
        {
            bmr = 6*(mHeight-mAge)+13*mBodyWeight;
        }
        return bmr;
    }
    public void burnedCal(){

        bmr1=basalMetabolicRate();
        bmr2 = (int)bmr1;

        other = (double)CaloriesBurned.drive_cal*(101.0/60.0)+(double)CaloriesBurned.skating_cal*(400.0/60.0)
                +(double)CaloriesBurned.jumping_rope_cal*(800.0/60.0)+(double)CaloriesBurned.skiing_cal*(500.0/60.0)
                +(double)CaloriesBurned.gymnastics_cal*(440.0/60.0)+(double)CaloriesBurned.roller_skating_cal*(350.0/60.0)
                +(double)CaloriesBurned.swimming_cal*(350.0/60.0);

        other2 /*+*/= (int)other;

    }

    public void calReceived(){

        first_courses = (double)FirstCourses.borsch_gr*(57.7/100.0)+
                (double)FirstCourses.broth_gr*(50.8/100.0)+
                (double)FirstCourses.pea_soup_gr*(54.3/100.0)+
                (double)FirstCourses.mushroom_soup_gr*(50.9/100.0)+
                (double)FirstCourses.pickle_gr*(40.4/100.0)+
                (double)FirstCourses.bean_soup_gr*(66.3/100.0)+
                (double)FirstCourses.soup_kharcho_gr*(43.9/100.0)+
                (double)FirstCourses.ear_gr*(66.7/100.0);
        first_courses1/*+*/=first_courses;

        main_dishes = (double)MainDishes.entrecote_gr*(317.2565/100.0)+
                (double)MainDishes.cutlets_gr*(438.2/100.0)+
                (double)MainDishes.steak_gr*(384.3/100.0)+
                (double)MainDishes.dumplings_gr*(355.4/100.0)+
                (double)MainDishes.fried_mushrooms_gr*(162.1/100.0)+
                (double)MainDishes.goulash_gr*(326.0/100.0)+
                (double)MainDishes.meat_stew_gr*(252.3/100.0)+
                (double)MainDishes.omelette_gr*(221.9/100.0);
        main_dishes1 /*+*/= main_dishes;

        garnishes = (double)Garnishes.mashed_potatoes_gr*(81.7/100.0)+
                (double)Garnishes.pilaf_gr*(150.7/100.0)+
                (double)Garnishes.fried_cauliflower_gr*(60.6/100.0)+
                (double)Garnishes.potato_casserole_gr*(79.8/100.0)+
                (double)Garnishes.buckwheat_gr*(98.7/100.0)+
                (double)Garnishes.rice_porridge_gr*(119.7/100.0);
        garnishes1 /*+*/= garnishes;

        desserts = (double)Desserts.kiss_gr*(234.4/100.0)+
                (double)Desserts.sponge_cake_gr*(319.2/100.0)+
                (double)Desserts.pancakes_gr*(232.5/100.0)+
                (double)Desserts.wafers_gr*(210.9/100.0)+
                (double)Desserts.lemon_jelly_gr*(87.6/100.0)+
                (double)Desserts.fritters_gr*(201.1/100.0)+
                (double)Desserts.souffle_gr*(203.2/100.0);
        desserts1 /*+*/= desserts;

        snacks = (double)Snacks.watermelon_gr*(38.0/100.0)+
                (double)Snacks.melon_gr*(35.0/100.0)+
                (double)Snacks.pineapple_gr*(40.0/100.0)+
                (double)Snacks.oranges_gr*(40.0/100.0)+
                (double)Snacks.bananas_gr*(89.0/100.0)+
                (double)Snacks.apples_gr*(45.0/100.0);
        snacks1 /*+*/= snacks;

        drinks = (double)Drinks.cocoa_gr*(102.8/100.0)+
                (double)Drinks.compote_gr*(53.5/100.0)+
                (double)Drinks.coffee_gr*(64.1/100.0)+
                (double)Drinks.milk_gr*(60.5/100.0)+
                (double)Drinks.tea_gr*(41.1/100.0);
        drinks1 /*+*/= drinks;

        allCalories = first_courses + main_dishes + garnishes + desserts + snacks + drinks;
    }

    public void statistic(){
        currentDateTimeString = (String) DateFormat.format("dd/MM/yy", new Date());

        if(arrayDates.contains(currentDateTimeString)){    //если дата сущетвует
            int index = arrayDates.indexOf(currentDateTimeString);
            arrayWeight.set(index, (double)mBodyWeight);
            arraySteps.set(index, mStepValue);
            arrayBalance.set(index, raz);
        }
        else{
            arrayDates.add(currentDateTimeString);
            //mStepValue = 0;
            //StepDisplayer.mCount = 0;
            //resetValues(true);
            other2 = 0;
            first_courses1 = 0.0;
            main_dishes1 = 0.0;
            garnishes1 = 0.0;
            desserts1 = 0.0;
            snacks1 = 0.0;
            drinks1 = 0.0;
            raz = 0;

            arrayWeight.add((double)mBodyWeight);
            arraySteps.add(mStepValue);
            arrayBalance.add(raz);
        }

    }
}
