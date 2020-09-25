package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.DukeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage{
    static final String TASKS_SAVE_PATH = "data/tasksList.txt";
    private static ArrayList<Task> tasksList = new ArrayList<>();

    public void saveTasks(ArrayList<Task> saveInput) throws DukeException{
        File saveFile = new File(TASKS_SAVE_PATH);
        boolean doesFileExist = saveFile.exists();
        tasksList = saveInput;

        try {
            // make new directory and create new file if it does not exist
            if (!doesFileExist) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            throw new DukeException("Unable to create new directory or file!");
        }

        // Create Save file
        try {
            FileWriter saveFileWriter = new FileWriter(TASKS_SAVE_PATH);

            for (Task task : tasksList){
                String textLineToAdd = task.getClass().getSimpleName() + " | " +
                        task.getIsDone() + " | " +
                        task.getDescription();

                if (task instanceof Deadline || task instanceof Event) {
                    textLineToAdd = textLineToAdd + " | " + task.getDoBy()[0] + " | " +
                            task.getDoBy()[1];
                }

                textLineToAdd += "\n";
                saveFileWriter.write(textLineToAdd);
            }

            saveFileWriter.close();
        } catch (IOException e) {
            throw new DukeException("Cannot write to task list save file");
        }
    }

    public ArrayList<Task> loadTasksList() throws DukeException{
        // creates file for the path
        File saveFile = new File(TASKS_SAVE_PATH);
        boolean doesFileExist = saveFile.exists();

        try {
            // make new directory and create new file if it does not exist
            if (!doesFileExist) {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            throw new DukeException("Unable to create new directory or file!");
        }
        try {
            // scanner with file as input source
            Scanner saveFileScanner = new Scanner(saveFile);

            while (saveFileScanner.hasNext()) {
                String curLine = saveFileScanner.nextLine();
                // a limit of 0 splits the string as many times as possible
                String[] taskDesc = curLine.trim().split(" \\| ", 0);
                switch (taskDesc[0]) {
                case "Todo": {
                    if (taskDesc.length != 3) {
                        throw new DukeException("loadFile");
                    }
                    Todo temp = new Todo(taskDesc[2]);
                    temp.setIsDone(Boolean.parseBoolean(taskDesc[1]));
                    tasksList.add(temp);
                    break;
                }
                case "Event": {
                    if (taskDesc.length != 5){
                        throw new DukeException("loadFile");
                    }
                    Event temp = new Event(taskDesc[2], taskDesc[3] + " " + taskDesc[4]);
                    temp.setIsDone(Boolean.parseBoolean(taskDesc[1]));
                    tasksList.add(temp);
                    break;
                }
                case "Deadline": {
                    if (taskDesc.length != 5){
                        throw new DukeException("loadFile");
                    }
                    Deadline temp = new Deadline(taskDesc[2], taskDesc[3] + " " + taskDesc[4]);
                    temp.setIsDone(Boolean.parseBoolean(taskDesc[1]));
                    tasksList.add(temp);
                    break;
                }
                default: {
                    System.out.println("It seems like some of your tasks were not saved properly!");
                    break;
                }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DukeException("Unable to read save File");
        } catch (DukeException e) {
            e.getError("loadFile");
        }
        return tasksList;
    }
}
