package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.*;

public class TaskMemberViewModel {
    private StringProperty nameProperty;
    private StringProperty roleProperty;

    public TaskMemberViewModel(Member member)
    {
        nameProperty = new SimpleStringProperty(member.getName());
        roleProperty = new SimpleStringProperty(member.getRole());
    }

    public StringProperty getNameProperty()
    {
        return nameProperty;
    }

    public StringProperty getRoleProperty()
    {
        return roleProperty;
    }

}
