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
public class Desserts extends Activity implements OnClickListener{

    EditText kiss_gram;
    EditText sponge_cake_gram;
    EditText pancakes_gram;
    EditText wafers_gram;
    EditText lemon_jelly_gram;
    EditText fritters_gram;
    EditText souffle_gram;

    Button btn_kiss;
    Button btn_sponge_cake;
    Button btn_pancakes;
    Button btn_wafers;
    Button btn_lemon_jelly;
    Button btn_fritters;
    Button btn_souffle;

    public static int kiss_gr;
    public static int sponge_cake_gr;
    public static int pancakes_gr;
    public static int wafers_gr;
    public static int lemon_jelly_gr;
    public static int fritters_gr;
    public static int souffle_gr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desserts);

        kiss_gram = (EditText) findViewById(R.id.kiss_gram);
        sponge_cake_gram = (EditText) findViewById(R.id.sponge_cake_gram);
        pancakes_gram = (EditText) findViewById(R.id.pancakes_gram);
        wafers_gram = (EditText) findViewById(R.id.wafers_gram);
        lemon_jelly_gram = (EditText) findViewById(R.id.lemon_jelly_gram);
        fritters_gram = (EditText) findViewById(R.id.fritters_gram);
        souffle_gram = (EditText) findViewById(R.id.souffle_gram);

        btn_kiss = (Button) findViewById(R.id.btn_kiss);
        btn_kiss.setOnClickListener(this);

        btn_sponge_cake = (Button) findViewById(R.id.btn_sponge_cake);
        btn_sponge_cake.setOnClickListener(this);

        btn_pancakes = (Button) findViewById(R.id.btn_pancakes);
        btn_pancakes.setOnClickListener(this);

        btn_wafers = (Button) findViewById(R.id.btn_wafers);
        btn_wafers.setOnClickListener(this);

        btn_lemon_jelly = (Button) findViewById(R.id.btn_lemon_jelly);
        btn_lemon_jelly.setOnClickListener(this);

        btn_fritters = (Button) findViewById(R.id.btn_fritters);
        btn_fritters.setOnClickListener(this);

        btn_souffle = (Button) findViewById(R.id.btn_souffle);
        btn_souffle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_kiss:
                if (kiss_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = kiss_gram.getText().toString();
                    kiss_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_sponge_cake:
                if (sponge_cake_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = sponge_cake_gram.getText().toString();
                    sponge_cake_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_pancakes:
                if (pancakes_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = pancakes_gram.getText().toString();
                    pancakes_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_wafers:
                if (wafers_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = wafers_gram.getText().toString();
                    wafers_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_lemon_jelly:
                if (lemon_jelly_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = lemon_jelly_gram.getText().toString();
                    lemon_jelly_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_fritters:
                if (fritters_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = fritters_gram.getText().toString();
                    fritters_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_souffle:
                if (souffle_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = souffle_gram.getText().toString();
                    souffle_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}