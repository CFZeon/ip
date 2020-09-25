package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

public class TaskList {
    protected static ArrayList<Task> tasks = new ArrayList<>();

    public void taskDelete(TaskList tasks, Ui ui, Storage storage, String s) {
        ui.printLine();
        try {
            int taskNumber = Integer.parseInt(s);
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasks.getTasksSize()) {
                throw new DukeException("delete");
            }
            TaskList.taskDeleteMessage(taskNumber);
            storage.saveTasks(tasks.tasks);
        } catch (DukeException e) {
            e.getError("delete");
        }
        ui.printLine();
    }

    private static void taskDeleteMessage(int taskNumber) {
        System.out.println("Noted. I've removed this task:");
        // 0 based array index so task location is -1
        int taskIndex = taskNumber - 1;
        System.out.println(tasks.get(taskIndex));
        tasks.remove(taskIndex);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void taskAddEvent(TaskList tasks, Ui ui, Storage storage, String s) {
        String[] inputSplitAtSlash;
        try {
            //splits input into task and time
            inputSplitAtSlash = s.trim().split("/", 2);
            if (inputSplitAtSlash.length == 1) {
                throw new DukeException("event");
            }
            // if input string format does not fit constructor, throw error
            String[] constructorFormat = inputSplitAtSlash[1].trim().split(" ", 2);
            if (constructorFormat.length == 1) {
                throw new DukeException("event");
            }
            Event temp = new Event(inputSplitAtSlash[0], inputSplitAtSlash[1]);
            tasks.tasks.add(temp);
            ui.taskWithTimeAddMessage(tasks);
            storage.saveTasks(tasks.tasks);
        } catch (DukeException e) {
            ui.printLine();
            e.getError("event");
            ui.printLine();
        }
    }

    public void taskAddDeadline(TaskList tasks, Ui ui, Storage storage, String s) {
        String[] inputSplitAtSlash;
        try {
            //splits input into task and time
            inputSplitAtSlash = s.trim().split("/", 2);
            if (inputSplitAtSlash.length == 1) {
                throw new DukeException("deadline");
            }
            // if input string format does not fit constructor, throw error
            String[] constructorFormat = inputSplitAtSlash[1].trim().split(" ", 2);
            if (constructorFormat.length == 1) {
                throw new DukeException("deadline");
            }
            Deadline temp = new Deadline(inputSplitAtSlash[0], inputSplitAtSlash[1]);
            tasks.tasks.add(temp);
            ui.taskWithTimeAddMessage(tasks);
            storage.saveTasks(tasks.tasks);
        } catch (DukeException e) {
            ui.printLine();
            e.getError("deadline");
            ui.printLine();
        }
    }

    public void taskAddTodo(TaskList tasks, Ui ui, Storage storage, String input) {
        try {
            if (input.equals(null)) {
                throw new DukeException("todo");
            }
            Todo temp = new Todo(input);
            tasks.tasks.add(temp);
            ui.taskAddMessage(tasks);
            storage.saveTasks(tasks.tasks);
        } catch (DukeException e) {
            ui.printLine();
            e.getError("todo");
            ui.printLine();
        }
    }

    public void taskDone(TaskList tasks, Ui ui, Storage storage, String inputSplit) {
        ui.printLine();
        try {
            int taskNumber = Integer.parseInt(inputSplit);
            // on 0-index based array, location of task is -1
            int taskIndex = taskNumber - 1;
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasks.getTasksSize()) {
                throw new DukeException("done");
            }
            tasks.tasks.get(taskIndex).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskNumber + "." + tasks.tasks.get(taskIndex));
            storage.saveTasks(tasks.tasks);
        } catch (DukeException e) {
            e.getError("done");
        }
        ui.printLine();
    }

    public int getTasksSize() {
        return tasks.size();
    }
}
