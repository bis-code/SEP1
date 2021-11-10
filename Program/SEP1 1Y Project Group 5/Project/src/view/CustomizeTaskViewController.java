package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

import java.time.LocalDate;

public class CustomizeTaskViewController {

  @FXML private Label actualTaskName;
  @FXML private TextField taskName;
  @FXML private TextField taskDescription;
  @FXML private DatePicker endDate;
  @FXML private Label errorLabel;
  @FXML private ChoiceBox taskStatus;
  private ViewState state;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private Region root;

  public CustomizeTaskViewController()
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

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");

    actualTaskName.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
        state.getSelectedTask()).getTaskName());

    taskName.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
        state.getSelectedTask()).getTaskName());

    taskDescription.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
        state.getSelectedTask()).getDescription());

    LocalDate localDate = LocalDate.of(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
        state.getSelectedRequirement()),state.getSelectedTask()).getDeadLine().getYear(),
        model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()),state.getSelectedTask()).getDeadLine().getMonth(),
        model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
            state.getSelectedRequirement()),state.getSelectedTask()).getDeadLine().getDay());
    endDate.setValue(localDate);
    taskStatus.setValue(model.getProject(state.getSelectedProject()).getStatus());
    taskStatus.getItems().add("Not started");
    taskStatus.getItems().add("Started");
    taskStatus.getItems().add("Ended");
    taskStatus.getItems().add("Approved");
    taskStatus.getItems().add("Rejected");
  }


  @FXML private void onChange()
  {
    try
    {
      model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
          state.getSelectedRequirement()), state.getSelectedTask()).setTaskName(taskName.getText());
      model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
          state.getSelectedRequirement()), state.getSelectedTask()).setDescription(taskDescription.getText());
      TextField dateEditor = endDate.getEditor();
      String date = dateEditor.getText();
      String delims = "[/]";
      String[] tokens = date.split(delims);
      int month = Integer.parseInt(tokens[0]);
      int day = Integer.parseInt(tokens[1]);
      int year = Integer.parseInt(tokens[2]);
      DeadLine deadLine = new DeadLine(year, month, day);
      model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
          state.getSelectedRequirement()), state.getSelectedTask()).setDeadLine(deadLine);
      String statuses = (String) taskStatus.getValue();
      Status status;
      switch (statuses)
      {
        case "Not started":
          status = new Status("Not started");
        break;
        case "Started":
          status = new Status("Started");
        break;
        case "Ended":
          status = new Status("Ended");
        break;
        case "Approved":
          status = new Status("Approved");
        break;
        case "Rejected":
          status = new Status("Rejected");
        break;
        default:
          status = null;
      }
      model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
          state.getSelectedRequirement()), state.getSelectedTask()).setStatus(status);
      viewHandler.openView("DetailsRequirement");
    }
    catch(Exception e)
    {
      errorLabel.setText("Error: All the boxes should be filled.");
    }

  }

  @FXML private void onCancelButton()
  {
    state.setSelectedTask(-1);
    viewHandler.openView("DetailsRequirement");
  }



}
