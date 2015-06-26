package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Люда on 29.05.2015.
 */
public class DecryptionCalorie extends Activity {

    private TextView first;
    private TextView main;
    private TextView gar;
    private TextView dessert;
    private TextView snack;
    private TextView drink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decryptioncalorie);

        loadingValues();
    }

    public void loadingValues(){
        first = (TextView) findViewById(R.id.first);
        main = (TextView) findViewById(R.id.main);
        gar = (TextView) findViewById(R.id.gar);
        dessert = (TextView) findViewById(R.id.dessert);
        snack = (TextView) findViewById(R.id.snack);
        drink = (TextView) findViewById(R.id.drink);
/*все в Ккал*/
        first.setText("" + ((double)((int)(Pedometer.first_courses1*10)))/10);

        main.setText("" + ((double)((int)(Pedometer.main_dishes1*10)))/10);

        gar.setText("" + ((double)((int)(Pedometer.garnishes1*10)))/10);

        dessert.setText("" + ((double)((int)(Pedometer.desserts1*10)))/10);

        snack.setText("" + ((double)((int)(Pedometer.snacks1*10)))/10);

        drink.setText("" + ((double)((int)(Pedometer.drinks1*10)))/10);

    }
}