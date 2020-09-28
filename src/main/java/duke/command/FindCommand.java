package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class FindCommand extends Command {
    String searchQuery;
    public FindCommand (String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.taskFind(tasks, ui, storage, searchQuery);
    }
}
