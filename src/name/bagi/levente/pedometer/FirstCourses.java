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
public class FirstCourses extends Activity implements OnClickListener{

    EditText borsch_gram;
    EditText broth_gram;
    EditText pea_soup_gram;
    EditText mushroom_soup_gram;
    EditText pickle_gram;
    EditText bean_soup_gram;
    EditText soup_kharcho_gram;
    EditText ear_gram;

    Button btn_borsch;
    Button btn_broth;
    Button btn_pea_soup;
    Button btn_mushroom_soup;
    Button btn_pickle;
    Button btn_bean_soup;
    Button btn_soup_kharcho;
    Button btn_ear;

    public static int borsch_gr;
    public static int broth_gr;
    public static int pea_soup_gr;
    public static int mushroom_soup_gr;
    public static int pickle_gr;
    public static int bean_soup_gr;
    public static int soup_kharcho_gr;
    public static int ear_gr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstcourses);

        borsch_gram = (EditText) findViewById(R.id.borsch_gram);
        broth_gram = (EditText) findViewById(R.id.broth_gram);
        pea_soup_gram = (EditText) findViewById(R.id.pea_soup_gram);
        mushroom_soup_gram = (EditText) findViewById(R.id.mushroom_soup_gram);
        pickle_gram = (EditText) findViewById(R.id.pickle_gram);
        bean_soup_gram = (EditText) findViewById(R.id.bean_soup_gram);
        soup_kharcho_gram = (EditText) findViewById(R.id.soup_kharcho_gram);
        ear_gram = (EditText) findViewById(R.id.ear_gram);

        btn_borsch = (Button) findViewById(R.id.btn_borsch);
        btn_borsch.setOnClickListener(this);

        btn_broth = (Button) findViewById(R.id.btn_broth);
        btn_broth.setOnClickListener(this);

        btn_pea_soup = (Button) findViewById(R.id.btn_pea_soup);
        btn_pea_soup.setOnClickListener(this);

        btn_mushroom_soup = (Button) findViewById(R.id.btn_mushroom_soup);
        btn_mushroom_soup.setOnClickListener(this);

        btn_pickle = (Button) findViewById(R.id.btn_pickle);
        btn_pickle.setOnClickListener(this);

        btn_bean_soup = (Button) findViewById(R.id.btn_bean_soup);
        btn_bean_soup.setOnClickListener(this);

        btn_soup_kharcho = (Button) findViewById(R.id.btn_soup_kharcho);
        btn_soup_kharcho.setOnClickListener(this);

        btn_ear = (Button) findViewById(R.id.btn_ear);
        btn_ear.setOnClickListener(this);
    }

    @Override
       public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_borsch:
                if (borsch_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = borsch_gram.getText().toString();
                    borsch_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_broth:
                if (broth_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = broth_gram.getText().toString();
                    broth_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_pea_soup:
                if (pea_soup_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = pea_soup_gram.getText().toString();
                    pea_soup_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_mushroom_soup:
                if (mushroom_soup_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = mushroom_soup_gram.getText().toString();
                    mushroom_soup_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_pickle:
                if (pickle_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = pickle_gram.getText().toString();
                    pickle_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_bean_soup:
                if (bean_soup_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = bean_soup_gram.getText().toString();
                    bean_soup_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_soup_kharcho:
                if (soup_kharcho_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = soup_kharcho_gram.getText().toString();
                    soup_kharcho_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_ear:
                if (ear_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = ear_gram.getText().toString();
                    ear_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}