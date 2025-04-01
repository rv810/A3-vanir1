package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RemoteControl {
    Command slot;
    private static final Logger logger = LogManager.getLogger();

    public RemoteControl() {}

    public void setCommand(Command command) {
        slot = command;
    }
    
    public void PathOperation() {
        if (slot == null) {
            logger.warn("No command set!");
        }
        slot.execute();
    }
}
