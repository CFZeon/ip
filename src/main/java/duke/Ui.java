package duke;

import duke.task.Task;

public class Ui {
    static final String LINE = "____________________________________________________________";

    public static void taskHelp() {
        printLine();
        System.out.println("Here are a list of available commands:");
        System.out.println("\"done [number on list]\": marks a task on the list as done");
        System.out.println("\"todo [action]\": adds a todo into the list");
        System.out.println("\"deadline [action] /[limit] [time]\": adds a deadline into the list");
        System.out.println("\"event [action] /[limit] [time]\": adds an event into the list");
        System.out.println("\"help\": brings you to this menu!");
        System.out.println("\"delete [number on list]\": removes a task from the list");
        System.out.println("\"bye\": exits duke");
        printLine();
    }

    public static void taskList(TaskList tasks) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        if (tasks.getTasksSize() == 0) {
            System.out.println("Oops! Looks like there's nothing in your list!");
        }
        for (int i = 0; i < tasks.getTasksSize(); i++) {
            System.out.println((i + 1) + "." + tasks.tasks.get(i));
        }
        printLine();
    }

    public static void taskAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: "
                + System.lineSeparator() + tasks.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + tasks.getTasksSize() + " tasks in the list.");
        printLine();
    }

    protected static void taskWithTimeAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + tasks.tasks.size() + " tasks in the list.");
        printLine();
    }

    public void welcomeMessage() {
        printLine();
        System.out.println("Hello! I'm Duke!" + System.lineSeparator()
                + "What can I do for you?");
        printLine();
    }

    protected static void invalidCommandMessage() {
        printLine();
        System.out.println("Sorry! You have entered an invalid command.");
        System.out.println("Type \"help\" to view a list of available commands!");
        printLine();
    }

    protected void byeMessage() {
        printLine();
        System.out.println("Bye! Hope to see you again soon!");
        printLine();
    }

    protected static void printLine() {
        System.out.println(LINE);
    }
}
