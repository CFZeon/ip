import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String inputString = "";
        Scanner in = new Scanner (System.in);
        System.out.println("____________________________________________________________\n"
                +"Hello! I'm Duke\nWhat can I do for you?\n"
                +"____________________________________________________________");
        while (!inputString.equals("bye")) {
            System.out.println(inputString);
            inputString = in.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
