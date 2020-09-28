package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains a blank command for while loop in Duke inputLoop to exit
 */
public class ByeCommand extends Command {
    /**
     * Constructs an empty instantiation of this class
     */
    public ByeCommand(){
    }

    /**
     * Executes nothing
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
    }
}
