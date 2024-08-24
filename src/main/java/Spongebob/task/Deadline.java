package Spongebob.task;

import Spongebob.exception.SpongebobException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    public String type;
    protected LocalDate by;

    public Deadline(String description, String by) throws SpongebobException {
        super(description, TaskType.DEADLINE);

        // check for errors
        if (description.equals(" ") || by.equals(" ")
                || description.isEmpty() || by.isEmpty()) {
            String msg = "";
            if (description.equals(" ") || description.isEmpty()) {
                msg += " Description,";
            }
            if (by.equals(" ") || by.isEmpty()) {
                msg += " By";
            }

            throw new SpongebobException("Barnacles! You missed out " + msg + "!");
        }

        try {
            this.by = LocalDate.parse(by, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException | NullPointerException e) {
            throw new SpongebobException("Barnacles! Please enter date at dd/mm/yyyy!");
        }

    }





    @Override
    public String toString() {

        return "[D]"
                + super.toString()
                + "(by: " + this.by.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")"; // convert
    }

    @Override
    public String save() {

        return super.save()
                + "|"
                + this.by.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


    }
}
