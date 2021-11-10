package view;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
public class CustomizeRequirementsViewController {
    @FXML private Label idRequirement;
    @FXML private Label errorLabel;
    @FXML private TextField requirementName;
    @FXML private TextField requirementDescription;
    private ViewHandler viewHandler;
    private ProjectModel model;
    private Region root;
    private ViewState state;

    public CustomizeRequirementsViewController ()
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
    public void reset()
    {
        idRequirement.setText(String.valueOf(model.getRequirementId(model.getProject(state.getSelectedProject()).getRequirementByIndex(state.getSelectedRequirement()))));
        errorLabel.setText("");
        requirementName.setText("");
        requirementDescription.setText("");
    }
    public Region getRoot()
    {
        return root;
    }
    @FXML public void onChangeButton()
    {
        try
        {
            if (requirementName.equals("") && !(requirementDescription.equals(""))) //only change description
            {
                model.setRequirementDescription(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),requirementDescription.getText(),model.getProject(state.getSelectedProject()));
            }
            else if (!(requirementName.equals("")) && requirementDescription.equals("")) //only change the name
            {
                model.setRequirementName(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),requirementName.getText(),model.getProject(state.getSelectedProject()));
            }
            else if (!(requirementName.equals("")) && !(requirementDescription.equals(""))) //change both
            {
                model.setRequirementName(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),requirementName.getText(),model.getProject(state.getSelectedProject()));
                model.setRequirementDescription(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),requirementDescription.getText(),model.getProject(state.getSelectedProject()));
            }
            viewHandler.openView("DetailsProject");
        }
        catch(IllegalArgumentException e)
        {
            errorLabel.setText("Error: " + e.getMessage());
        }
    }
    @FXML public void onCancel()
    {
        state.setSelectedRequirement(-1);
        viewHandler.openView("DetailsProject");
    }
}