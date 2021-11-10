package view;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import view.ViewHandler;
import view.ViewState;
import model.*;
public class AddResponsibleTeamMemberViewController
{
  @FXML private Label idRequirement;
  @FXML private Label errorLabel;
  @FXML private TextField memberName;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private Region root;
  private ViewState state;
  public AddResponsibleTeamMemberViewController()
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
    idRequirement.setText(String.valueOf(model.getRequirementId(
        model.getProject(state.getSelectedProject()).getRequirementByIndex(state.getSelectedRequirement()))));
    errorLabel.setText("");
    memberName.setText("");
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML public void onAddButton()
  {
    try{
      Member member = new TeamMember(memberName.getText());
      model.getRequirementById(Integer.valueOf(idRequirement.getText()),model.getProject(
          state.getSelectedProject())).setResponsibleTeamMember(member);
      viewHandler.openView("DetailsProject");
    }
    catch (Exception e)
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