package command;

import task.Task;
import task.TaskList;
import dook.Ui;
import dook.Storage;
import dook.DookException;

public class MarkCommand extends Command {

    private final int positionToMark;

    public MarkCommand(int positionToMark) {
        this.positionToMark = positionToMark;
    }

    /**
     * Marks a task as done.
     *
     * @param tasks The bot TaskList.
     * @param ui The user interface.
     * @param storage The storage interface.
     * @throws DookException If TaskList is empty or indexed out of bounds.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DookException {
        Task toMark;
        try {
            toMark = tasks.get(positionToMark - 1);
        } catch (IndexOutOfBoundsException e) {
            DookException err;
            if (tasks.size() == 0) {
                err = new DookException("Nooo! You don't have any tasks to mark :(");
            } else {
                err = new DookException(String.format("Nooo! " +
                                "You have %d tasks!" +
                                " Valid inputs for mark is in the range [1 - %d]",
                        tasks.size(), tasks.size()));
            }
            throw err;
        }
        toMark.markAsDone();
        ui.println("Oki! :D Good job! I've marked this task as done:");
        ui.println(toMark.toString());
        storage.write(tasks);
    }
}
