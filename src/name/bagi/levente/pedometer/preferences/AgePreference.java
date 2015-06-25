package name.bagi.levente.pedometer.preferences;

import android.content.Context;
import android.util.AttributeSet;
import name.bagi.levente.pedometer.R;

public class AgePreference extends EditMeasurementPreference{
    public AgePreference(Context context) {
        super(context);
    }
    public AgePreference(Context context, AttributeSet attr) {
        super(context, attr);
    }
    public AgePreference(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    protected void initPreferenceDetails() {
        mTitleResource = R.string.age_setting_title;
        mMetricUnitsResource = R.string.age;
    }

}


