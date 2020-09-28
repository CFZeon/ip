package duke;

/**
 * Contains methods for all user interactions
 */
public class Ui {
    static final String LINE = "____________________________________________________________";

    /**
     * Prints out a list of commands for duke
     */
    public void taskHelp() {
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

    /**
     * Lists out all the tasks in the list
     * @param tasks Instantiation of TaskList
     */
    public void taskList(TaskList tasks) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        if (tasks.getTasksSize() == 0) {
            System.out.println("Oops! Looks like there's nothing in your list!");
        }
        for (int i = 0; i < tasks.getTasksSize(); i++) {
            System.out.println((i + 1) + "." + TaskList.tasks.get(i));
        }
        printLine();
    }

    /**
     * Print messasge for adding a task when it is a todo
     * @param tasks Instantiation of TaskList
     */
    public void taskAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: "
                + System.lineSeparator() + TaskList.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + tasks.getTasksSize() + " tasks in the list.");
        printLine();
    }

    /**
     * Prints the message for adding a task when it is a deadline or event
     * @param tasks Instantiation of TaskList
     */
    protected void taskWithTimeAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(TaskList.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + TaskList.tasks.size() + " tasks in the list.");
        printLine();
    }

    /**
     * Prints delete message after deleting a task
     * @param taskNumber 1-based index of task number in the list
     */
    public void taskDeleteMessage(int taskNumber) {
        System.out.println("Noted. I've removed this task:");
        // 0 based array index so task location is -1
        int taskIndex = taskNumber - 1;
        System.out.println(TaskList.tasks.get(taskIndex));
        TaskList.tasks.remove(taskIndex);
        System.out.println("Now you have " + TaskList.tasks.size() + " tasks in the list.");
    }

    /**
     * Prints the welcome message at launch time
     */
    public void welcomeMessage() {
        printLine();
        System.out.println("Hello! I'm Duke!" + System.lineSeparator()
                + "What can I do for you?");
        printLine();
    }

    /**
     * Prints a message when a command is not recognised
     */
    protected static void invalidCommandMessage() {
        printLine();
        System.out.println("Sorry! You have entered an invalid command.");
        System.out.println("Type \"help\" to view a list of available commands!");
        printLine();
    }

    /**
     * Prints the farewell message
     */
    protected void byeMessage() {
        printLine();
        System.out.println("Bye! Hope to see you again soon!");
        printLine();
    }

    /**
     * Prints a line for user interface
     */
    protected static void printLine() {
        System.out.println(LINE);
    }
}
