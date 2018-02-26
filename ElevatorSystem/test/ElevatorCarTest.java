import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ElevatorCarTest {

    Controller ctrl;
    ElevatorCar elevatorCar;
    ButtonElevator buttonElevator;
    ButtonFloor[] buttonFloors;

    private final int LOWEST_FLOOR = 1;
    private final int HIGHEST_FLOOR = 20;
    private final int DOWN = 0;
    private final int UP = 1;

    @Before
    public void setUp() throws Exception {
        ctrl = new ElevatorController();
        elevatorCar = new ElevatorCar(ctrl);

        buttonElevator = new ButtonElevator(ctrl);

        buttonFloors = new ButtonFloor[HIGHEST_FLOOR];
        for (int i = 0; i < HIGHEST_FLOOR; i++){
            buttonFloors[i] = new ButtonFloor(ctrl, i+1);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testButtonFloors() {
        for (int i = 0; i < HIGHEST_FLOOR; i++) {
            assertEquals("Floor " + (i + 1), buttonFloors[i].getFloor(), i+1);
        }
    }

    @Test
    public void startElevator_seq1() throws Exception {
        // TODO: find better thread testing framework
        elevatorCar.startElevator();

        buttonElevator.placeRequest(1);
        buttonElevator.placeRequest(3);
        TimeUnit.SECONDS.sleep(10);
        buttonElevator.placeRequest(2);
        buttonElevator.placeRequest(5);

        buttonFloors[14].placeRequest(DOWN);

        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    public void startElevator_seq2() throws Exception {
        // TODO: find better thread testing framework
        elevatorCar.startElevator();

        buttonFloors[14].placeRequest(DOWN);
        buttonFloors[10].placeRequest(UP);
        buttonElevator.placeRequest(5);
        buttonFloors[14].placeRequest(DOWN);
        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    public void startElevator_seq3() throws Exception {
        // TODO: find better thread testing framework
        elevatorCar.startElevator();

        buttonFloors[5].placeRequest(DOWN);
        TimeUnit.SECONDS.sleep(5);
        buttonFloors[0].placeRequest(UP);

        TimeUnit.SECONDS.sleep(15);
    }

}