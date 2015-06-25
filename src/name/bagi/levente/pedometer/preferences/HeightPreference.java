package name.bagi.levente.pedometer.preferences;

import android.content.Context;
import android.util.AttributeSet;
import name.bagi.levente.pedometer.R;

public class HeightPreference extends EditMeasurementPreference{

    public HeightPreference(Context context) {
        super(context);
    }
    public HeightPreference(Context context, AttributeSet attr) {
        super(context, attr);
    }
    public HeightPreference(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    protected void initPreferenceDetails() {
        mTitleResource = R.string.height_setting_title;
        mMetricUnitsResource = R.string.centimeters;
    }
}

