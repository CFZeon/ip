package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DoneCommand extends Command {
    String number;
    public DoneCommand(String number) {
        this.number = number;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskDone(tasks, ui, storage, number);
    }
}
