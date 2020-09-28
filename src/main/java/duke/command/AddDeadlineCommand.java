package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for a adding a deadline
 */
public class AddDeadlineCommand extends Command {
    String UnprocessedMessage;
    /**
     * Constructs a command with user input for adding a deadline
     */
    public AddDeadlineCommand(String UnprocessedMessage) {
        this.UnprocessedMessage = UnprocessedMessage;
    }

    /**
     * Calls the add deadline function
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddDeadline(tasks, ui, storage, this.UnprocessedMessage);
    }
}
