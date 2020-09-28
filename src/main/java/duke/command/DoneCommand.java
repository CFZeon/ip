package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for marking a task as done
 */
public class DoneCommand extends Command {
    String number;
    /**
     * Constructs a command with numerical user input for marking task as done
     */
    public DoneCommand(String number) {
        this.number = number;
    }

    /**
     * Calls the mark task as done function
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskDone(tasks, ui, storage, number);
    }
}
