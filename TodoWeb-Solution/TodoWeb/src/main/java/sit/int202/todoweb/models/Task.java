package sit.int202.todoweb.models;

public class Task {
    public enum Status {
        NOT_COMPLETED,
        COMPLETED
    }

    private String title;
    private Status status = Status.NOT_COMPLETED;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void completed() {
        this.status = Status.COMPLETED;
    }

    public void noCompleted() {
        this.status = Status.NOT_COMPLETED;
    }

    public void toggleStatus() {
        if(this.status==Status.NOT_COMPLETED) {
            this.status = Status.COMPLETED;
        } else {
            this.status = Status.NOT_COMPLETED;
        }
    }

    @Override
    public String toString() {
        return "Task : "+title+"\nStatus : "+(status==Status.NOT_COMPLETED ?"Not Completed":"Completed");
    }
}
