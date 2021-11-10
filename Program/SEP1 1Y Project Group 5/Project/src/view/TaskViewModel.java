package view;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
public class TaskViewModel {
    private final StringProperty taskNameProperty;
    private final StringProperty descriptionProperty;
    private final ObjectProperty<Status> statusProperty;
    private final ObservableList<Member> membersProperty;
    private final ObjectProperty<DeadLine> deadlineProperty;
    private final ObjectProperty<Time> timeProperty;
    private final IntegerProperty membersCountProperty;
    public TaskViewModel(Task task)
    {
        taskNameProperty = new SimpleStringProperty(task.getTaskName());
        descriptionProperty = new SimpleStringProperty(task.getDescription());
        statusProperty = new SimpleObjectProperty<>(task.getStatus());
        membersProperty = FXCollections.observableArrayList(task.getTaskMembers());
        deadlineProperty = new SimpleObjectProperty<>(task.getDeadLine());
        timeProperty = new SimpleObjectProperty<>(task.getTimeSpent());
        membersCountProperty = new SimpleIntegerProperty(task.getTaskMembers().size());
    }
    public StringProperty getTaskNameProperty() {
        return taskNameProperty;
    }

    public StringProperty getDescriptionProperty() {
        return descriptionProperty;
    }

    public ObjectProperty<Status> getStatusProperty() {
        return statusProperty;
    }

    public ObservableList<Member> getMembersProperty() {
        return membersProperty;
    }

    public IntegerProperty getMembersCountProperty()
    {
        return membersCountProperty;
    }

    public ObjectProperty<DeadLine> getDeadlineProperty() {
        return deadlineProperty;
    }

    public ObjectProperty<Time> getTimeProperty() {
        return timeProperty;
    }
}