import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String inputString = "";
        Task[] tasks = new Task[100];
        int tasksCount = 0;
        Scanner in = new Scanner (System.in);

        printLine();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        printLine();

        while (!inputString.equals("bye")) {
            inputString = in.nextLine();
            String[] inputSplit = inputString.split(" ", 2);

            switch(inputSplit[0].trim()){
            case "list":
                printLine();
                for (int i = 0; i < tasksCount; i++) {
                    System.out.println((i+1) + ".[" + tasks[i].getStatusIcon()
                            + "] " + tasks[i].getDescription());
                }
                printLine();
                break;
            case "bye":
                break;
            case "done":
                printLine();
                if (Integer.parseInt(inputSplit[1]) > 0 && Integer.parseInt(inputSplit[1]) <= tasksCount) {
                    tasks[Integer.parseInt(inputSplit[1]) - 1].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + tasks[Integer.parseInt(inputSplit[1]) - 1].getStatusIcon() + "] "
                            + tasks[Integer.parseInt(inputSplit[1]) - 1].getDescription());
                } else {
                    System.out.println("Sorry! There is no task at " + inputSplit[1] + ".");
                }
                printLine();
                break;
            default:
                printLine();
                System.out.println("added: " + inputString);
                printLine();
                tasks[tasksCount] = new Task(inputString);
                tasksCount += 1;
            }
        }

        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }
}


