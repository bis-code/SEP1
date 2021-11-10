package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.*;

import java.time.LocalDate;

import static model.Status.STATUS_SELECTION;

public class  CustomizeProjectViewController {
    @FXML private Label actualProjectName;
    @FXML private TextField projectName;
    @FXML private TextField projectDescription;
    @FXML private DatePicker endDate;
    @FXML private ChoiceBox choiceStatus;
    @FXML private Label errorLabel;
    private Status status;
    private ViewState state;
    private ViewHandler viewHandler;
    private ProjectModel model;
    private Region root;

    public CustomizeProjectViewController()
    {

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root,ViewState state)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.state = state;
        reset();
    }


    public void reset()
    {
        actualProjectName.setText(model.getProjectName(model.getProject(state.getSelectedProject())));

        projectName.setText(model.getProject(state.getSelectedProject()).getName());

        projectDescription.setText(model.getProject(state.getSelectedProject()).getDescription());

        LocalDate localDate = LocalDate.of(model.getProject(state.getSelectedProject()).getDeadLine().getYear(),
            model.getProject(state.getSelectedProject()).getDeadLine().getMonth(),
            model.getProject(state.getSelectedProject()).getDeadLine().getDay());
        endDate.setValue(localDate);

        choiceStatus.setValue(model.getProject(state.getSelectedProject()).getStatus());
        choiceStatus.getItems().add(STATUS_SELECTION[0]);
        choiceStatus.getItems().add(STATUS_SELECTION[1]);
        choiceStatus.getItems().add(STATUS_SELECTION[2]);

        errorLabel.setText("");
    }

    public Status getStatus(){
        return status;
    }
    public Region getRoot(){
        return root;
    }

    @FXML private void onChangeButton()
    {

        try {

            String actualstatus = (String)choiceStatus.getValue();
            switch(actualstatus)
            {
                case "Not started":
                     model.getProject(state.getSelectedProject()).setStatus(new Status(STATUS_SELECTION[0]));
                     break;
                case "Started":
                    model.getProject(state.getSelectedProject()).setStatus(new Status(STATUS_SELECTION[1]));
                    break;
                case "Ended":
                    model.getProject(state.getSelectedProject()).setStatus(new Status(STATUS_SELECTION[2]));
                    break;
            }
            TextField dateEditor = endDate.getEditor();
            String date = dateEditor.getText();
            String delims = "[/]";
            String[] tokens = date.split(delims);
            int month = Integer.parseInt(tokens[0]);
            int day = Integer.parseInt(tokens[1]);
            int year = Integer.parseInt(tokens[2]);
            DeadLine deadLine = new DeadLine(year, month, day);
                model.getProject(state.getSelectedProject()).setDeadLine(deadLine);
                model.getProject(state.getSelectedProject()).setDescription(projectDescription.getText());
                model.getProject(state.getSelectedProject()).setName(projectName.getText());
                viewHandler.openView("ProjectList");
        }
        catch(Exception e)
        {
            errorLabel.setText("Error: Fill all the boxes!");
            e.printStackTrace();
        }
    }

    @FXML private void onCancel()
    {
        viewHandler.openView("ProjectList");
    }
}
