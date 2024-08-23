public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to) throws SpongebobException{
        super(description, TaskType.EVENT);
        this.from = from;
        this.to = to;

        // check for errors
        if (description.equals(" ") || from.equals(" ") || to.equals(" ")) {
            String msg = "";
            if (description.equals(" ")) {
                msg += " Description,";
            }
            if (from.equals(" ")) {
                msg += " From,";
            }
            if (to.equals(" ")) {
                msg += " To";
            }

            throw new SpongebobException("Barnacles! You missed out " + msg + "!");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from:" + from + "to:" + to + ")";
    }

    @Override
    public String save() {
        return super.save() + "|" + this.from + "|" + this.to;
    }
}
