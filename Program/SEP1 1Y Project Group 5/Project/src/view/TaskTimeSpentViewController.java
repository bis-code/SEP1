package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Time;

public class TaskTimeSpentViewController {

  @FXML private Label actualTaskName;
  @FXML private TextField taskHour;
  @FXML private TextField taskMinute;
  @FXML private Label errorLabel;
  private ViewState state;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private Region root;

  public TaskTimeSpentViewController()
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
    errorLabel.setText("");
    actualTaskName.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
        state.getSelectedTask()).getTaskName());
    taskHour.setText("");
    taskMinute.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void onChangeButton()
  {
    try{
      if(!(taskHour.getText().equals("") && taskMinute.getText().equals(""))) //Adding Hours and minutes
      {
        Time actualTime = new Time(Integer.valueOf(taskHour.getText()), Integer.valueOf(taskMinute.getText()));
        model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()), state.getSelectedTask()).setTimeSpent(actualTime);
      }
      else if(!(taskHour.getText().equals("") )&& taskMinute.getText().equals("")) //Adding Hours
      {
        Time actualTime = new Time(Integer.valueOf(taskHour.getText()), 0);
        model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()), state.getSelectedTask()).setTimeSpent(actualTime);
      }
      else if(taskHour.getText().equals("") && !(taskMinute.getText().equals(""))) //Adding Minutes
      {
        Time actualTime = new Time(0, Integer.valueOf(taskMinute.getText()));
        model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()), state.getSelectedTask()).setTimeSpent(actualTime);
      }
      viewHandler.openView("DetailsRequirement");
    }
    catch (Exception e){
      errorLabel.setText("Error: " + e.getMessage());
    }
  }

  @FXML private void onCancel()
  {
    state.setSelectedRequirement(-1);
    viewHandler.openView("DetailsRequirement");
  }
}