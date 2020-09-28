package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Contains actions for listing help
 */
public class HelpCommand extends Command {
    /**
     * Constructs an empty instantiation of this class
     */
    public HelpCommand() {
    }

    /**
     * Calls the help function
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.taskHelp();
    }
}
