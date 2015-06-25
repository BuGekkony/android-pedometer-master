package name.bagi.levente.pedometer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class CaloriesBurned extends Activity implements OnClickListener {
    EditText drive_cal_input;
    EditText skating_cal_input;
    EditText jumping_rope_cal_input;
    EditText skiing_cal_input;
    EditText gymnastics_cal_input;
    EditText roller_skating_cal_input;
    EditText swimming_cal_input;

    Button btn_drive;
    Button btn_skating;
    Button btn_jumping_rope;
    Button btn_skiing;
    Button btn_gymnastics;
    Button btn_roller_skating;
    Button btn_swimming;

    public static int drive_cal;
    public static int skating_cal;
    public static int jumping_rope_cal;
    public static int skiing_cal;
    public static int gymnastics_cal;
    public static int roller_skating_cal;
    public static int swimming_cal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriesburned);

        drive_cal_input = (EditText) findViewById(R.id.drive_cal_input);
        skating_cal_input = (EditText) findViewById(R.id.skating_cal_input);
        jumping_rope_cal_input = (EditText) findViewById(R.id.jumping_rope_cal_input);
        skiing_cal_input = (EditText) findViewById(R.id.skiing_cal_input);
        gymnastics_cal_input = (EditText) findViewById(R.id.gymnastics_cal_input);
        roller_skating_cal_input = (EditText) findViewById(R.id.roller_skating_cal_input);
        swimming_cal_input = (EditText) findViewById(R.id.swimming_cal_input);

        btn_drive = (Button) findViewById(R.id.btn_drive);
        btn_drive.setOnClickListener(this);

        btn_skating = (Button) findViewById(R.id.btn_skating);
        btn_skating.setOnClickListener(this);

        btn_jumping_rope = (Button) findViewById(R.id.btn_jumping_rope);
        btn_jumping_rope.setOnClickListener(this);

        btn_skiing = (Button) findViewById(R.id.btn_skiing);
        btn_skiing.setOnClickListener(this);

        btn_gymnastics = (Button) findViewById(R.id.btn_gymnastics);
        btn_gymnastics.setOnClickListener(this);

        btn_roller_skating = (Button) findViewById(R.id.btn_roller_skating);
        btn_roller_skating.setOnClickListener(this);

        btn_swimming = (Button) findViewById(R.id.btn_swimming);
        btn_swimming.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String S;

        switch (view.getId()) {
            case R.id.btn_drive:
                if (drive_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = drive_cal_input.getText().toString();
                    drive_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_skating:
                if (skating_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = skating_cal_input.getText().toString();
                    skating_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_jumping_rope:
                if (jumping_rope_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = jumping_rope_cal_input.getText().toString();
                    jumping_rope_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_skiing:
                if (skiing_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = skiing_cal_input.getText().toString();
                    skiing_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_gymnastics:
                if (gymnastics_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = gymnastics_cal_input.getText().toString();
                    gymnastics_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_roller_skating:
                if (roller_skating_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = roller_skating_cal_input.getText().toString();
                    roller_skating_cal = Integer.parseInt(S);
                }
                break;
            case R.id.btn_swimming:
                if (swimming_cal_input.getText().toString().equals(""))
                {
// Здесь код, если EditText пуст
                }
                else
                {
                    S = swimming_cal_input.getText().toString();
                    swimming_cal = Integer.parseInt(S);
                }
                break;
            default:
                break;
        }
    }
}
