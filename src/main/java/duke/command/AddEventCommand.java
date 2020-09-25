package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class AddEventCommand extends Command {
    String UnprocessedMessage;
    public AddEventCommand(String UnprocessedMessage) {
        this.UnprocessedMessage = UnprocessedMessage;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddEvent(tasks, ui, storage, this.UnprocessedMessage);
    }
}
