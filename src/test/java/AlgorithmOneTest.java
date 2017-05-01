import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AlgorithmOneTest {

    private Algorithm algorithm;
    private double delta;

    private void computeSunPosition() {
        algorithm.computeSunPosition(0.0, 25, 1, 2020, 0.21787, 0.73117, 1.0, 20.0);
    }

    private boolean isInRange(double leftBound, double rightBound, double value){
        return value >= leftBound && value <= rightBound;
    }

    @Before
    public void setUp() throws Exception {
        algorithm = new Algorithm_1();
        computeSunPosition();
        delta = 0.0001;
    }

    @Test
    public void zenithAtZeroUT() throws Exception {
        assertEquals(2.7204, algorithm.getZenith(), delta);
    }

    @Test
    public void azimuthAtZeroUT() throws Exception {
        assertEquals(-2.74575, algorithm.getAzimuth(), delta);
    }

    @Test
    public void rightAscensionAtZeroUT() throws Exception {
        assertEquals(-0.931113, algorithm.getRightAscension(), delta);
    }

    @Test
    public void declinationAtZeroUT() throws Exception {
        assertEquals(-0.334789, algorithm.getDeclination(), delta);
    }

    @Test
    public void hourAngleAtZeroUT() throws Exception {
        assertEquals(-9.25708, algorithm.getHourAngle(), delta);
    }

    @Test
    public void zenithInRange() throws Exception {
        assertTrue(isInRange(0, Algorithm.PI, algorithm.getZenith()));
    }

    @Test
    public void azimuthInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PI, Algorithm.PI, algorithm.getAzimuth()));
    }

    @Test
    @Ignore
    public void rightAscensionInRange() throws Exception {
        assertTrue(isInRange(0, Algorithm.PI2, algorithm.getRightAscension()));
    }

    @Test
    public void declinationInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PIM, Algorithm.PIM, algorithm.getDeclination()));
    }

    @Test
    @Ignore
    public void hourAngleInRange() throws Exception {
        assertTrue(isInRange(-Algorithm.PI, Algorithm.PI, algorithm.getHourAngle()));
    }
}