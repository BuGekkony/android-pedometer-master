/*
 *
 */

package name.bagi.levente.pedometer;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Activity для настройки Pedometer.
 *Начало, когда пользователь нажимает Настройки в главном меню.
 */
public class Settings extends PreferenceActivity {
    /** Вызывается, когда активность создается впервые. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(R.xml.preferences);

    }
}
