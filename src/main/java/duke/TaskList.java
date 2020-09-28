package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

/**
 * Holds the task list and modifying functions
 */
public class TaskList {
    protected static ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Deletes a task from the list
     *
     * @param tasks TaskList instantiation
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     * @param s User number input
     */
    public void taskDelete(TaskList tasks, Ui ui, Storage storage, String s) {
        Ui.printLine();
        try {
            int taskNumber = Integer.parseInt(s);
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasks.getTasksSize()) {
                throw new DukeException("delete");
            }
            ui.taskDeleteMessage(taskNumber);
            storage.saveTasks(TaskList.tasks);
        } catch (DukeException e) {
            e.getError("delete");
        }
        Ui.printLine();
    }


    /**
     * Adds an event into the task list
     *
     * @param tasks TaskList instantiation
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     * @param s User string input
     */
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
            TaskList.tasks.add(temp);
            ui.taskWithTimeAddMessage(tasks);
            storage.saveTasks(TaskList.tasks);
        } catch (DukeException e) {
            Ui.printLine();
            e.getError("event");
            Ui.printLine();
        }
    }

    /**
     * Adds a deadline into the task list
     *
     * @param tasks TaskList instantiation
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     * @param s User string input
     */
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
            TaskList.tasks.add(temp);
            ui.taskWithTimeAddMessage(tasks);
            storage.saveTasks(TaskList.tasks);
        } catch (DukeException e) {
            Ui.printLine();
            e.getError("deadline");
            Ui.printLine();
        }
    }

    /**
     * Adds a todo into the task list
     *
     * @param tasks TaskList instantiation
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     * @param input User string input
     */
    public void taskAddTodo(TaskList tasks, Ui ui, Storage storage, String input) {
        try {
            Todo temp = new Todo(input);
            TaskList.tasks.add(temp);
            ui.taskAddMessage(tasks);
            storage.saveTasks(TaskList.tasks);
        } catch (DukeException e) {
            Ui.printLine();
            e.getError("todo");
            Ui.printLine();
        }
    }

    /**
     * Marks a task as done
     *
     * @param tasks TaskList instantiation
     * @param ui Ui instantiation
     * @param storage Storage instantiation
     * @param inputSplit User numerical input for task
     */
    public void taskDone(TaskList tasks, Ui ui, Storage storage, String inputSplit) {
        Ui.printLine();
        try {
            int taskNumber = Integer.parseInt(inputSplit);
            // on 0-index based array, location of task is -1
            int taskIndex = taskNumber - 1;
            // to check if the task exists
            if (taskNumber <= 0 || taskNumber > tasks.getTasksSize()) {
                throw new DukeException("done");
            }
            TaskList.tasks.get(taskIndex).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskNumber + "." + TaskList.tasks.get(taskIndex));
            storage.saveTasks(TaskList.tasks);
        } catch (DukeException e) {
            e.getError("done");
        }
        Ui.printLine();
    }

    /**
     * Returns size of tasks arraylist
     *
     * @return ArrayList size
     */
    public int getTasksSize() {
        return tasks.size();
    }
}
