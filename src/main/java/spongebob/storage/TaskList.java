package spongebob.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import spongebob.exception.SpongebobException;
import spongebob.task.Task;

/**
 * Storage class to keep tasks for the user
 */
public class TaskList {

    private List<Task> cache;

    public TaskList() {
        this.cache = new ArrayList<>();
    }

    public TaskList(Storage storage) throws SpongebobException {
        this.cache = storage.load();
    }

    public List<Task> getCache() {
        return this.cache;
    }

    public void update(int index, Task task) throws IndexOutOfBoundsException {
        cache.set(index, task);
    }

    public void add(Task task) {
        this.cache.add(task);
    }

    public void delete(int index) {
        this.cache.remove(index);
    }

    public int size() {
        return this.cache.size();
    }

    /**
     * Display list in index order such as 1.[T][ ] return books
     * @return String form of the list of tasks in index order
     */
    @Override
    public String toString() {
        ListIterator<Task> iter = this.cache.listIterator();
        StringBuilder builder = new StringBuilder();

        while (iter.hasNext()) {
            Task cur = iter.next();
            builder.append((iter.previousIndex() + 1) + "." + cur + "\n");
        }

        return builder.toString();
    }

    /**
     * Returns the list of tasks whose description fits the keyword given
     *
     * @param keyword A keyword for filtering out tasks
     * @return List of Tasks that fits the keyword
     */

    public List<Task> find(String keyword) {
        List<Task> res = new ArrayList<>();
        for (Task task : cache) {
            if (task.contains(keyword)) {
                res.add(task);
            }
        }
        return res;
    }
}
