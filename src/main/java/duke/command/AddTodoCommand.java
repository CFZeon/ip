package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for a adding a todo
 */
public class AddTodoCommand extends Command{
    String message;
    /**
     * Constructs a command with user input for adding a todo
     */
    public AddTodoCommand(String message) {
        this.message = message;
    }

    /**
     * Calls the add todo function
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddTodo(tasks, ui, storage, this.message);
    }
}
