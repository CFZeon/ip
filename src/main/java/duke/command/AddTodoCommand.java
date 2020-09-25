package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class AddTodoCommand extends Command{
    String message;

    public AddTodoCommand(String message) {
        this.message = message;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddTodo(tasks, ui, storage, this.message);
    }
}
