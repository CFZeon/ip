package duke.command;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.time.LocalDate;

public class DateSearchCommand extends Command {
    LocalDate dateQuery;
    public DateSearchCommand(String dateQuery) {
        this.dateQuery = Parser.parseDate(dateQuery);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.dateSearch(this.dateQuery);
    }
}
