package duke.task;


import java.time.LocalDate;
/**
 * Parents the other tasks
 */
public class Task {
    boolean isDateExist;
    protected boolean isDone;
    protected String description;
    protected String[] doBy;
    LocalDate date;

    /**
     * Constructs an instantiation of an deadline
     *
     * @param description Description for task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a tick or cross symbol from isDone boolean
     *
     * @return Tick or cross symbol
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Returns the description of a task
     *
     * @return Task description
     */
    public String getDescription() {
        return (description);
    }

    /**
     * Marks a task as done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Prints a formatted task string
     *
     * @return Formatted task string
     */
    public String toString(){
        return "[" + getStatusIcon() + "]" + description;
    }

    /**
     * Returns the boolean for whether a task is done
     *
     * @return Task done boolean
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Set the isDone boolean
     *
     * @param isDone Boolean for task completion
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Return the doBy status of task
     *
     * @return doBy string
     */
    public String[] getDoBy() {
        return doBy;
    }

    public LocalDate getDate() {
        return date;
    }
}
