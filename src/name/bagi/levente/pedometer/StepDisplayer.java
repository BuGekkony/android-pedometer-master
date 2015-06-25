/*
 */

package name.bagi.levente.pedometer;

import java.util.ArrayList;

/**
 * Считает действия, предусмотренные StepDetector и проходящим током
 * Шаг рассчитыватся на деятельности.
 */
public class StepDisplayer implements StepListener {

    //private int mCount = 0;
    public static int mCount = 0;
    PedometerSettings mSettings;
    Utils mUtils;

    public StepDisplayer(PedometerSettings settings, Utils utils) {
        mUtils = utils;
        mSettings = settings;
        notifyListener();
    }
    public void setUtils(Utils utils) {
        mUtils = utils;
    }

    public void setSteps(int steps) {
        mCount = steps;
        notifyListener();
    }
    public void onStep() {
        mCount ++;
        notifyListener();
    }
    public void reloadSettings() {
        notifyListener();
    }
    public void passValue() {
    }
    
    

    //-----------------------------------------------------
    // Слушатель
    
    public interface Listener {
        public void stepsChanged(int value);
        public void passValue();
    }
    private ArrayList<Listener> mListeners = new ArrayList<Listener>();

    public void addListener(Listener l) {
        mListeners.add(l);
    }
    public void notifyListener() {
        for (Listener listener : mListeners) {
            listener.stepsChanged((int)mCount);
        }
    }
    
    
}
