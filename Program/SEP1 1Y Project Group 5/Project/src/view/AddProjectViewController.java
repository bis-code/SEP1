package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

import javax.swing.*;
import java.time.LocalDate;

public class AddProjectViewController {
    @FXML private TextField projectName;
    @FXML private TextField projectDescription;
    @FXML private DatePicker projectDeadLine;
    @FXML private Label errorLabel;

    private Region root;
    private ProjectModel model;
    private ProjectListViewModel viewModel;
    private ViewHandler viewHandler;
    private ViewState state;

    public AddProjectViewController(){

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root,ViewState state){
        this.viewHandler = viewHandler;
        this.model = model;
        this.viewModel = new ProjectListViewModel(model);
        this.root = root;
        this.state = state;
        reset();
    }

    public void reset(){
        errorLabel.setText("");
        this.projectDeadLine.setShowWeekNumbers(true);
    }

    public Region getRoot(){
        return root;
    }

    @FXML private void onAddProject(){

        try {
            TextField dateEditor = projectDeadLine.getEditor();
            String date = dateEditor.getText();
            String delims = "[/]";
            String[] tokens = date.split(delims);
            int month = Integer.parseInt(tokens[0]);
            int day = Integer.parseInt(tokens[1]);
            int year = Integer.parseInt(tokens[2]);
            DeadLine deadLine = new DeadLine(year, month, day);
            StartDate startDate = new StartDate();
            startDate.setStartDate(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
            Project project = new Project(projectName.getText(),projectDescription.getText(),deadLine,startDate);
            model.addProject(project);
            viewModel.addProject(project);
            viewHandler.openView("ProjectList");
        }
        catch (Exception e){
            errorLabel.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML private void onCancel(){
        viewHandler.openView("ProjectList");
    }

}
