package duke.command;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.time.LocalDate;

public class DateSearchCommand extends Command {
    LocalDate dateQuery;
    /**
     * Constructs a command with date formatted user input for search query
     */
    public DateSearchCommand(String dateQuery) {
        this.dateQuery = Parser.parseDate(dateQuery);
    }

    /**
     * Calls the dateSearch command
     *
     * @param tasks ArrayList of Tasks
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.dateSearch(this.dateQuery);
    }
}
