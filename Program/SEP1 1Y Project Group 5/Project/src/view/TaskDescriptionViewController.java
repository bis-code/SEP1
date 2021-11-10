package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.ProjectModel;
import java.awt.*;
public class TaskDescriptionViewController
{
  @FXML private Label taskDescription;
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
    taskDescription.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
        state.getSelectedTask()).getDescription());
  }
  @FXML private void onBackButton()
  {
    state.setSelectedTask(state.getSelectedTask());
    viewHandler.openView("DetailsRequirement");
  }
}