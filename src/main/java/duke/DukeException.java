package duke;

public class DukeException extends Exception{

    protected String error;

    public DukeException(String error){
        this.error=error;
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
        default:
            System.out.println("Please enter a valid command! Type \"help\" to see a list of commands!");
            break;
        }
    }
}