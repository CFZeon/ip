package duke.task;

/**
 * Represents a deadline
 */
public class Deadline extends Task {
    /**
     * Constructs an instantiation of an deadline
     *
     * @param description Description of the deadline
     * @param doBy Threshold of when the deadline should be met by
     */
    public Deadline(String description, String doBy) {
        super(description);
        this.doBy = doBy.trim().split(" ", 2);
    }

    /**
     * Prints a fully formatted deadline
     *
     * @return Returns a fully formatted deadline string
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(" + this.doBy[0] +": " + this.doBy[1] + ")";
    }
}
