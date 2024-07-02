import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }

    @Test
    public void thresholdReached (){
        LogginLab lab = new LogginLab();
        int limit = 6;
        lab.setThreshold(limit);

        for (int i = 0; i <= 10; i++){
            if (lab.thresholdReached(i) == false && i < limit){
                logger.log(Level.INFO, "You're still under limit. It is " + i);
                assertFalse(lab.thresholdReached(i));
            } else if (lab.thresholdReached(i) == true) {
                logger.log(Level.INFO, "You REACHED the threshold. It is " + i);
                assertTrue(lab.thresholdReached(i));
            } else if (lab.thresholdReached(i) == false && i > limit){
                logger.log(Level.INFO, "You now exceeded the threshold. It is " + i);
                assertFalse(lab.thresholdReached(i));
            }
        }
    }
}