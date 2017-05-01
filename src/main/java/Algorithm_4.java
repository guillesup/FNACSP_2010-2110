import static java.lang.Math.*;

public class Algorithm_4 extends Algorithm {
    @Override
    public void computeSunPosition(double hour, int day, int month, int year, double longitude,
                                   double latitude, double pressure, double temperature) {

        timeScaleComputation(hour, day, month, year);

        double wte = 0.0172019715 * te;

        double l = 1.752790 + 1.720279216e-2 * te + 3.3366e-2 * sin(wte - 0.06172) + 3.53e-4 * sin(2.0 * wte - 0.1163);

        double nu = 9.282e-4 * te - 0.8;
        double dlam = 8.34e-5 * sin(nu);
        double lambda = l + PI + dlam;

        double epsi = 4.089567e-1 - 6.19e-9 * te + 4.46e-5 * cos(nu);

        double sl = sin(lambda);
        double cl = cos(lambda);
        double se = sin(epsi);
        double ce = sqrt(1 - se * se);

        rightAscension = atan2(sl * ce, cl);

        if (rightAscension < 0.0)
            rightAscension += PI2;

        declination = asin(sl * se);

        hourAngle = 1.7528311 + 6.300388099 * t + longitude - rightAscension + 0.92 * dlam;
        shiftHourAngleToItsConventionalRange(latitude, pressure, temperature);

        applyFinalComputationallyOptimizedProcedure(latitude, pressure, temperature);
    }
}