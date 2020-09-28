package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for a adding an event
 */
public class AddEventCommand extends Command {
    String UnprocessedMessage;
    /**
     * Constructs a command with user input for adding an event
     */
    public AddEventCommand(String UnprocessedMessage) {
        this.UnprocessedMessage = UnprocessedMessage;
    }

    /**
     * Calls the add event function
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddEvent(tasks, ui, storage, this.UnprocessedMessage);
    }
}
