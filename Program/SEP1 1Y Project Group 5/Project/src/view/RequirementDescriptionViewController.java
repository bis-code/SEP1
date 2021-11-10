package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ProjectModel;
public class RequirementDescriptionViewController
{
  @FXML private Label requirementDescription;
  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private ViewState state;
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.state = state;
    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    requirementDescription.setText(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement())
        .getDescription());
  }
  @FXML void onBack()
  {
    viewHandler.openView("DetailsProject");
  }
}