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
public class Garnishes extends Activity implements OnClickListener{

    EditText mashed_potatoes_gram;
    EditText pilaf_gram;
    EditText fried_cauliflower_gram;
    EditText potato_casserole_gram;
    EditText buckwheat_gram;
    EditText rice_porridge_gram;

    Button btn_mashed_potatoes;
    Button btn_pilaf;
    Button btn_fried_cauliflower;
    Button btn_potato_casserole;
    Button btn_buckwheat;
    Button btn_rice_porridge;

    public static int mashed_potatoes_gr;
    public static int pilaf_gr;
    public static int fried_cauliflower_gr;
    public static int potato_casserole_gr;
    public static int buckwheat_gr;
    public static int rice_porridge_gr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garnishes);

        mashed_potatoes_gram = (EditText) findViewById(R.id.mashed_potatoes_gram);
        pilaf_gram = (EditText) findViewById(R.id.pilaf_gram);
        fried_cauliflower_gram = (EditText) findViewById(R.id.fried_cauliflower_gram);
        potato_casserole_gram = (EditText) findViewById(R.id.potato_casserole_gram);
        buckwheat_gram = (EditText) findViewById(R.id.buckwheat_gram);
        rice_porridge_gram = (EditText) findViewById(R.id.rice_porridge_gram);

        btn_mashed_potatoes = (Button) findViewById(R.id.btn_mashed_potatoes);
        btn_mashed_potatoes.setOnClickListener(this);

        btn_pilaf = (Button) findViewById(R.id.btn_pilaf);
        btn_pilaf.setOnClickListener(this);

        btn_fried_cauliflower = (Button) findViewById(R.id.btn_fried_cauliflower);
        btn_fried_cauliflower.setOnClickListener(this);

        btn_potato_casserole = (Button) findViewById(R.id.btn_potato_casserole);
        btn_potato_casserole.setOnClickListener(this);

        btn_buckwheat = (Button) findViewById(R.id.btn_buckwheat);
        btn_buckwheat.setOnClickListener(this);

        btn_rice_porridge = (Button) findViewById(R.id.btn_rice_porridge);
        btn_rice_porridge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_mashed_potatoes:
                if (mashed_potatoes_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = mashed_potatoes_gram.getText().toString();
                    mashed_potatoes_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_pilaf:
                if (pilaf_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = pilaf_gram.getText().toString();
                    pilaf_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_fried_cauliflower:
                if (fried_cauliflower_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = fried_cauliflower_gram.getText().toString();
                    fried_cauliflower_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_potato_casserole:
                if (potato_casserole_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = potato_casserole_gram.getText().toString();
                    potato_casserole_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_buckwheat:
                if (buckwheat_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = buckwheat_gram.getText().toString();
                    buckwheat_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_rice_porridge:
                if (rice_porridge_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = rice_porridge_gram.getText().toString();
                    rice_porridge_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}