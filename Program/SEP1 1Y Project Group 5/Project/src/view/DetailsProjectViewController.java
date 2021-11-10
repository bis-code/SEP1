package view;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.util.Optional;

public class DetailsProjectViewController {
    @FXML private TableView<RequirementViewModel> requirementListTable;
    @FXML private TableColumn<RequirementViewModel, String> requirementColumn;
    @FXML private TableColumn<RequirementViewModel, String> statusColumn;
    @FXML private TableColumn<RequirementViewModel, String> timeSpentColumn;
    @FXML private TableColumn<RequirementViewModel, Number> idColumn;
    @FXML private TableColumn<RequirementViewModel, String> unfinishedNumberOfTaskColumn;
    @FXML private TableColumn<RequirementViewModel, String> responsibleTeamMember;
    @FXML private TableColumn<RequirementViewModel, Time> estimatedTime;
    @FXML private Label errorLabel;
    @FXML private TextField searchRequirement;
    @FXML private Label projectName;

    private Region root;
    private RequirementListViewModel viewModel;
    private ProjectModel model;
    private ViewHandler viewHandler;
    private ViewState state;

    public DetailsProjectViewController()
    {

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
    {
        this.model = model;
        this.viewHandler = viewHandler;
        this.root = root;
        this.viewModel = new RequirementListViewModel(model,state);
        this.state = state;
        this.requirementColumn.setCellValueFactory(cellData ->
            cellData.getValue().getRequirementNameProperty());
        this.statusColumn.setCellValueFactory(cellData ->
            cellData.getValue().getStatusStringProperty());
        this.idColumn.setCellValueFactory(cellData ->
            cellData.getValue().getIdProperty());
        this.estimatedTime.setCellValueFactory(cellData ->
            cellData.getValue().getEstimatedTimeProperty());
        this.timeSpentColumn.setCellValueFactory(cellData ->
            cellData.getValue().getTimeSpentProperty());
        this.unfinishedNumberOfTaskColumn.setCellValueFactory(cellData ->
            cellData.getValue().getGetNumberOfUnfinishedTasksProperty());
        this.responsibleTeamMember.setCellValueFactory(cellData -> cellData
            .getValue().getTeamMemberProperty());
        reset();
    }

    public void reset()
    {
        requirementListTable.setItems(viewModel.getRequirementList());
        errorLabel.setText("");
        searchRequirement.setText("");
        projectName.setText(model.getProject(state.getSelectedProject()).getName());
        viewModel.update();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void onSearchButton()
    {
        viewModel.searchRequirements(Integer.valueOf(searchRequirement.getText()));
        requirementListTable.setItems(viewModel.getSearchRequirementsList());
        if(requirementListTable.getItems().size() < 0)
        {
            reset();
            errorLabel.setText("There is no project with this ID.");
        }
    }

    @FXML private void onResetButton()
    {
        reset();
    }

    @FXML private void onAddRequirement()
    {
        viewHandler.openView("AddRequirement");
    }

    @FXML private void onRemoveRequirement()
    {
        errorLabel.setText("");
        try{

            int index = requirementListTable.getSelectionModel().getSelectedIndex();
            boolean remove = confirmation(index);
            if(remove){
                model.removeRequirement(index,model.getProject(state.getSelectedProject()));
                viewModel.remove(index);
                requirementListTable.getSelectionModel().clearSelection();
            }

        }
        catch(Exception e)
        {
            errorLabel.setText("Couldn't find the item: " + e.getMessage());
        }

    }

    private boolean confirmation(int index)
    {
        RequirementViewModel selectedItem = requirementListTable.getItems().get(index);
        if(index > -1 && index < requirementListTable.getItems().size())
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE REQUIREMENT: Confirmation");
            String tostring = selectedItem.getRequirementNameProperty().getValue();
            alert.setHeaderText("Remove " + tostring);
            Optional<ButtonType> result = alert.showAndWait();
            return result.isPresent() && result.get() == ButtonType.OK;
        }
        else return false;
    }

    @FXML private void onDetailsRequirement(){
        int index = requirementListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < requirementListTable.getItems().size())
        {
            state.setSelectedRequirement(requirementListTable.getSelectionModel().getSelectedIndex());
            viewHandler.openView("DetailsRequirement");
        }
        else errorLabel.setText("Please select a requirement first.");
    }

    @FXML private void onCustomizeTask()
    {
        int index = requirementListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < requirementListTable.getItems().size())
        {
            state.setSelectedRequirement(index);
            viewHandler.openView("CustomizeRequirements");
        }
        else errorLabel.setText("Please select a requirement first.");
    }

    @FXML private void onBackButton()
    {
        viewHandler.openView("ProjectList");
    }

    @FXML private void onAddResponsibleMember()
    {
        int index = requirementListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < requirementListTable.getItems().size())
        {
            state.setSelectedRequirement(index);
            viewHandler.openView("AddResponsibleTM");
        }
        else errorLabel.setText("Please select a requirement first.");
    }

    @FXML private void onDescriptionRequirement()
    {
        int index = requirementListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < requirementListTable.getItems().size())
        {
            state.setSelectedRequirement(index);
            viewHandler.openView("RequirementDescription");
        }
        else errorLabel.setText("Please select a requirement first.");
    }

}
