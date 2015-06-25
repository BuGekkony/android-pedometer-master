package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Люда on 04.06.2015.
 */
public class Snacks extends Activity implements OnClickListener{

    EditText watermelon_gram;
    EditText melon_gram;
    EditText pineapple_gram;
    EditText oranges_gram;
    EditText bananas_gram;
    EditText apples_gram;

    Button btn_watermelon;
    Button btn_melon;
    Button btn_pineapple;
    Button btn_oranges;
    Button btn_bananas;
    Button btn_apples;

    public static int watermelon_gr;
    public static int melon_gr;
    public static int pineapple_gr;
    public static int oranges_gr;
    public static int bananas_gr;
    public static int apples_gr;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks);

        watermelon_gram = (EditText) findViewById(R.id.watermelon_gram);
        melon_gram = (EditText) findViewById(R.id.melon_gram);
        pineapple_gram = (EditText) findViewById(R.id.pineapple_gram);
        oranges_gram = (EditText) findViewById(R.id.oranges_gram);
        bananas_gram = (EditText) findViewById(R.id.bananas_gram);
        apples_gram = (EditText) findViewById(R.id.apples_gram);

        btn_watermelon = (Button) findViewById(R.id.btn_watermelon);
        btn_watermelon.setOnClickListener(this);

        btn_melon = (Button) findViewById(R.id.btn_melon);
        btn_melon.setOnClickListener(this);

        btn_pineapple = (Button) findViewById(R.id.btn_pineapple);
        btn_pineapple.setOnClickListener(this);

        btn_oranges = (Button) findViewById(R.id.btn_oranges);
        btn_oranges.setOnClickListener(this);

        btn_bananas = (Button) findViewById(R.id.btn_bananas);
        btn_bananas.setOnClickListener(this);

        btn_apples = (Button) findViewById(R.id.btn_apples);
        btn_apples.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_watermelon:
                if (watermelon_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = watermelon_gram.getText().toString();
                    watermelon_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_melon:
                if (melon_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = melon_gram.getText().toString();
                    melon_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_pineapple:
                if (pineapple_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = pineapple_gram.getText().toString();
                    pineapple_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_oranges:
                if (oranges_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = oranges_gram.getText().toString();
                    oranges_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_bananas:
                if (bananas_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = bananas_gram.getText().toString();
                    bananas_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_apples:
                if (apples_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = apples_gram.getText().toString();
                    apples_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}