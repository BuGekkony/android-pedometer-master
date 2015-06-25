package name.bagi.levente.pedometer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

/**
 * Created by Люда on 13.06.2015.
 */
public class Recommendations extends Activity {

    int mSteps;
    double proteins;

    double first_courses_p;
    double main_dishes_p;
    double garnishes_p;
    double desserts_p;
    double snacks_p;
    double drinks_p;
    double all_p;

    double first_courses_f;
    double main_dishes_f;
    double garnishes_f;
    double desserts_f;
    double snacks_f;
    double drinks_f;
    double all_f;

    double first_courses_c;
    double main_dishes_c;
    double garnishes_c;
    double desserts_c;
    double snacks_c;
    double drinks_c;
    double all_c;

    private SharedPreferences mSettings;
    PedometerSettings settings;

    float mBodyWeight;
    boolean mSex;
    int mAge;
    double mWrist;
    int mHeight;

    private TextView text_r;
    private TextView belci;
    private TextView fats;
    private TextView carbohydrates;
    private TextView belci_norm;
    private TextView fats_norm;
    private TextView carbohydrates_norm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendations);

        Intent i = getIntent();
        mSteps = i.getIntExtra("mStep",0);
        outValues();

        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        PedometerSettings settings = new PedometerSettings(mSettings);

        mBodyWeight = settings.getBodyWeight();
        mSex = settings.isSex();
        mAge = (int)settings.getAge();
        mWrist = (double)settings.getWristSize();
        mHeight = (int)settings.getHeight();

        proteins();
        fats();
        carbohydrates();
        recom();
    }

    public void outValues() {
        text_r = (TextView) findViewById(R.id.text_r);
        belci = (TextView) findViewById(R.id.belci);
        fats = (TextView) findViewById(R.id.fats);
        carbohydrates = (TextView) findViewById(R.id.carbohydrates);
        belci_norm = (TextView) findViewById(R.id.belci_norm);
        fats_norm = (TextView) findViewById(R.id.fats_norm);
        carbohydrates_norm = (TextView) findViewById(R.id.carbohydrates_norm);

        if (Pedometer.raz <= 0) {
            text_r.setText("Вы тратите больше калорий, чем потребляете!\n Так Держать!");
        } else {
            text_r.setText("Вы должны больше двигаться.");
        }
    }



    public void recom(){
        proteins = 1.5*(double)mBodyWeight;//кол-во нужных белков
        if (all_p<(proteins-1.0))
        {
            belci.setText("Вы употребили не достаточное количество белков.");//не достаточно
            belci_norm.setText("Ваша норма в день: "+ (int)proteins+" грамм.\nВы употребили: "+(int)all_p+" грамм.");
        }
        else if (all_p >= (proteins-1.0) && all_p <= (proteins+1.0))
        {
            belci.setText("Вы употребили достаточное количество белков.");//в норме
            belci_norm.setText("Ваша норма в день: "+ (int)proteins+" грамм.\nВы употребили: "+(int)all_p+" грамм.");
        }
        else
        {
            belci.setText("Вы употребили больше положенного количества белков.");//уровень превышен
            belci_norm.setText("Ваша норма в день: "+ (int)proteins+" грамм.\nВы употребили: "+(int)all_p+" грамм.");
        }

        /**кол-во нужных жиров*/
        if (!mSex)//если женщина
        {
            if (mAge<30) {
                if (all_f < 88.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 88 до 119 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>=88.0 && all_f<=119.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от 88 до 119 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>119.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от 88 до 119 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
            else if (mAge>29 && mAge <40){
                if (all_f < 84.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 84 до 112 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>=84.0 && all_f<=112.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от  84 до 112 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>112.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от  84 до 112 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
            else if (mAge>39){
                if (all_f < 65.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>=65.0 && all_f<=71.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>71.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
        }
        else//если мужчина
        {
            if (mAge<30) {
                if (all_f < 103.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 103 до 158 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>=103.0 && all_f<=158.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от 103 до 158 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>158.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от 103 до 158 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
            else if (mAge>29 && mAge <40){
                if (all_f < 99.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 99 до 150 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>=99.0 && all_f<=150.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от 99 до 150 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>150.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от 99 до 150 грамм.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
            else if (mAge>39){
                if (all_f < 65.0) {
                    fats.setText("Вы употребили не достаточное количество жиров.");// жиров не достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамма.\nВы употребили: "+(int)all_f+" грамм.");

                }
                else if (all_f>=65.0 && all_f<=71.0) {
                    fats.setText("Вы употребили достаточное количество жиров.");//жиров достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамма.\nВы употребили: "+(int)all_f+" грамм.");
                }
                else if (all_f>71.0) {
                    fats.setText("Вы употребили больше положенного количества жиров.");//жиров больше, чем достаточно
                    fats_norm.setText("Ваша норма в день: от 65 до 71 грамма.\nВы употребили: "+(int)all_f+" грамм.");
                }
            }
        }

         if (all_c<300)
        {
            carbohydrates.setText("Вы употребили не достаточное количество углеводов.");//мало
            carbohydrates_norm.setText("Ваша норма в день: от 300 до 500 грамма.\nВы употребили: "+(int)all_c+" грамм.");
        }
        else if(all_c>=300 && all_c <=500 ){
             carbohydrates.setText("Вы употребили достаточное количество углеводов.");//в пределах нормы
             carbohydrates_norm.setText("Ваша норма в день: от 300 до 500 грамма.\nВы употребили: "+(int)all_c+" грамм.");
        }
        else if(all_c>500){
             carbohydrates.setText("Вы употребили больше положенного количества углеводов.");//слишком много
             carbohydrates_norm.setText("Ваша норма в день: от 300 до 500 грамма.\nВы употребили: "+(int)all_c+" грамм.");
        }
    }


    /*белки*/
    public void proteins(){
        first_courses_p = (double)FirstCourses.borsch_gr*(3.8/100.0)+
                (double)FirstCourses.broth_gr*(7.7/100.0)+
                (double)FirstCourses.pea_soup_gr*(2.2/100.0)+
                (double)FirstCourses.mushroom_soup_gr*(0.8/100.0)+
                (double)FirstCourses.pickle_gr*(0.9/100.0)+
                (double)FirstCourses.bean_soup_gr*(1.7/100.0)+
                (double)FirstCourses.soup_kharcho_gr*(2.2/100.0)+
                (double)FirstCourses.ear_gr*(8.5/100.0);

        main_dishes_p = (double)MainDishes.entrecote_gr*(21.536/100.0)+
                (double)MainDishes.cutlets_gr*(29.0/100.0)+
                (double)MainDishes.steak_gr*(27.8/100.0)+
                (double)MainDishes.dumplings_gr*(17.2/100.0)+
                (double)MainDishes.fried_mushrooms_gr*(4.6/100.0)+
                (double)MainDishes.goulash_gr*(24.9/100.0)+
                (double)MainDishes.meat_stew_gr*(17.3/100.0)+
                (double)MainDishes.omelette_gr*(8.7/100.0);

        garnishes_p = (double)Garnishes.mashed_potatoes_gr*(2.1/100.0)+
                (double)Garnishes.pilaf_gr*(4.1/100.0)+
                (double)Garnishes.fried_cauliflower_gr*(2.8/100.0)+
                (double)Garnishes.potato_casserole_gr*(2.9/100.0)+
                (double)Garnishes.buckwheat_gr*(3.6/100.0)+
                (double)Garnishes.rice_porridge_gr*(2.6/100.0);

        desserts_p = (double)Desserts.kiss_gr*(1.0/100.0)+
                (double)Desserts.sponge_cake_gr*(11.1/100.0)+
                (double)Desserts.pancakes_gr*(6.1/100.0)+
                (double)Desserts.wafers_gr*(5.5/100.0)+
                (double)Desserts.lemon_jelly_gr*(2.8/100.0)+
                (double)Desserts.fritters_gr*(7.4/100.0)+
                (double)Desserts.souffle_gr*(5.4/100.0);

        snacks_p = (double)Snacks.watermelon_gr*(0.7/100.0)+
                (double)Snacks.melon_gr*(0.6/100.0)+
                (double)Snacks.pineapple_gr*(0.4/100.0)+
                (double)Snacks.oranges_gr*(0.9/100.0)+
                (double)Snacks.bananas_gr*(1.5/100.0)+
                (double)Snacks.apples_gr*(0.2/100.0);

        drinks_p = (double)Drinks.cocoa_gr*(2.9/100.0)+
                (double)Drinks.compote_gr*(0.3/100.0)+
                (double)Drinks.coffee_gr*(1.4/100.0)+
                (double)Drinks.milk_gr*(3.0/100.0)+
                (double)Drinks.tea_gr*(0.2/100.0);

        all_p += first_courses_p + main_dishes_p + garnishes_p + desserts_p + snacks_p + drinks_p;
    }
    /*жиры*/
    public void fats(){
        first_courses_f = (double)FirstCourses.borsch_gr*(2.9/100.0)+
                (double)FirstCourses.broth_gr*(2.1/100.0)+
                (double)FirstCourses.pea_soup_gr*(3.0/100.0)+
                (double)FirstCourses.mushroom_soup_gr*(3.4/100.0)+
                (double)FirstCourses.pickle_gr*(1.6/100.0)+
                (double)FirstCourses.bean_soup_gr*(4.8/100.0)+
                (double)FirstCourses.soup_kharcho_gr*(2.1/100.0)+
                (double)FirstCourses.ear_gr*(1.9/100.0);

        main_dishes_f = (double)MainDishes.entrecote_gr*(25.0652/100.0)+
                (double)MainDishes.cutlets_gr*(35.8/100.0)+
                (double)MainDishes.steak_gr*(29.6/100.0)+
                (double)MainDishes.dumplings_gr*(23.5/100.0)+
                (double)MainDishes.fried_mushrooms_gr*(11.5/100.0)+
                (double)MainDishes.goulash_gr*(22.0/100.0)+
                (double)MainDishes.meat_stew_gr*(9.0/100.0)+
                (double)MainDishes.omelette_gr*(9.2/100.0);

        garnishes_f = (double)Garnishes.mashed_potatoes_gr*(4.6/100.0)+
                (double)Garnishes.pilaf_gr*(7.3/100.0)+
                (double)Garnishes.fried_cauliflower_gr*(3.3/100.0)+
                (double)Garnishes.potato_casserole_gr*(4.3/100.0)+
                (double)Garnishes.buckwheat_gr*(2.2/100.0)+
                (double)Garnishes.rice_porridge_gr*(0.3/100.0);

        desserts_f = (double)Desserts.kiss_gr*(0.0/100.0)+
                (double)Desserts.sponge_cake_gr*(12.3/100.0)+
                (double)Desserts.pancakes_gr*(12.3/100.0)+
                (double)Desserts.wafers_gr*(6.5/100.0)+
                (double)Desserts.lemon_jelly_gr*(0.02/100.0)+
                (double)Desserts.fritters_gr*(8.9/100.0)+
                (double)Desserts.souffle_gr*(12.2/100.0);

        snacks_f = (double)Snacks.watermelon_gr*(0.2/100.0)+
                (double)Snacks.melon_gr*(0.0/100.0)+
                (double)Snacks.pineapple_gr*(0.2/100.0)+
                (double)Snacks.oranges_gr*(0.2/100.0)+
                (double)Snacks.bananas_gr*(0.1/100.0)+
                (double)Snacks.apples_gr*(0.3/100.0);

        drinks_f = (double)Drinks.cocoa_gr*(2.9/100.0)+
                (double)Drinks.compote_gr*(0.08/100.0)+
                (double)Drinks.coffee_gr*(1.5/100.0)+
                (double)Drinks.milk_gr*(3.3/100.0)+
                (double)Drinks.tea_gr*(0.05/100.0);

        all_f += first_courses_f + main_dishes_f + garnishes_f + desserts_f + snacks_f + drinks_f;
    }

    /*углеводы*/
    public void carbohydrates(){
        first_courses_c = (double)FirstCourses.borsch_gr*(4.3/100.0)+
                (double)FirstCourses.broth_gr*(0.2/100.0)+
                (double)FirstCourses.pea_soup_gr*(5.0/100.0)+
                (double)FirstCourses.mushroom_soup_gr*(4.6/100.0)+
                (double)FirstCourses.pickle_gr*(5.9/100.0)+
                (double)FirstCourses.bean_soup_gr*(4.2/100.0)+
                (double)FirstCourses.soup_kharcho_gr*(4.3/100.0)+
                (double)FirstCourses.ear_gr*(4.3/100.0);

        main_dishes_c = (double)MainDishes.entrecote_gr*(1.3686/100.0)+
                (double)MainDishes.cutlets_gr*(0.04/100.0)+
                (double)MainDishes.steak_gr*(1.7/100.0)+
                (double)MainDishes.dumplings_gr*(20.0/100.0)+
                (double)MainDishes.fried_mushrooms_gr*(10.7/100.0)+
                (double)MainDishes.goulash_gr*(7.7/100.0)+
                (double)MainDishes.meat_stew_gr*(27.3/100.0)+
                (double)MainDishes.omelette_gr*(2.7/100.0);

        garnishes_c = (double)Garnishes.mashed_potatoes_gr*(8.5/100.0)+
                (double)Garnishes.pilaf_gr*(18.3/100.0)+
                (double)Garnishes.fried_cauliflower_gr*(5.3/100.0)+
                (double)Garnishes.potato_casserole_gr*(7.9/100.0)+
                (double)Garnishes.buckwheat_gr*(17.1/100.0)+
                (double)Garnishes.rice_porridge_gr*(28.5/100.0);

        desserts_c = (double)Desserts.kiss_gr*(61.4/100.0)+
                (double)Desserts.sponge_cake_gr*(43.7/100.0)+
                (double)Desserts.pancakes_gr*(26.0/100.0)+
                (double)Desserts.wafers_gr*(34.9/100.0)+
                (double)Desserts.lemon_jelly_gr*(20.3/100.0)+
                (double)Desserts.fritters_gr*(24.5/100.0)+
                (double)Desserts.souffle_gr*(19.1/100.0);

        snacks_c = (double)Snacks.watermelon_gr*(8.8/100.0)+
                (double)Snacks.melon_gr*(9.1/100.0)+
                (double)Snacks.pineapple_gr*(11.8/100.0)+
                (double)Snacks.oranges_gr*(8.1/100.0)+
                (double)Snacks.bananas_gr*(21.0/100.0)+
                (double)Snacks.apples_gr*(8.0/100.0);

        drinks_c = (double)Drinks.cocoa_gr*(17.2/100.0)+
                (double)Drinks.compote_gr*(13.7/100.0)+
                (double)Drinks.coffee_gr*(12.1/100.0)+
                (double)Drinks.milk_gr*(4.9/100.0)+
                (double)Drinks.tea_gr*(10.6/100.0);

        all_c += first_courses_c + main_dishes_c + garnishes_c + desserts_c + snacks_c + drinks_c;
    }
}