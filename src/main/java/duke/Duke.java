package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    static final String LINE = "____________________________________________________________";
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner in = new Scanner (System.in);

    public static void main(String[] args) throws DukeException {
        welcomeMessage();

        int tasksCount = taskLoad();
        inputLoop(tasksCount);

        byeMessage();
    }

    private static int taskLoad() throws DukeException {
        int tasksCount;
        tasks = SaveLoad.loadTasksList();
        tasksCount = tasks.size();
        return tasksCount;
    }

    private static void inputLoop(int tasksCount) {
        String inputString = "";
        while (!inputString.equals("bye")) {
            inputString = in.nextLine();
            String[] inputSplit = inputString.trim().split(" ", 2);
            switch (inputSplit[0].trim()) {
            case "list":
                taskList(tasksCount);
                break;
            case "done":
                taskDone(tasksCount, inputSplit);
                break;
            case "todo":
                tasksCount = taskAddTodo(tasksCount, inputSplit);
                break;
            case "deadline":
                tasksCount = taskAddDeadline(tasksCount, inputSplit);
                break;
            case "event":
                tasksCount = taskAddEvent(tasksCount, inputSplit);
                break;
            case "bye":
                break;
            case "help":
                taskHelp();
                break;
            case "delete":
                tasksCount = taskDelete(tasksCount, inputSplit[1]);
                break;
            default:
                invalidCommandMessage();
                break;
            }
        }
    }

    private static int taskDelete(int tasksCount, String s) {
        System.out.println(LINE);
        try {
            int taskNumber = Integer.parseInt(s);
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasksCount) {
                throw new DukeException("delete");
            }
            System.out.println("Noted. I've removed this task:");
            System.out.println(tasks.get(taskNumber - 1));
            tasks.remove(taskNumber - 1);
            tasksCount -= 1;
            System.out.println("Now you have " + tasksCount + " tasks in the list.");
            SaveLoad.saveTasks(tasks);
        } catch (DukeException e) {
            e.getError("delete");
        }
        System.out.println(LINE);
        return tasksCount;
    }

    private static void taskHelp() {
        System.out.println(LINE);
        System.out.println("Here are a list of available command:");
        System.out.println("\"done [number on list]\": marks a task on the list as done");
        System.out.println("\"todo [action]\": adds a todo into the list");
        System.out.println("\"deadline [action] /[limit] [time]\": adds a deadline into the list");
        System.out.println("\"event [action] /[limit] [time]\": adds an event into the list");
        System.out.println("\"help\": brings you to this menu!");
        System.out.println("\"delete [number on list]\" removes a task from the list");
        System.out.println("\"bye\": exits duke.");
        System.out.println(LINE);
    }

    private static void taskList(int tasksCount) {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        if (tasksCount == 0) {
            System.out.println("Oops! Looks like there's nothing in your list!");
        }
        for (int i = 0; i < tasksCount; i++) {
            System.out.println((i+1) + "." + tasks.get(i));
        }
        System.out.println(LINE);
    }

    private static int taskAddEvent(int tasksCount, String[] s) {
        String[] inputSplitAtSlash;
        //splits input into task and time
        try {
            //splits input into task and time
            if (s.length == 1) {
                throw new DukeException("event");
            }
            inputSplitAtSlash = s[1].trim().split("/", 2);
            if (inputSplitAtSlash.length == 1) {
                throw new DukeException("event");
            }
            // if input string format does not fit constructor, throw error
            String[] constructorFormat = inputSplitAtSlash[1].trim().split(" ", 2);
            if (constructorFormat.length == 1) {
                throw new DukeException("event");
            }
            Event temp = new Event(inputSplitAtSlash[0], inputSplitAtSlash[1]);
            tasks.add(temp);
            tasksCount = taskWithTimeAddMessage(tasks.get(tasksCount), tasksCount);
            SaveLoad.saveTasks(tasks);
        } catch (DukeException e) {
            System.out.println(LINE);
            e.getError("event");
            System.out.println(LINE);
        }

        return tasksCount;
    }

    private static int taskAddDeadline(int tasksCount, String[] s) {
        String[] inputSplitAtSlash;
        try {
            //splits input into task and time
            if (s.length == 1) {
                throw new DukeException("deadline");
            }
            inputSplitAtSlash = s[1].trim().split("/", 2);
            if (inputSplitAtSlash.length == 1) {
                throw new DukeException("deadline");
            }
            // if input string format does not fit constructor, throw error
            String[] constructorFormat = inputSplitAtSlash[1].trim().split(" ", 2);
            if (constructorFormat.length == 1) {
                throw new DukeException("deadline");
            }
            Deadline temp = new Deadline(inputSplitAtSlash[0], inputSplitAtSlash[1]);
            tasks.add(temp);
            tasksCount = taskWithTimeAddMessage(tasks.get(tasksCount), tasksCount);
            SaveLoad.saveTasks(tasks);
        } catch (DukeException e) {
            System.out.println(LINE);
            e.getError("deadline");
            System.out.println(LINE);
        }
        return tasksCount;
    }

    private static int taskAddTodo(int tasksCount, String[] inputSplit) {
        try {
            if (inputSplit.length == 1) {
                throw new DukeException("todo");
            }
            Todo temp =  new Todo(inputSplit[1]);
            tasks.add(temp);
            tasksCount = taskAddMessage(tasks.get(tasksCount), tasksCount);
            SaveLoad.saveTasks(tasks);
        } catch (DukeException e) {
            System.out.println(LINE);
            e.getError("todo");
            System.out.println(LINE);
        }
        return tasksCount;
    }

    private static void welcomeMessage() {
        System.out.println(LINE + System.lineSeparator() + "Hello! I'm Duke!" + System.lineSeparator()
                + "What can I do for you?" + System.lineSeparator() + LINE);
    }

    private static void invalidCommandMessage() {
        System.out.println(LINE + System.lineSeparator() + "Sorry! You have entered an invalid command.");
        System.out.println("Type \"help\" to view a list of available commands!");
        System.out.println(LINE);
    }

    private static int taskAddMessage(Task task, int tasksCount) {
        System.out.println(LINE + System.lineSeparator() + "Got it. I've added this task: "
                + System.lineSeparator() + task);
        tasksCount += 1;
        System.out.println("Now you have " + tasksCount + " tasks in the list.");
        System.out.println(LINE);
        return tasksCount;
    }

    private static int taskWithTimeAddMessage(Task task, int tasksCount) {
        System.out.println(LINE + System.lineSeparator() + "Got it. I've added this task: ");
        System.out.println(task);
        tasksCount += 1;
        System.out.println("Now you have " + tasksCount + " tasks in the list.");
        System.out.println(LINE);
        return tasksCount;
    }

    private static void taskDone(int tasksCount, String[] inputSplit) {
        System.out.println(LINE);
        try {
            int taskNumber = Integer.parseInt(inputSplit[1]);
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasksCount) {
                throw new DukeException("done");
            }
            tasks.get(taskNumber - 1).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskNumber + "." + tasks.get(taskNumber - 1));
            SaveLoad.saveTasks(tasks);
        } catch (DukeException e) {
            e.getError("done");
        }
        System.out.println(LINE);
    }

    private static void byeMessage() {
        System.out.println(LINE);
        System.out.println("Bye! Hope to see you again soon!");
        System.out.println(LINE);
    }
}


