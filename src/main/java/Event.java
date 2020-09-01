public class Event extends Task {
    public Event(String description, String doBy) {
        super(description);
        this.doBy = doBy;
        taskType = 'E';
    }

    @Override
    public String getDoBy() {
        return ("(" + doBy + ")");
    }
}
