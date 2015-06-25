package name.bagi.levente.pedometer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Created by Люда on 29.05.2015.
 */
public class AddCalorie extends Activity implements OnClickListener {

    Button btn_first_courses;
    Button btn_main_dishes;
    Button btn_garnishes;
    Button btn_desserts;
    Button btn_snacks;
    Button btn_drinks;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcalorie);

        btn_first_courses = (Button) findViewById(R.id.btn_first_courses);
        btn_first_courses.setOnClickListener(this);

        btn_main_dishes = (Button) findViewById(R.id.btn_main_dishes);
        btn_main_dishes.setOnClickListener(this);

        btn_garnishes = (Button) findViewById(R.id.btn_garnishes);
        btn_garnishes.setOnClickListener(this);

        btn_desserts = (Button) findViewById(R.id.btn_desserts);
        btn_desserts.setOnClickListener(this);

        btn_snacks = (Button) findViewById(R.id.btn_snacks);
        btn_snacks.setOnClickListener(this);

        btn_drinks = (Button) findViewById(R.id.btn_drinks);
        btn_drinks.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first_courses:
                Intent intent = new Intent(this, FirstCourses.class);
                startActivity(intent);
                break;
            case R.id.btn_main_dishes:
                intent = new Intent(this, MainDishes.class);
                startActivity(intent);
                break;
            case R.id.btn_garnishes:
                intent = new Intent(this, Garnishes.class);
                startActivity(intent);
                break;
            case R.id.btn_desserts:
                intent = new Intent(this, Desserts.class);
                startActivity(intent);
                break;
            case R.id.btn_snacks:
                intent = new Intent(this, Snacks.class);
                startActivity(intent);
                break;
            case R.id.btn_drinks:
                intent = new Intent(this, Drinks.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}