/*
 *
 */

package name.bagi.levente.pedometer;

/**
 *Интерфейс реализуется классами, которые могут обрабатывать уведомления о шагах.
   * Эти классы могут быть переданы StepDetector.
 */
public interface StepListener {
    public void onStep();
    public void passValue();
}

