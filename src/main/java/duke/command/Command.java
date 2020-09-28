package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains basic information for a command structure
 */
public abstract class Command {
    /**
     * Constructs an empty instantiation of this class
     */
    public Command() {
    }

    /**
     * Provides format for constructing a command
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);
}
