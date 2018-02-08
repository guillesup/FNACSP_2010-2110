package net.ddns.starla.fnacsp.template.algorithms;

import java.time.ZonedDateTime;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public final class AlgorithmTwo extends Algorithm {
    @Override
    public void compute(ZonedDateTime zonedDateTime, double longitude,
                        double latitude, double pressure, double temperature) {

        timeScaleComputation(zonedDateTime);

        double wte = 0.017202786 * te;
        double s1 = sin(wte);
        double c1 = cos(wte);
        double s2 = 2.0 * s1 * c1;
        double c2 = (c1 + s1) * (c1 - s1);
        double s3 = s2 * c1 + c2 * s1;
        double c3 = c2 * c1 - s2 * s1;
        double s4 = 2.0 * s2 * c2;
        double c4 = (c2 + s2) * (c2 - s2);

        rightAscension = -1.38880 + 1.72027920e-2 * te + 3.199e-2 * s1 - 2.65e-3 * c1 + 4.050e-2 * s2 + 1.525e-2 * c2
                + 1.33e-3 * s3 + 3.8e-4 * c3 + 7.3e-4 * s4 + 6.2e-4 * c4;

        shiftRightAscensionToItsConventionalRange();

        declination = 6.57e-3 + 7.347e-2 * s1 - 3.9919e-1 * c1 + 7.3e-4 * s2 - 6.60e-3 * c2 + 1.50e-3 * s3
                - 2.58e-3 * c3 + 6e-5 * s4 - 1.3e-4 * c4;

        hourAngle = 1.75283 + 6.3003881 * t + longitude - rightAscension;

        shiftHourAngleToItsConventionalRange();
        applyFinalComputationallyOptimizedProcedure(latitude, pressure, temperature);
    }

}