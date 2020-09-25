package duke;

import duke.command.*;

public class Parser extends TaskList {

    protected static Command parseCommand(String inputString) {
        // limit of 2 splits the string into 2 parts
        String[] inputSplit = inputString.trim().split(" ", 2);
        String command = inputSplit[0];
        String message = inputSplit[1];
        Command c = null;
        switch (command) {
        case "list":
            c = new ListTasksCommand();
            break;
        case "done":
            c = new DoneCommand(message);
            break;
        case "todo":
            c = new AddTodoCommand(message);
            break;
        case "deadline":
            c = new AddDeadlineCommand(message);
            break;
        case "event":
            c = new AddEventCommand(message);
            break;
        case "help":
            c = new HelpCommand();
            break;
        case "delete":
            c = new DeleteCommand(message);
            break;
        case "bye":
            c = new ByeCommand();
            break;
        default:
            Ui.invalidCommandMessage();
            break;
        }
        return c;
    }
}
