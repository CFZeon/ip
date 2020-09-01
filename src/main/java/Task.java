public class Task {
    protected String description;
    protected String doBy;
    protected boolean isDone;
    protected char taskType;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.doBy = "";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return (description);
    }

    public String getDoBy() { return (doBy);}

    public char getTaskType() {return (taskType);}

    public void markAsDone() {
        isDone = true;
    }
}
