/*
 *
 */

package name.bagi.levente.pedometer;

import java.util.ArrayList;

/**
 * Вызов всех слушаютелей объектов многократно.
 * Интервал определяется пользовательскими настройками.
 */
public class SpeakingTimer implements StepListener {

    PedometerSettings mSettings;
    Utils mUtils;
    float mInterval;
    long mLastSpeakTime;
    
    public SpeakingTimer(PedometerSettings settings, Utils utils) {
        mLastSpeakTime = System.currentTimeMillis();
        mSettings = settings;
        mUtils = utils;
    }

    
    public void onStep() {
        long now = System.currentTimeMillis();
        long delta = now - mLastSpeakTime;
        
        if (delta / 60000.0 >= mInterval) {
            mLastSpeakTime = now;
            notifyListeners();
        }
    }
    
    public void passValue() {
        // not used
    }

    
    //-----------------------------------------------------
    // Слушатель
    
    public interface Listener {
        public void speak();
    }
    private ArrayList<Listener> mListeners = new ArrayList<Listener>();

    public void addListener(Listener l) {
        mListeners.add(l);
    }
    public void notifyListeners() {
        for (Listener listener : mListeners) {
            listener.speak();
        }
    }

}

