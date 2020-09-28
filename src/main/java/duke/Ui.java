package duke;

import duke.task.Deadline;
import duke.task.Event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ui {
    static final String LINE = "____________________________________________________________";

    public void taskHelp() {
        printLine();
        System.out.println("Here are a list of available commands:");
        System.out.println("\"done [number on list]\": marks a task on the list as done");
        System.out.println("\"todo [action]\": adds a todo into the list");
        System.out.println("\"deadline [action] /[limit] [date] [time]\": adds a deadline into the list");
        System.out.println("deadlines also print your own strings, or just dates alone");
        System.out.println("\"event [action] /[limit] [date] [time]\": adds an event into the list");
        System.out.println("events also print your own strings, or just dates alone");
        System.out.println("\"help\": brings you to this menu!");
        System.out.println("\"delete [number on list]\": removes a task from the list");
        System.out.println("\"bye\": exits duke");
        System.out.println("Failed to use date and time properly? Try this:");
        System.out.println("dd/MM/yyyy HHmm");
        printLine();
    }

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

    public void taskAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: "
                + System.lineSeparator() + TaskList.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + tasks.getTasksSize() + " tasks in the list.");
        printLine();
    }

    protected void taskWithTimeAddMessage(TaskList tasks) {
        printLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(TaskList.tasks.get(tasks.getTasksSize() - 1));
        System.out.println("Now you have " + TaskList.tasks.size() + " tasks in the list.");
        printLine();
    }

    public void taskDeleteMessage(int taskNumber) {
        System.out.println("Noted. I've removed this task:");
        // 0 based array index so task location is -1
        int taskIndex = taskNumber - 1;
        System.out.println(TaskList.tasks.get(taskIndex));
        TaskList.tasks.remove(taskIndex);
        System.out.println("Now you have " + TaskList.tasks.size() + " tasks in the list.");
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

    public void dateSearch(LocalDate date) {
        printLine();
        System.out.println("Here are the tasks at " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
        for (int i = 0; i < TaskList.tasks.size(); i++) {
            if (TaskList.tasks.get(i) instanceof Event || TaskList.tasks.get(i) instanceof Deadline) {
                if (date.equals(TaskList.tasks.get(i).getDate())) {
                    System.out.println((i + 1) + " " + TaskList.tasks.get(i));
                }
            }
        }
        printLine();
    }

    protected static void printLine() {
        System.out.println(LINE);
    }

    public void taskFind(TaskList tasks, Ui ui, Storage storage, String inputSplit) {
        printLine();
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < TaskList.tasks.size(); i++) {
            String description = TaskList.tasks.get(i).getDescription();
            if (description.contains(inputSplit)) {
                System.out.println((i+1) + ". " + TaskList.tasks.get(i));
            }
        }
        printLine();
    }
}
