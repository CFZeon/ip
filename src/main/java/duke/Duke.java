package duke;

import duke.command.Command;
import java.util.Scanner;

public class Duke extends Parser {
    private static final Scanner in = new Scanner (System.in);
    protected static Storage storage = new Storage();
    protected static Ui ui = new Ui();
    protected static Parser parser = new Parser();
    protected static TaskList tasks = new TaskList();

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
            Command c = parser.parseCommand(inputString);
            if (c != null) {
                c.execute(tasks, ui, storage);
            }
        }
    }

    private static void loadTasks() throws DukeException {
        tasks.tasks = storage.loadTasksList();
    }
}


