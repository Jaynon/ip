package spongebob.command;


import spongebob.exception.SpongebobException;
import spongebob.storage.Storage;
import spongebob.storage.TaskList;
import spongebob.task.Deadline;
import spongebob.task.Event;
import spongebob.task.Task;
import spongebob.task.Todo;
import spongebob.ui.Ui;

/**
 * Creates a command that add an entry to the storage and/or tasklist
 */

public class AddCommand extends Command {

    private String[] arguments;

    public AddCommand(String[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the command
     * @param taskList The tasklist for Spongebob
     * @param ui    The Ui class containing all ui components
     * @param storage The storage for Spongebob to store entries
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = null;

        try {
            switch (this.arguments[0]) {
            case "todo":
                newTask = new Todo(arguments[1]);
                break;

            case "deadline":
                newTask = new Deadline(arguments[1], arguments[2]);
                break;

            case "event":
                newTask = new Event(arguments[1],
                        arguments[2],
                        arguments[3]);
                break;

            default:
                break;
            }

            taskList.add(newTask);
            storage.add(newTask);
            return ui.showTaskAdded(newTask, taskList.size());

        } catch (SpongebobException e) {
            return ui.showException(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String[] getArgs() {
        return this.arguments;
    }
}
