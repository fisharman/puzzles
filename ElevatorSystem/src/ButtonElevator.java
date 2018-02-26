public class ButtonElevator implements Buttons{
    private Controller ctrl;

    public ButtonElevator(Controller ctrl){
        this.ctrl = ctrl;
    }

    @Override
    public boolean placeRequest(int input) {
        if (input <= 0)
            return false;

        ctrl.addStopRequest(input);
        return true;
    }
}
