public class MarkCommand extends Command{

    private String[] arguments;
    private int index;

    public MarkCommand(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        if (arguments[1].equals(" ") || arguments[1].isEmpty()) {
            if (this.arguments[0].equals("mark")) {
                ui.showMarkedError();
                return;
            } else {
                ui.showUnmarkedError();
                return;
            }
        }
        this.index = Integer.parseInt(arguments[1]) - 1;
        Task task = taskList.cache.get(index);

        try {
            if (this.arguments[0].equals("mark")) {
                task.markAsDone();
                taskList.update(this.index, task);
                storage.update(this.index, task);

                ui.showMarked(task);

            } else if (this.arguments[0].equals("unmark")) {
                task.unmarkAsDone();

                taskList.update(this.index, task);
                storage.update(this.index, task);
                ui.showUnmarked(task);
            }
        } catch (IndexOutOfBoundsException e) {
            ui.showException(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
