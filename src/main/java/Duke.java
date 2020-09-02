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

            switch(inputSplit[0].trim()){
            case "list":
                taskList(tasks, tasksCount);
                break;
            case "done":
                taskDone(tasks, tasksCount, inputSplit);
                break;
            case "todo":
                tasksCount = taskAddTodo(tasks, tasksCount, inputSplit);
                break;
            case "deadline":
                tasksCount = taskAddDeadline(tasks, tasksCount, inputSplit[1]);
                break;
            case "event":
                tasksCount = taskAddEvent(tasks, tasksCount, inputSplit[1]);
                break;
            case "bye":
                break;
            default:
                invalidCommandMessage();
                break;
            }
        }

        byeMessage();
    }

    private static int taskAddEvent(Task[] tasks, int tasksCount, String s) {
        String[] inputSplitAtSlash;
        //splits input into task and time
        inputSplitAtSlash = s.trim().split("/", 2);
        tasks[tasksCount] = new Event(inputSplitAtSlash[0], inputSplitAtSlash[1]);
        tasksCount = taskWithTimeAddMessage(tasks[tasksCount], tasksCount);
        return tasksCount;
    }

    private static int taskAddDeadline(Task[] tasks, int tasksCount, String s) {
        String[] inputSplitAtSlash;
        //splits input into task and time
        inputSplitAtSlash = s.trim().split("/", 2);
        tasks[tasksCount] = new Deadline(inputSplitAtSlash[0], inputSplitAtSlash[1]);
        tasksCount = taskWithTimeAddMessage(tasks[tasksCount], tasksCount);
        return tasksCount;
    }

    private static int taskAddTodo(Task[] tasks, int tasksCount, String[] inputSplit) {
        tasks[tasksCount] = new Todo(inputSplit[1]);
        tasksCount = taskAddMessage(tasks[tasksCount], tasksCount);
        return tasksCount;
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

    private static void taskList(Task[] tasks, int tasksCount) {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasksCount; i++) {
            System.out.println((i+1) + "." + tasks[i]);
        }
        System.out.println(LINE);
    }

    private static void taskDone(Task[] tasks, int tasksCount, String[] inputSplit) {
        System.out.println(LINE);
        int taskNumber = Integer.parseInt(inputSplit[1]);
        // to check if the task exists
        if (taskNumber < 0 && taskNumber >= tasksCount) {
            System.out.println("Sorry! There is no task at " + taskNumber + ".");
            return;
        }
        tasks[taskNumber - 1].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskNumber + "." + tasks[taskNumber - 1]);
        System.out.println(LINE);
    }

    private static void byeMessage() {
        System.out.println(LINE + System.lineSeparator() +"Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }
}


