package duke.task;

import duke.Parser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    boolean isDateExist;
    boolean isTimeExist;
    LocalTime time;
    LocalDate date;
    public Event(String description, String doBy) {
        super(description);
        this.doBy = doBy.trim().split(" ", 2);
        this.date = Parser.parseDate(this.doBy[1]);
        this.time = Parser.parseTime(this.doBy[1]);
        this.isDateExist = this.time != null;
        this.isTimeExist = this.date != null;
    }

    @Override
    public String toString() {
        if (isDateExist && isTimeExist) {
            return "[E]" + super.toString() + "(" + this.doBy[0] + ": "
                    + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ", "
                    + this.time.format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";
        } else if (isDateExist) {
            return "[E]" + super.toString() + "(" + this.doBy[0] + ": "
                    + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                    + ")";
        } else {
            return "[E]" + super.toString() + "(" + this.doBy[0] + ": " + this.doBy[1] + ")";
        }
    }
}
