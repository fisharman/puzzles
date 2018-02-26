import java.util.concurrent.TimeUnit;

enum ElevatorStatus{
    up, down, stop, serveFloor, maintenance
}

public class ElevatorCar {

    private final int LOWEST_FLOOR = 1;
    private final int HIGHEST_FLOOR = 20;
    private final int PAUSE_TIME = 1;

    private Controller ctrl;
    private int currentFloor;

    private ElevatorStatus currentStatus;

    public ElevatorCar(Controller ctrl){
        this.ctrl = ctrl;
        currentStatus = ElevatorStatus.stop;
        currentFloor = LOWEST_FLOOR;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public ElevatorStatus getCurrentStatus(){
        return currentStatus;
    }

    public void setElevatorStatus(ElevatorStatus status){
        currentStatus = status;
    }

    // async process that moves the elevator
    public void startElevator(){
        // TODO: elevator thread should only start once
        Runnable task = () -> {
            System.out.println("Starting elevator...");
            while (true) {
                try {
                    switch (currentStatus) {
                        case stop:
                            TimeUnit.SECONDS.sleep(PAUSE_TIME /2);
                            getInstruction();
                            break;
                        case up:
                            System.out.println("going up " + (currentFloor + 1));
                            currentFloor++;
                            TimeUnit.SECONDS.sleep(PAUSE_TIME);
                            if (currentFloor == HIGHEST_FLOOR)
                                currentStatus = ElevatorStatus.down;
                            getInstruction();
                            break;
                        case down:
                            System.out.println("going down " + (currentFloor - 1));
                            currentFloor--;
                            TimeUnit.SECONDS.sleep(PAUSE_TIME);
                            if (currentFloor == LOWEST_FLOOR)
                                currentStatus = ElevatorStatus.up;
                            getInstruction();
                            break;
                        case serveFloor:
                            System.out.println("serving " + currentFloor);
                            TimeUnit.SECONDS.sleep(PAUSE_TIME + 1);
                            getInstruction();
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void getInstruction(){
        currentStatus = ctrl.floorQuery(currentStatus, currentFloor);
        // TODO: if no response is received, default to serving the floor for safety
    }

}
