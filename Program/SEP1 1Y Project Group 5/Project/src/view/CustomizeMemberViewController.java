package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

import javax.swing.text.View;

import static model.Status.STATUS_SELECTION;

public class CustomizeMemberViewController {
    @FXML private Label taskNameLabel;
    @FXML private Label errorLabel;
    @FXML private TextField memberName;
    @FXML private ChoiceBox memberRoles;
    private ViewHandler viewHandler;
    private ViewState state;
    private Region root;
    private ProjectModel model;

    public CustomizeMemberViewController()
    {

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.state = state;
        reset();
    }

    public Region getRoot() {
        return root;
    }

    public void reset()
    {
        errorLabel.setText("");
        taskNameLabel.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                state.getSelectedTask()).getTaskName());
        memberName.setText("");
        memberRoles.setValue(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()
        ), state.getSelectedTask()).getTaskMembers().get(state.getSelectedMembers()).getRole());
        memberRoles.getItems().add("Team Member");
        memberRoles.getItems().add("Scrum Master");
        memberRoles.getItems().add("Product Owner");
    }

    @FXML public void onChangeButton()
    {
        if(memberName.getText().equals(""))
        {
            String actualstatus = (String)memberRoles.getValue();
            Member member;
            switch(actualstatus)
            {
                case "Team Member":
                    member = new TeamMember(memberName.getText());
                    model.setRole(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                            state.getSelectedTask()),member,state.getSelectedMembers());
                    break;
                case "Scrum Master":
                    member = new ScrumMaster(memberName.getText());
                    model.setRole(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                            state.getSelectedTask()),member,state.getSelectedMembers());
                    break;
                case "Product Owner":
                    member = new ProductOwner(memberName.getText());
                    model.setRole(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                            state.getSelectedTask()),member,state.getSelectedMembers());
                    break;
            }
        }
        else if(!(memberName.getText().equals("")))
        {
            model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                    state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().get(state.getSelectedMembers()).setName(memberName.getText());
        }

        viewHandler.openView("TaskMembers");
    }

    @FXML private void onCancelButton()
    {
        state.setSelectedMembers(-1);
        viewHandler.openView("TaskMembers");
    }
}
