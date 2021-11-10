package view;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.DeadLine;
import model.Requirement;
import model.StartDate;
import model.Status;
import model.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProjectViewModel {

    private StringProperty nameProperty;
    private StringProperty descriptionProperty;
    private IntegerProperty projectIDProperty;
    private StringProperty statusProperty;
    private ObjectProperty<StartDate> startDateProperty;
    private ObjectProperty<DeadLine> deadLineProperty;
    private ObservableList<Member> membersProperty;
    private ObservableList<Requirement> requirementsProperty;
    private IntegerProperty membersCountProperty;

    public  ProjectViewModel(Project project)
    {
        nameProperty = new SimpleStringProperty(project.getName());
        descriptionProperty = new SimpleStringProperty(project.getDescription());
        projectIDProperty = new SimpleIntegerProperty(project.getProjectId());
        statusProperty = new SimpleStringProperty(project.getStatus().toString());
        startDateProperty = new SimpleObjectProperty<>(project.getStartDate());
        deadLineProperty = new SimpleObjectProperty<>(project.getDeadLine());
        membersProperty = FXCollections.observableArrayList(project.getAllMembers());
        requirementsProperty = FXCollections.observableArrayList(project.getAllRequirements());
        membersCountProperty = new SimpleIntegerProperty(project.getNumberOfMembers());
    }

    public StringProperty getNameProjectProperty() {
        return nameProperty;
    }

    public StringProperty getDescriptionProperty() {
        return descriptionProperty;
    }

    public IntegerProperty getProjectIDProperty() {
        return projectIDProperty;
    }

    public StringProperty getStatusProperty() {
        return statusProperty;
    }

    public ObjectProperty<StartDate> getStartDateProperty() {
        return startDateProperty;
    }

    public ObjectProperty<DeadLine> getDeadLineProperty() {
        return deadLineProperty;
    }

    public ObservableList<Member> getMembersProperty()
    {
        return membersProperty;
    }

    public ObservableList<Requirement> getRequirementsProperty()
    {
        return requirementsProperty;
    }

    public IntegerProperty getMembersCountProperty()
    {
        return membersCountProperty;
    }
}
