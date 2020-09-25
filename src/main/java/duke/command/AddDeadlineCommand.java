package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class AddDeadlineCommand extends Command {
    String UnprocessedMessage;

    public AddDeadlineCommand(String UnprocessedMessage) {
        this.UnprocessedMessage = UnprocessedMessage;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.taskAddDeadline(tasks, ui, storage, this.UnprocessedMessage);
    }
}
