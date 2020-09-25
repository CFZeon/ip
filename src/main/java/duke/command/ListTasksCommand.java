package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ListTasksCommand extends Command {
    public ListTasksCommand(){
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.taskList(tasks);
    }
}
