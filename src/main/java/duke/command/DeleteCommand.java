package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DeleteCommand extends Command {
    String number;

    public DeleteCommand(String number) {
        this.number = number;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskDelete(tasks, ui, storage, number);
    }
}
