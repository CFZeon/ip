package duke.task;

/**
 * Represents a Todo task
 */
public class Todo extends Task{
    /**
     * Constructs an instantiation of an deadline
     *
     * @param description Description of the todo
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Prints a fully formatted todo
     *
     * @return Returns a fully formatted todo string
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
