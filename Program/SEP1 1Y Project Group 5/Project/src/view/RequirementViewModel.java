package view;

import javafx.beans.property.*;
import model.*;

public class RequirementViewModel {

    private final StringProperty requirementNameProperty;
    private final StringProperty descriptionProperty;
    private final IntegerProperty idProperty;
    private final StringProperty timeSpentProperty;
    private final StringProperty teamMemberProperty;
    private final StringProperty getNumberOfUnfinishedTasksProperty;
    private final StringProperty statusStringProperty;
    private final ObjectProperty<Time> estimatedTimeProperty;
    private final ObjectProperty<Member> memberProperty;
    private final ObjectProperty<Status> statusProperty;

    public RequirementViewModel(Requirement requirement)
    {
        requirementNameProperty = new SimpleStringProperty(requirement.getRequirementName());
        descriptionProperty = new SimpleStringProperty(requirement.getDescription());
        statusProperty = new SimpleObjectProperty<>(requirement.getStatus());
        statusStringProperty = new SimpleStringProperty(requirement.getStatus().toString());
        idProperty = new SimpleIntegerProperty(requirement.getId());
        getNumberOfUnfinishedTasksProperty = new SimpleStringProperty(requirement.getNumberOfUnfinishedTasks());
        teamMemberProperty = new SimpleStringProperty(requirement.getTeamMember());
        timeSpentProperty = new SimpleStringProperty(requirement.getTimeSpentOnTasks().toString());
        estimatedTimeProperty = new SimpleObjectProperty<>(requirement.getEstimatedTime());
        memberProperty = new SimpleObjectProperty<>(requirement.getMember());
    }

    public StringProperty getRequirementNameProperty() {
        return requirementNameProperty;
    }

    public ObjectProperty<Time> getEstimatedTimeProperty()
    {
        return estimatedTimeProperty;
    }

    public StringProperty getDescriptionProperty() {
        return descriptionProperty;
    }

    public ObjectProperty<Status> getStatusProperty() {
        return statusProperty;
    }

    public StringProperty getStatusStringProperty()
    {
        return statusStringProperty;
    }

    public IntegerProperty getIdProperty() {
        return idProperty;
    }

    public StringProperty getGetNumberOfUnfinishedTasksProperty()
    {
        return getNumberOfUnfinishedTasksProperty;
    }

    public ObjectProperty<Member> getMemberProperty()
    {
        return memberProperty;
    }

    public StringProperty getTeamMemberProperty()
    {
        return teamMemberProperty;
    }

    public StringProperty getTimeSpentProperty() {
        return timeSpentProperty;
    }
}
