public class Deadline extends Task {
    public Deadline(String description, String doBy) {
        super(description);
        this.doBy = doBy;
        taskType = 'D';
    }

    @Override
    public String getDoBy() {
        return ("(" + doBy + ")");
    }
}
