public interface Controller{
    boolean callElevator(ButtonDirection dir, int floor);
    boolean addStopRequest(int floor);
    ElevatorStatus floorQuery(ElevatorStatus status, int floor);
}
