import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String inputString = "";
        String[] tasks = new String[100];
        int tasksCount = 0;
        Scanner in = new Scanner (System.in);

        printLine();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        printLine();

        while (!inputString.equals("bye")) {
            inputString = in.nextLine();
            switch(inputString){
            case "list":
                printLine();
                for (int i = 0; i < tasksCount; i++) {
                    System.out.println(i + ". " + tasks[i]);
                }
                printLine();
                break;
            case "bye":
                break;
            default:
                printLine();
                System.out.println("added: " + inputString);
                printLine();
                tasks[tasksCount] = inputString;
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
