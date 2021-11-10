package view;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import view.*;
import java.util.Optional;
public class DetailsRequirementViewController
{
  @FXML private TableView<TaskViewModel> taskListTable;
  @FXML private TableColumn<TaskViewModel, String> tasksListColumn;
  @FXML private TableColumn<TaskViewModel, Status> statusColumn;
  @FXML private TableColumn<TaskViewModel, Time> timeSpent;
  @FXML private TableColumn<TaskViewModel, DeadLine> deadLine;
  @FXML private TableColumn<TaskViewModel, Number> membersColumn;
  @FXML private Label IDTask;
  @FXML private Label errorLabel;
  private Region root;
  private TaskListViewModel viewModel;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private ViewState state;

  public void init(ViewHandler viewHandler, ProjectModel model, Region root,
      ViewState state)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new TaskListViewModel(model,state);
    this.state = state;
    this.tasksListColumn.setCellValueFactory(cellData ->
        cellData.getValue().getTaskNameProperty());
    this.statusColumn.setCellValueFactory(cellData ->
        cellData.getValue().getStatusProperty());
    this.timeSpent.setCellValueFactory(cellData ->
        cellData.getValue().getTimeProperty());
    this.deadLine.setCellValueFactory(cellData ->
        cellData.getValue().getDeadlineProperty());
    taskListTable.setItems(viewModel.getList());
    this.membersColumn.setCellValueFactory(cellData ->
        cellData.getValue().getMembersCountProperty());
    reset();
  }

  public void reset()
  {
    IDTask.setText(String.valueOf(model.getRequirementId(
        model.getProject(state.getSelectedProject()).getRequirementByIndex(state.getSelectedRequirement()))));
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }
  @FXML private void onAddTask()
  {
    viewHandler.openView("AddTask");
  }

  @FXML private void onRemoveTask()
  {
    errorLabel.setText("");
    try
    {

      int index = taskListTable.getSelectionModel().getSelectedIndex();
      TaskViewModel selectedItem = taskListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation(index);
      if(remove)
      {
        model.removeTask(index,model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()));
        viewModel.remove(index);
        taskListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Couldn't find the item: " + e.getMessage());
    }
  }

  private boolean confirmation(int index)
  {
    TaskViewModel selectedItem = taskListTable.getItems().get(index);
    if (index > -1 && index < taskListTable.getItems().size())
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("DELETE TASK: Confirmation");
      String toString = selectedItem.getTaskNameProperty().getValue();
      alert.setHeaderText("Remove " + toString);
      Optional<ButtonType> result = alert.showAndWait();
      return result.isPresent() && result.get() == ButtonType.OK;
    }
    else return false;
  }

  @FXML private void onCustomizeTask()
  {
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    if(index > - 1 && index < taskListTable.getItems().size())
    {
      state.setSelectedTask(index);
      viewHandler.openView("CustomizeTask");
    }
    else errorLabel.setText("Please select a task first.");
  }

  @FXML private void onDescriptionTask()
  {
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    if(index > -1 && index < taskListTable.getItems().size())
    {
      state.setSelectedTask(index);
      viewHandler.openView("TaskDescription");
    }
    else errorLabel.setText("Please select a task first.");
  }

  @FXML private void onTimeSpentTask(){
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    if(index > -1 && index < taskListTable.getItems().size())
    {
      state.setSelectedTask(index);
      viewHandler.openView("TaskTimeSpent");
    }
    else errorLabel.setText("You did not choose any Task.");
  }

  @FXML private void onBackButton()
  {
    viewHandler.openView("DetailsProject");
  }
  @FXML private void onMembers(){
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    if(index > -1 && index < taskListTable.getItems().size())
    {
      state.setSelectedTask(index);
      viewHandler.openView("TaskMembers");
    }
    else errorLabel.setText("Please select a task first.");

  }
}
