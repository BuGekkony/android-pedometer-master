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
public class Drinks extends Activity implements OnClickListener{

    EditText cocoa_gram;
    EditText compote_gram;
    EditText coffee_gram;
    EditText milk_gram;
    EditText tea_gram;

    Button btn_cocoa;
    Button btn_compote;
    Button btn_coffee;
    Button btn_milk;
    Button btn_tea;

    public static int cocoa_gr;
    public static int compote_gr;
    public static int coffee_gr;
    public static int milk_gr;
    public static int tea_gr;


    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drinks);

        cocoa_gram = (EditText) findViewById(R.id.cocoa_gram);
        compote_gram = (EditText) findViewById(R.id.compote_gram);
        coffee_gram = (EditText) findViewById(R.id.coffee_gram);
        milk_gram = (EditText) findViewById(R.id.milk_gram);
        tea_gram = (EditText) findViewById(R.id.tea_gram);

        btn_cocoa = (Button) findViewById(R.id.btn_cocoa);
        btn_cocoa.setOnClickListener(this);

        btn_compote = (Button) findViewById(R.id.btn_compote);
        btn_compote.setOnClickListener(this);

        btn_coffee = (Button) findViewById(R.id.btn_coffee);
        btn_coffee.setOnClickListener(this);

        btn_milk = (Button) findViewById(R.id.btn_milk);
        btn_milk.setOnClickListener(this);

        btn_tea = (Button) findViewById(R.id.btn_tea);
        btn_tea.setOnClickListener(this);
}
    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_cocoa:
                if (cocoa_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = cocoa_gram.getText().toString();
                    cocoa_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_compote:
                if (compote_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = compote_gram.getText().toString();
                    compote_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_coffee:
                if (coffee_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = coffee_gram.getText().toString();
                    coffee_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_milk:
                if (milk_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = milk_gram.getText().toString();
                    milk_gr = Integer.parseInt(S);
                }
                break;
            case R.id.btn_tea:
                if (tea_gram.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = tea_gram.getText().toString();
                    tea_gr = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}