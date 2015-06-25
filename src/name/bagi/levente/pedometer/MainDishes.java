package name.bagi.levente.pedometer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

/**
 * Created by Люда on 04.06.2015.
 */
public class MainDishes extends Activity implements OnClickListener{

    EditText entrecote_gram;
    EditText cutlets_gram;
    EditText steak_gram;
    EditText dumplings_gram;
    EditText fried_mushrooms_gram;
    EditText goulash_gram;
    EditText meat_stew_gram;
    EditText omelette_gram;

    Button btn_entrecote;
    Button btn_cutlets;
    Button btn_steak;
    Button btn_dumplings;
    Button btn_fried_mushrooms;
    Button btn_goulash;
    Button btn_meat_stew;
    Button btn_omelette;

    public static int entrecote_gr;
    public static int cutlets_gr;
    public static int steak_gr;
    public static int dumplings_gr;
    public static int fried_mushrooms_gr;
    public static int goulash_gr;
    public static int meat_stew_gr;
    public static int omelette_gr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maindishes);

        entrecote_gram = (EditText) findViewById(R.id.entrecote_gram);
        cutlets_gram = (EditText) findViewById(R.id.cutlets_gram);
        steak_gram = (EditText) findViewById(R.id.steak_gram);
        dumplings_gram = (EditText) findViewById(R.id.dumplings_gram);
        fried_mushrooms_gram = (EditText) findViewById(R.id.fried_mushrooms_gram);
        goulash_gram = (EditText) findViewById(R.id.goulash_gram);
        meat_stew_gram = (EditText) findViewById(R.id.meat_stew_gram);
        omelette_gram = (EditText) findViewById(R.id.omelette_gram);

        btn_entrecote = (Button) findViewById(R.id.btn_entrecote);
        btn_entrecote.setOnClickListener(this);

        btn_cutlets = (Button) findViewById(R.id.btn_cutlets);
        btn_cutlets.setOnClickListener(this);

        btn_steak = (Button) findViewById(R.id.btn_steak);
        btn_steak.setOnClickListener(this);

        btn_dumplings = (Button) findViewById(R.id.btn_dumplings);
        btn_dumplings.setOnClickListener(this);

        btn_fried_mushrooms = (Button) findViewById(R.id.btn_fried_mushrooms);
        btn_fried_mushrooms.setOnClickListener(this);

        btn_goulash = (Button) findViewById(R.id.btn_goulash);
        btn_goulash.setOnClickListener(this);

        btn_meat_stew = (Button) findViewById(R.id.btn_meat_stew);
        btn_meat_stew.setOnClickListener(this);

        btn_omelette = (Button) findViewById(R.id.btn_omelette);
        btn_omelette.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_entrecote:
                if (entrecote_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = entrecote_gram.getText().toString();
                    entrecote_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_cutlets:
                if (cutlets_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = cutlets_gram.getText().toString();
                    cutlets_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_steak:
                if (steak_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = steak_gram.getText().toString();
                    steak_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_dumplings:
                if (dumplings_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = dumplings_gram.getText().toString();
                    dumplings_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_fried_mushrooms:
                if (fried_mushrooms_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = fried_mushrooms_gram.getText().toString();
                    fried_mushrooms_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_goulash:
                if (goulash_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = goulash_gram.getText().toString();
                    goulash_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_meat_stew:
                if (meat_stew_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = meat_stew_gram.getText().toString();
                    meat_stew_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_omelette:
                if (omelette_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = omelette_gram.getText().toString();
                    omelette_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }

}