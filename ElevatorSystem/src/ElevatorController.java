import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ElevatorController implements Controller {
    private TreeSet<Integer> floorRequests;
    private Map<ButtonDirection, TreeSet<Integer>> elevatorRequests;

    public ElevatorController(){
        // could use builder pattern to add more elevator floor requests
        floorRequests = new TreeSet<>();

        elevatorRequests = new HashMap<>();
        for (ButtonDirection dir : ButtonDirection.values()){
            elevatorRequests.computeIfAbsent(dir, k -> new TreeSet<>());
        }
    }

    @Override
    public boolean callElevator(ButtonDirection dir, int floor){
        TreeSet<Integer> requestList = elevatorRequests.get(dir);
        requestList.add(floor);
        return true;
    }

    @Override
    public boolean addStopRequest(int floor){
        // add floor number to tree set
        floorRequests.add(floor);
        return true;
    }

    public ElevatorStatus floorQuery(ElevatorStatus status, int floor){
        // FIFO, shortest seek first

        if (floorRequests.remove(floor))
            return ElevatorStatus.serveFloor;

        switch (status) {
            case up:
                if (elevatorRequests.get(ButtonDirection.up).remove(floor))
                    return ElevatorStatus.serveFloor;

                if (floorRequests.higher(floor) != null || elevatorRequests.get(ButtonDirection.up).higher(floor) != null)
                    return ElevatorStatus.up;


            case down:
                if (elevatorRequests.get(ButtonDirection.down).remove(floor))
                    return ElevatorStatus.serveFloor;

                if (floorRequests.lower(floor) != null || elevatorRequests.get(ButtonDirection.down).lower(floor) != null)
                    return ElevatorStatus.down;


            case stop:
                // continuously checks for floor requests or elevator request
                // for now the, the algorithm prioritize people going down
                // calculate direction and move elevator
                if (!floorRequests.isEmpty()){
                    if (floorRequests.contains(floor))
                        return ElevatorStatus.serveFloor;

                    if (floorRequests.lower(floor) != null)
                        return ElevatorStatus.down;

                    if (floorRequests.higher(floor) != null)
                        return ElevatorStatus.up;


                }



                if (!elevatorRequests.get(ButtonDirection.down).isEmpty()){
                    if (elevatorRequests.get(ButtonDirection.down).remove(floor))
                        return ElevatorStatus.serveFloor;

                    if (elevatorRequests.get(ButtonDirection.down).last() > floor)
                        return ElevatorStatus.up;
                    else
                        return ElevatorStatus.down;
                }

                if (!elevatorRequests.get(ButtonDirection.up).isEmpty()){
                    if (elevatorRequests.get(ButtonDirection.up).remove(floor))
                        return ElevatorStatus.serveFloor;

                    if (elevatorRequests.get(ButtonDirection.up).last() > floor)
                        return ElevatorStatus.up;
                    else
                        return ElevatorStatus.down;
                }

        }

        // fall through, stop elevator
        return ElevatorStatus.stop;
    }
}
