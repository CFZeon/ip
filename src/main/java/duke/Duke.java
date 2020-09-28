package duke;

import duke.command.Command;
import java.util.Scanner;
import duke.Parser;

/**
 * Runs the Duke program
 */
public class Duke{
    private static Scanner in = new Scanner (System.in);
    protected static Storage storage = new Storage();
    protected static Ui ui = new Ui();
    protected static TaskList tasks = new TaskList();
    protected static Parser parser = new Parser();

    /**
     * Runs the Duke program through the main class
     *
     * @param args Runtime arguments are unused
     * @throws DukeException If command has error
     */
    public static void main(String[] args) throws DukeException {
        ui.welcomeMessage();

        loadTasks();
        inputLoop();

        ui.byeMessage();
    }

    private static void inputLoop() {
        String inputString = "";
        while (!inputString.equals("bye")) {
            inputString = in.nextLine();
            Command c = Parser.parseCommand(inputString);
            if (c != null) {
                c.execute(tasks, ui, storage);
            }
        }
    }

    private static void loadTasks() throws DukeException {
        TaskList.tasks = storage.loadTasksList();
        //clear the input buffer if loading fails
        in = new Scanner(System.in);
    }
}


