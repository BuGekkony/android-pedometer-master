/*
 *
 */

package name.bagi.levente.pedometer;


/**
 * Рассчитывает и отображает темп (шагов / мин), обрабатывает ввод нужного темпа,
   * Уведомляет пользователя, если он / она должен идти быстрее или медленнее.
 * 
 * Использование {}link PaceNotifier, вычисляет скорость как произведение темпами и длины шага.
 */
public class SpeedNotifier implements PaceNotifier.Listener {

    public interface Listener {
        public void valueChanged(float value);
        public void passValue();
    }
    private Listener mListener;
    
    int mCounter = 0;
    float mSpeed = 0;
    
    boolean mIsMetric;
    float mStepLength;

    PedometerSettings mSettings;
    Utils mUtils;


    
    public SpeedNotifier(Listener listener, PedometerSettings settings, Utils utils) {
        mListener = listener;
        mUtils = utils;
        mSettings = settings;
        reloadSettings();
    }
    public void setSpeed(float speed) {
        mSpeed = speed;
        notifyListener();
    }
    public void reloadSettings() {
        mIsMetric = mSettings.isMetric();
        mStepLength = mSettings.getStepLength();
        notifyListener();
    }
    
    private void notifyListener() {
        mListener.valueChanged(mSpeed);
    }
    
    public void paceChanged(int value) {
            mSpeed = // км / ч
                value * mStepLength // см / мин
                / 100000f * 60f; // см/км

        notifyListener();
    }

    
    public void passValue() {
        // Not used
    }

}

