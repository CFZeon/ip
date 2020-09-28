package duke;

/**
 * Contains errors that duke might encounter during runtime
 */
public class DukeException extends Exception{

    protected String error;

    /**
     * Constructs an instantiation of this exception
     *
     * @param error Error type
     */
    public DukeException(String error){
        this.error = error;
    }

    /**
     * Shows the error the user encountered
     *
     * @param input Error type
     */
    public void getError(String input){
        switch (error) {
        case "format":
            System.out.println("Please enter a proper action after the command! \"" + input + " [action]\"");
            break;
        case "deadline":
            System.out.println("Please enter a proper deadline! \"deadline [task] /[limit] [time]\"");
            break;
        case "event":
            System.out.println("Please enter a proper event! \"event [task] /[limit] [time]\"");
            break;
        case "todo":
            System.out.println("Please enter a proper todo! \"todo [task]\"");
            break;
        case "delete":
            System.out.println("Failed to delete! Try this instead \"delete [task number]\"" +
                    " or if that doesn't work, check if the task exists!");
            break;
        case "done":
            System.out.println("Failed to mark as done! Try this instead \"done [task number]\"");
            break;
        case "loadFile":
            System.out.println("List loading unsuccessful...");
            System.out.println("I saved what I could though!");
            break;
        default:
            System.out.println("Please enter a valid command! Type \"help\" to see a list of commands!");
            break;
        }
    }
}