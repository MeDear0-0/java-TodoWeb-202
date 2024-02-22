package sit.int202.todoweb.models;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<>();

    static {
        tasks.add(new Task("Review Java"));
        tasks.add(new Task("Intro Web App"));
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ArrayList<Task> tasks) {
        TaskList.tasks = tasks;
    }

    public Task find(String title) {
        for (Task task: tasks
             ) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public void remove(String title) {
        Task task = this.find(title);
        tasks.remove(task);
    }

    @Override
    public String toString() {
        StringBuilder task_format = new StringBuilder("--------------------\n");
        task_format.append("List task: \n");
        task_format.append("--------------------\n");
        for (Task task :
                tasks) {
            task_format.append(task.toString()).append('\n');
        }
        return task_format.toString();
    }
}
