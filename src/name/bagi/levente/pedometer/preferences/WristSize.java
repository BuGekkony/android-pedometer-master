package name.bagi.levente.pedometer.preferences;

/**
 * Created by Люда on 14.06.2015.
 */
import android.content.Context;
import android.util.AttributeSet;
import name.bagi.levente.pedometer.R;

public class WristSize extends EditMeasurementPreference{

    public WristSize(Context context) {
        super(context);
    }
    public WristSize(Context context, AttributeSet attr) {
        super(context, attr);
    }
    public WristSize(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    protected void initPreferenceDetails() {
        mTitleResource = R.string.wrist_size_setting_title;
        mMetricUnitsResource = R.string.centimeters;
    }

}
