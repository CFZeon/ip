package duke;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DateSearchCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.FindCommand;
import duke.command.HelpCommand;
import duke.command.ListTasksCommand;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser{

    protected static Command parseCommand(String inputString) {
        // limit of 2 splits the string into 2 parts
        String[] inputSplit = inputString.trim().split(" ", 2);
        Command c = null;
        try {
            String command = inputSplit[0];
            switch (command) {
            case "list":
                c = new ListTasksCommand();
                break;
            case "done":
                if (inputSplit.length < 2) {
                    throw new DukeException("done");
                }
                c = new DoneCommand(inputSplit[1]);
                break;
            case "todo":
                if (inputSplit.length < 2) {
                    throw new DukeException("todo");
                }
                c = new AddTodoCommand(inputSplit[1]);
                break;
            case "deadline":
                if (inputSplit.length < 2) {
                    throw new DukeException("deadline");
                }
                c = new AddDeadlineCommand(inputSplit[1]);
                break;
            case "event":
                if (inputSplit.length < 2) {
                    throw new DukeException("event");
                }
                c = new AddEventCommand(inputSplit[1]);
                break;
            case "help":
                c = new HelpCommand();
                break;
            case "delete":
                if (inputSplit.length < 2) {
                    throw new DukeException("delete");
                }
                c = new DeleteCommand(inputSplit[1]);
                break;
            case "dateSearch":
                if (inputSplit.length < 2) {
                    throw new DukeException("dateSearch");
                }
                c = new DateSearchCommand(inputSplit[1]);
                break;
            case "bye":
                c = new ByeCommand();
                break;
            case "find":
                if (inputSplit.length < 2) {
                    throw new DukeException("find");
                }
                c = new FindCommand(inputSplit[1]);
                break;
            default:
                Ui.invalidCommandMessage();
                break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.invalidCommandMessage();
        } catch (DukeException e) {
            Ui.printLine();
            e.getError("error");
            Ui.printLine();
        }
        return c;
    }

    public static LocalTime parseTime(String dateTimeInput) {
        String[] dateTimeSplit = dateTimeInput.trim().split(" ", 2);
        String timeInput;

        // checks if there is a time in the format dd-mm-yyyy HHmm format
        if (dateTimeSplit.length == 2) {
            timeInput = dateTimeSplit[1];
        } else {
            return null;
        }

        // formatter for dates with time
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

        LocalTime time = null;
        try {
            time = LocalTime.parse(timeInput, timeFormatter);
        } catch (DateTimeParseException e) {
            // returns null if input format is wrong
        }
        return time;
    }

    public static LocalDate parseDate(String dateTimeInput) {
        String[] dateTimeSplit = dateTimeInput.trim().split(" ", 2);
        String dateInput;
        dateInput = dateTimeSplit[0];

        // formatters for dates with time
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterB = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatterC = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateInput, formatterA);
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterB);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterC);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        try {
            if (date == null) {
                // this uses default formatter of yyyy-MM-dd
                date = LocalDate.parse(dateInput);
            }
        } catch (DateTimeParseException e) {
            // puts the date and time through all available formatters
        }
        // returns null if all the available formatters could not be used
        return date;
    }

}
