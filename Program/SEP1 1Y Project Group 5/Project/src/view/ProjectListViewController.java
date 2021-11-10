package view;
/** EXPLAIN THE CLASS */

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.util.ArrayList;
import java.util.Optional;

public class ProjectListViewController {
    @FXML private TableView<ProjectViewModel> projectListTable;
    @FXML private TableColumn<ProjectViewModel, String> projectColumn;
    @FXML private TableColumn<ProjectViewModel, String> deadLineColumn;
    @FXML private TableColumn<ProjectViewModel, String> statusColumn;
    @FXML private TableColumn<ProjectViewModel, Number> membersColumn;
    @FXML private TableColumn<ProjectViewModel, Number> idColumn;
    @FXML private Label errorLabel;
    @FXML private TextField searchProject;
    private Region root;
    private ProjectListViewModel viewModel;
    private ProjectModel model;
    private ViewHandler viewHandler;
    private ViewState state;

    public ProjectListViewController() {

    }

    public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
    {
        this.model = model;
        this.viewHandler = viewHandler;
        this.root = root;
        this.viewModel = new ProjectListViewModel(model);
        this.state = state;
        this.projectColumn.setCellValueFactory((cellData) ->
            cellData.getValue().getNameProjectProperty());
        this.deadLineColumn.setCellValueFactory(cellData ->
             (ObjectProperty)cellData.getValue().getDeadLineProperty());
        this.statusColumn.setCellValueFactory(cellData ->
             cellData.getValue().getStatusProperty());
        this.idColumn.setCellValueFactory(cellData ->
            cellData.getValue().getProjectIDProperty());
        this.membersColumn.setCellValueFactory(cellData ->
            cellData.getValue().getMembersCountProperty());
        reset();
    }

    public void reset()
    {
        projectListTable.setItems(viewModel.getProjectList());
        errorLabel.setText("");
        viewModel.update();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void onSearchButton()
    {
        viewModel.searchProjects(Integer.valueOf(searchProject.getText()));
        projectListTable.setItems(viewModel.getSearchProjectsList());
        if(projectListTable.getItems().size() < 0)
        {
            reset();
            errorLabel.setText("There is no project with this ID.");
        }
    }

    @FXML private void onResetButton()
    {
        reset();
    }

    @FXML private void onAddProject()
    {
        viewHandler.openView("AddProject");
    }

    @FXML private void onRemoveProject()
    {
        errorLabel.setText("");
        try{
            int index = projectListTable.getSelectionModel().getSelectedIndex();
            boolean remove = confirmation(index);
            if(remove)
            {
                model.removeProject(index);
                viewModel.remove(index);
                projectListTable.getSelectionModel().clearSelection();
            }
        }
        catch(Exception e)
        {
            errorLabel.setText("Couldn't find the item: " + e.getMessage());
        }


    }

    private boolean confirmation(int index)
    {
        ProjectViewModel selectedItem = projectListTable.getItems().get(index);
        if(index > -1 && index < projectListTable.getItems().size())
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE PROJECT: Confirmation");
            String tostring = selectedItem.getNameProjectProperty().getValue();
            alert.setHeaderText("Remove " + tostring);
            Optional<ButtonType> result = alert.showAndWait();
            return result.isPresent() && result.get() == ButtonType.OK;
        }
        else return false;
    }

    @FXML private void onDetailsProject(){
        int index = projectListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < projectListTable.getItems().size())
        {
            state.setSelectedProject(index);
            viewHandler.openView("DetailsProject");
        }
        else errorLabel.setText("We couldn't find the project.");
    }

    @FXML private void onQuit()
    {
        state.setSelectedProject(-1);
        viewHandler.closeView();
    }

    @FXML private void onCustomizeProject()
    {
        int index = projectListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < projectListTable.getItems().size())
        {
            state.setSelectedProject(index);
            viewHandler.openView("CustomizeProject");
            state.setSelectedProject(projectListTable.getSelectionModel().getSelectedIndex());
        }
        else errorLabel.setText("No project selected.");
    }
}
