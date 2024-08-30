package spongebob.command;

import spongebob.Ui;
import spongebob.storage.Storage;
import spongebob.storage.TaskList;


/**
 * Basic Command class for executing tasks
 */

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage);

    public abstract boolean isExit();

    public abstract String[] getArgs();
}
