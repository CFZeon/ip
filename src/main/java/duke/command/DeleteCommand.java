package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for a deleting a task
 */
public class DeleteCommand extends Command {
    String number;
    /**
     * Constructs a command with numerical user input for deleting task
     */
    public DeleteCommand(String number) {
        this.number = number;
    }

    /**
     * Calls the add delete task
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskDelete(tasks, ui, storage, number);
    }
}
