package view;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

public class AddMembersToTaskViewController
{
    @FXML private Label taskNameLabel;
    @FXML private Label errorLabel;
    @FXML private TextField memberName;
    @FXML private ChoiceBox memberRoles;
    private ViewHandler viewHandler;
    private ProjectModel model;
    private Region root;
    private ViewState state;
    public AddMembersToTaskViewController()
    {
    }
    public void init(ViewHandler viewHandler, ProjectModel model, Region root,
                     ViewState state)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.state = state;
        reset();
    }
    public void reset()
    {
        this.taskNameLabel.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                state.getSelectedTask()).getTaskName());
        this.memberName.setText("");
        memberRoles.setValue(model.getProject(state.getSelectedProject()).getStatus());
        memberRoles.getItems().add("Team Member");
        memberRoles.getItems().add("Scrum Master");
        memberRoles.getItems().add("Product Owner");
    }
    public Region getRoot()
    {
        return root;
    }

    @FXML public void addTaskMember()
    {
        String memberRole = (String)memberRoles.getValue();
        Member member;
        try
        {
            switch (memberRole)
            {
                case "Team Member":
                    member = new TeamMember(memberName.getText());
                    break;
                case "Scrum Master":
                    member = new ScrumMaster(memberName.getText());
                    break;
                case "Product Owner":
                    member = new ProductOwner(memberName.getText());
                    break;
                default: member = null;
            }

            model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                    state.getSelectedTask()).getTaskMembers().add(member);
            model.addMember(model.getProject(state.getSelectedProject()),member);
            viewHandler.openView("TaskMembers");
        }
        catch (Exception e)
        {
            errorLabel.setText("Error: " + e.getMessage());
        }
    }
    @FXML public void onCancel()
    {
        state.setSelectedTask(-1);
        viewHandler.openView("TaskMembers");
    }
}
