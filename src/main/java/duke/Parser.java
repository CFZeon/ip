package duke;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.HelpCommand;
import duke.command.ListTasksCommand;

/**
 * Parses inputs for other functions to use
 */
public class Parser{

    /**
     * Interprets the user input then creates a command
     *
     * @param inputString User input
     * @return Command
     */
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
            case "bye":
                c = new ByeCommand();
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
}
