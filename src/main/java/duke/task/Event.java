package duke.task;

public class Event extends Task {
    public Event(String description, String doBy) {
        super(description);
        this.doBy = doBy.trim().split(" ", 2);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(" + this.doBy[0] +": " + this.doBy[1] + ")";
    }
}
