package view;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
public class AddTaskViewController {
  @FXML private Label errorLabel;
  @FXML private TextField taskName;
  @FXML private TextField taskDescription;
  @FXML private DatePicker endDate;
  private ViewState state;
  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private TaskListViewModel viewModel;
  public AddTaskViewController()
  {
  }
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.state = state;
    this.viewModel = new TaskListViewModel(model,state);
    reset();
  }
  public void reset()
  {
    this.errorLabel.setText("");
    this.taskName.setText("");
    this.taskDescription.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML void onAddTask()
  {
    try {
      Member member;
      TextField dateEditor = endDate.getEditor();
      String date = dateEditor.getText();
      String delims = "[/]";
      String[] tokens = date.split(delims);
      int month = Integer.parseInt(tokens[0]);
      int day = Integer.parseInt(tokens[1]);
      int year = Integer.parseInt(tokens[2]);
      DeadLine deadLine = new DeadLine(year, month, day);
//      switch (responsibleTeamMember.getText().toLowerCase())
//      {
//        case "team member":
//          TeamMember teamMember = new TeamMember(responsibleTeamMember.getText());
//          member = teamMember;
//          break;
//        case "scrum master":
//          ScrumMaster scrumMaster = new ScrumMaster(responsibleTeamMember.getText());
//          member = scrumMaster;
//          break;
//        case "product owner":
//          ProductOwner productOwner = new ProductOwner(responsibleTeamMember.getText());
//          member = productOwner;
//          break;
//        default: member = null;
//      }
      Task task = new Task(taskName.getText(), taskDescription.getText(),deadLine);
//      task.addMember(member);
      model.addTask(task, model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
          state.getSelectedRequirement()));
      viewModel.addTask(task);
      viewHandler.openView("DetailsRequirement");
    }
    catch (Exception e)
    {
      errorLabel.setText("Error: " + e.getMessage());
    }
  }

  @FXML private void onCancel()
  {
    viewHandler.openView("DetailsRequirement");
  }
}