import java.util.Scanner;

public class Duke {
    static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {
        String inputString = "";
        Task[] tasks = new Task[100];
        int tasksCount = 0;
        Scanner in = new Scanner (System.in);

        welcomeMessage();

        while (!inputString.equals("bye")) {
            inputString = in.nextLine();
            String[] inputSplit = inputString.trim().split(" ", 2);
            String[] inputSplitAtSlash;

            switch(inputSplit[0].trim()){
            case "list":
                taskList(tasks, tasksCount);
                break;
            case "done":
                taskDone(tasks, tasksCount, inputSplit);
                break;
            case "todo":
                tasks[tasksCount] = new Todo(inputSplit[1]);
                tasksCount = taskAddMessage(tasks[tasksCount], tasksCount);
                break;
            case "deadline":
                inputSplitAtSlash = inputSplit[1].trim().split("/", 2);
                tasks[tasksCount] = new Deadline(inputSplitAtSlash[0], inputSplitAtSlash[1]);;
                tasksCount = taskWithTimeAddMessage(tasks[tasksCount], tasksCount);
                break;
            case "event":
                inputSplitAtSlash = inputSplit[1].trim().split("/", 2);
                tasks[tasksCount] = new Event(inputSplitAtSlash[0], inputSplitAtSlash[1]);
                tasksCount = taskWithTimeAddMessage(tasks[tasksCount], tasksCount);
                break;
            case "bye":
                break;
            default:
                invalidCommandMessage();
            }
        }

        byeMessage();
    }

    private static void welcomeMessage() {
        System.out.println(LINE + System.lineSeparator() + "Hello! I'm Duke" + System.lineSeparator()
                + "What can I do for you?" + System.lineSeparator() + LINE);
    }

    private static void invalidCommandMessage() {
        System.out.println(LINE + System.lineSeparator() + "Sorry! You have entered an invalid command."
                + System.lineSeparator() + LINE);
    }

    private static int taskAddMessage(Task task, int tasksCount) {
        System.out.println(LINE + System.lineSeparator() + "Got it. I've added this task: "
                + System.lineSeparator() + "[" + task.getTaskType() + "][" + task.getStatusIcon()+ "] "
                + task.getDescription() + task.getDoBy());
        tasksCount += 1;
        System.out.println("Now you have " + tasksCount + " tasks in the list.");
        System.out.println(LINE);
        return tasksCount;
    }

    private static int taskWithTimeAddMessage(Task task, int tasksCount) {
        System.out.println(LINE + System.lineSeparator() + "Got it. I've added this task: ");
        System.out.println("[" + task.getTaskType() + "][" + task.getStatusIcon()
                + "] " + task.getDescription() + task.getDoBy());
        tasksCount += 1;
        System.out.println("Now you have " + tasksCount + " tasks in the list.");
        System.out.println(LINE);
        return tasksCount;
    }

    private static void taskList(Task[] tasks, int tasksCount) {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasksCount; i++) {
            System.out.println((i+1) + ".[" + tasks[i].getTaskType() + "]["
                    + tasks[i].getStatusIcon() + "]" + tasks[i].getDescription()
                    + tasks[i].getDoBy());
        }
        System.out.println(LINE);
    }

    private static void taskDone(Task[] tasks, int tasksCount, String[] inputSplit) {
        System.out.println(LINE);
        if (Integer.parseInt(inputSplit[1]) > 0 && Integer.parseInt(inputSplit[1]) <= tasksCount) {
            tasks[Integer.parseInt(inputSplit[1]) - 1].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[" + tasks[Integer.parseInt(inputSplit[1]) - 1].getTaskType() + "]["
                    + tasks[Integer.parseInt(inputSplit[1]) - 1].getStatusIcon() + "] "
                    + tasks[Integer.parseInt(inputSplit[1]) - 1].getDescription()
                    + tasks[Integer.parseInt(inputSplit[1]) - 1].getDoBy());
        } else {
            System.out.println("Sorry! There is no task at " + inputSplit[1] + ".");
        }
        System.out.println(LINE);
    }

    private static void byeMessage() {
        System.out.println(LINE + System.lineSeparator() +"Bye. Hope to see you again soon!"
                + System.lineSeparator() + LINE);
    }
}


