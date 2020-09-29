package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for finding a task
 */
public class FindCommand extends Command {
    String searchQuery;
    /**
     * Constructs a command with user input for search query
     */
    public FindCommand (String searchQuery) {
        this.searchQuery = searchQuery;
    }

    /**
     * Calls the find command
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.taskFind(tasks, ui, storage, searchQuery);
    }
}
