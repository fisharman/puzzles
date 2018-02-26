public class ButtonFloor implements Buttons{
    private Controller ctrl;
    private int floor;

    public ButtonFloor(Controller ctrl, int floor){
        this.ctrl = ctrl;
        this.floor = floor;
    }

    public int getFloor(){
        return this.floor;
    }

    @Override
    public boolean placeRequest(int input) {
        // adds floor to up or down queue
        ButtonDirection dir;

        if (input == 0)
            dir = ButtonDirection.down;
        else if(input == 1)
            dir = ButtonDirection.up;
        else
            return false;

        ctrl.callElevator(dir, this.floor);
        return true;
    }
}
