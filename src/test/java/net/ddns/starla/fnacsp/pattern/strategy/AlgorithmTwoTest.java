package net.ddns.starla.fnacsp.pattern.strategy;

import net.ddns.starla.fnacsp.pattern.factory.Accuracy;
import net.ddns.starla.fnacsp.pattern.factory.AlgorithmFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class AlgorithmTwoTest {

    private final double delta = 1.0E-05;
    private Algorithm algorithm;
    private double hour;
    private int day;
    private int month;
    private int year;
    private double longitude;
    private double latitude;
    private double pressure;
    private double temperature;
    private double expectedZenith;
    private double expectedAzimuth;
    private double expectedRightAscension;
    private double expectedDeclination;
    private double expectedHourAngle;

    public AlgorithmTwoTest(double hour, int day, int month, int year, double longitude, double latitude, double pressure,
                            double temperature, double expectedZenith, double expectedAzimuth, double expectedRightAscension,
                            double expectedDeclination, double expectedHourAngle) {
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.longitude = longitude;
        this.latitude = latitude;
        this.pressure = pressure;
        this.temperature = temperature;
        this.expectedZenith = expectedZenith;
        this.expectedAzimuth = expectedAzimuth;
        this.expectedRightAscension = expectedRightAscension;
        this.expectedDeclination = expectedDeclination;
        this.expectedHourAngle = expectedHourAngle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.72044, -2.75076, -0.929042, -0.334191, -9.25915},
                {1, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.60396, -2.27114, -0.928282, -0.334015, -8.9974},
                {2, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.4366, -1.95515, -0.927521, -0.333839, -8.73564},
                {3, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.24891, -1.72906, -0.92676, -0.333662, -8.47388},
                {4, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.05463, -1.54538, -0.926, -0.333486, -8.21213},
                {5, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.86106, -1.37882, -0.92524, -0.333309, -7.95037},
                {6, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.67357, -1.21415, -0.924479, -0.333132, -7.68862},
                {7, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.49449, -1.04017, -0.923719, -0.332954, -7.42686},
                {8, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.33852, -0.847375, -0.922959, -0.332777, -7.1651},
                {9, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.20765, -0.627947, -0.922199, -0.3326, -6.90335},
                {10, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.11352, -0.378416, -0.921439, -0.332422, -6.64159},
                {11, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.06669, -0.104343, -0.92068, -0.332244, -6.37983},
                {12, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.07367, 0.177664, -0.91992, -0.332066, -6.11808},
                {13, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.13342, 0.446694, -0.91916, -0.331887, -5.85632},
                {14, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.23798, 0.688716, -0.918401, -0.331709, -5.59456},
                {15, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.37639, 0.90091, -0.917642, -0.33153, -5.33281},
                {16, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.53587, 1.08827, -0.916882, -0.331352, -5.07105},
                {17, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.7204, 1.25922, -0.916123, -0.331173, -4.80929},
                {18, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 1.90983, 1.42364, -0.915364, -0.330993, -4.54754},
                {19, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.10394, 1.59348, -0.914605, -0.330814, -4.28578},
                {20, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.29707, 1.78586, -0.913846, -0.330635, -4.02402},
                {21, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.48075, 2.03039, -0.913088, -0.330455, -3.76226},
                {22, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.638, 2.38216, -0.912329, -0.330275, -3.50051},
                {23, 25, 1, 2020, 0.21787, 0.73117, 1, 20, 2.73211, 2.90902, -0.91157, -0.330095, -3.23875}
        });
    }

    @Before
    public void computeSunPosition() {
        algorithm = new AlgorithmFactory().getInstance(Accuracy.LOW);
        algorithm.compute(hour, day, month, year, longitude, latitude, pressure, temperature);
    }

    @Test
    public void zenithAtUT() throws Exception {
        assertEquals(expectedZenith, algorithm.getZenith(), delta);
    }

    @Test
    public void azimuthAtUT() throws Exception {
        assertEquals(expectedAzimuth, algorithm.getAzimuth(), delta);
    }

    @Test
    public void rightAscensionAtUT() throws Exception {
        assertEquals(expectedRightAscension, algorithm.getRightAscension(), delta);
    }

    @Test
    public void declinationAtUT() throws Exception {
        assertEquals(expectedDeclination, algorithm.getDeclination(), delta);
    }

    @Test
    public void hourAngleAtUT() throws Exception {
        assertEquals(expectedHourAngle, algorithm.getHourAngle(), delta);
    }

    @Test
    public void zenithInRange() throws Exception {
        assertTrue(isInRange(0, Algorithm.PI, algorithm.getZenith()));
    }

    private boolean isInRange(double leftBound, double rightBound, double value) {
        return value >= leftBound && value <= rightBound;
    }

    @Test
    public void azimuthInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PI, Algorithm.PI, algorithm.getAzimuth()));
    }

    public void rightAscensionInRange() throws Exception {
        assertTrue(isInRange(0, Algorithm.PI2, algorithm.getRightAscension()));
    }

    @Test
    public void declinationInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PIM, Algorithm.PIM, algorithm.getDeclination()));
    }

    public void hourAngleInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PI, Algorithm.PI, algorithm.getHourAngle()));
    }
}