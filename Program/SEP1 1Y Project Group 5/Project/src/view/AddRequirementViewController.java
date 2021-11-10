package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

public class AddRequirementViewController {
    @FXML private TextField requirementName;
    @FXML private TextField requirementDescription;
    @FXML private TextField estimatedTime;
    @FXML private Label errorLabel;

    private Region root;
    private ProjectModel model;
    private ViewHandler viewHandler;
    private RequirementListViewModel viewModel;
    private ViewState state;

    public AddRequirementViewController(){

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root,ViewState state){
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.state = state;
        this.viewModel = new RequirementListViewModel(model,state);
        reset();
    }

    public void reset(){
        this.errorLabel.setText("");
        this.requirementName.setText("");
        this.requirementDescription.setText("");
        this.estimatedTime.setText("");
    }

    public Region getRoot(){
        return root;
    }

    @FXML private void onAddRequirement(){
        errorLabel.setText("");
        try {
            Time estimateddTime = new Time(Integer.valueOf(estimatedTime.getText()),0);
            Requirement requirement = new Requirement(requirementName.getText(),requirementDescription.getText(),estimateddTime);
            model.addRequirement(requirement,model.getProject(state.getSelectedProject()));
            viewModel.addRequirement(requirement);
            viewHandler.openView("DetailsProject");
        }
        catch (Exception e){
            errorLabel.setText("Error: " + e.getMessage());
        }

    }
    @FXML private void onCancel(){
        viewHandler.openView("DetailsProject");
    }
}
