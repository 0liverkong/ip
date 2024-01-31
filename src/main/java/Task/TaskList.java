import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private static int count = 0;

    TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task t) {
        tasks.add(t);
        count++;
    }

    public void remove(int i) {
        this.tasks.remove(i);
    }

    public Task get(int i) {
        return this.tasks.get(i);
    }

    public int size() {
        return this.tasks.size();
    }

    public void printStatus() {
        if (count == 0) {
            System.out.println("Now you have no tasks on the list :(((");
        } else if (count == 1) {
            System.out.println("You have 1 task on the list!");
        } else {
            System.out.printf("You have %d tasks on the list!%n", count);
        }
    }

    public String fileRepresentation() {
        ArrayList<String> a = new ArrayList<>();
        for (Task t : this.tasks) {
            a.add(t.fileRepresentation());
        }
        return String.join("\n", a);
    }

    @Override
    public String toString() {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            a.add(String.format("%d. %s",
                    i + 1,
                    this.tasks.get(i)));
        }
        return String.join("\n", a);
    }
}
