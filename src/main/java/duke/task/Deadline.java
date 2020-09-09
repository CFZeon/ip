package duke.task;

public class Deadline extends Task {
    public Deadline(String description, String doBy) {
        super(description);
        this.doBy = doBy.trim().split(" ", 2);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(" + this.doBy[0] +": " + this.doBy[1] + ")";
    }
}
