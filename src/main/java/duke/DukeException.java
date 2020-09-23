package duke;

public class DukeException extends Exception{

    protected String error;

    public DukeException(String error){
        this.error = error;
    }

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
        default:
            System.out.println("Please enter a valid command! Type \"help\" to see a list of commands!");
            break;
        }
    }
}