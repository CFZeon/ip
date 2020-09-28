package duke.task;

/**
 * Represents an event
 */
public class Event extends Task {
    /**
     * Constructs an instantiation of an event
     *
     * @param description Description of the event
     * @param doBy Threshold of when the event is on
     */
    public Event(String description, String doBy) {
        super(description);
        this.doBy = doBy.trim().split(" ", 2);
    }

    /**
     * Prints a fully formatted event
     *
     * @return Returns a fully formatted event string
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(" + this.doBy[0] +": " + this.doBy[1] + ")";
    }
}
