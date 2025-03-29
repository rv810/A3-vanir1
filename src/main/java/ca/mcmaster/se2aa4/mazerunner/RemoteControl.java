package ca.mcmaster.se2aa4.mazerunner;

public class RemoteControl {
    Command slot;

    public RemoteControl() {}

    public void setCommand(Command command) {
        slot = command;
    }
    
    public void PathOperation() {
        slot.execute();
    }
}
