package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for listing all tasks in the list
 */
public class ListTasksCommand extends Command {
    /**
     * Constructs an empty instantiation of this class
     */
    public ListTasksCommand(){
    }

    /**
     * Calls the list all tasks command
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.taskList(tasks);
    }
}
