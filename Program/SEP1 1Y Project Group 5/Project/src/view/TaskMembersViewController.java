package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ProjectModel;

import java.util.Optional;

public class TaskMembersViewController {

    @FXML private TableView<TaskMemberViewModel> memberListTable;
    @FXML private TableColumn<TaskMemberViewModel, String> nameColumn;
    @FXML private TableColumn<TaskMemberViewModel, String> roleColumn;
    @FXML private Label errorLabel;
    @FXML private Label nameTask;
    @FXML private TextField searchName;
    private ViewState state;
    private TaskMembersViewListModel viewModel;
    private ViewHandler viewHandler;
    private ProjectModel model;
    private Region root;

    public TaskMembersViewController()
    {

    }

    public void init(ViewHandler viewHandler,ProjectModel model,Region root,ViewState state)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.state = state;
        this.viewModel = new TaskMembersViewListModel(model,state);

        this.nameColumn.setCellValueFactory(cellData ->
                cellData.getValue().getNameProperty());
        this.roleColumn.setCellValueFactory(cellData ->
                cellData.getValue().getRoleProperty());
        reset();
    }

    public Region getRoot() {
        return root;
    }

    public void reset(){
        memberListTable.setItems(viewModel.getMembersList());
        errorLabel.setText("");
        nameTask.setText(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                state.getSelectedTask()).getTaskName());
        searchName.setText("");
        viewModel.update();
    }

    @FXML private void onSearchButton() {
        viewModel.searchMembers(searchName.getText());
        memberListTable.setItems(viewModel.getMembersSearchedList());
        if (memberListTable.getItems().size() < 0) {
            reset();
            errorLabel.setText("There is no member with this name");
        }
    }

    @FXML private void onResetButton()
    {
        reset();
    }

    @FXML private void onAddButton()
    {
        viewHandler.openView("AddMembersToTask");
    }

    @FXML private void onCustomizeButton()
    {
        int index = memberListTable.getSelectionModel().getSelectedIndex();
        if(index > -1 && index < memberListTable.getItems().size())
        {
            state.setSelectedMembers(index);
            viewHandler.openView("CustomizeMemberTask");
        }
    }

    @FXML private void onBack()
    {
        state.setSelectedTask(-1);
        viewHandler.openView("DetailsRequirement");
    }

    @FXML private void onRemoveButton() {
        errorLabel.setText("");
        try {
            int index = memberListTable.getSelectionModel().getSelectedIndex();
            boolean remove = confirmation(index);
            if (remove) {
                model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement()),
                        state.getSelectedTask()).getTaskMembers().remove(index);
                viewModel.remove(index);
                model.getProject(state.getSelectedProject()).removeTeamMember(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                        state.getSelectedRequirement()),state.getSelectedTask()).getTaskMembers().get(index));
                memberListTable.getSelectionModel().clearSelection();
            }
        } catch (Exception e) {
            errorLabel.setText("Couldn't find the member: " + e.getMessage());
        }

    }
        private boolean confirmation(int index)
    {
        TaskMemberViewModel selectedItem = memberListTable.getItems().get(index);
        if(index > -1 && index < memberListTable.getItems().size())
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE PROJECT: Confirmation");
            String tostring = selectedItem.getNameProperty().get();
            alert.setHeaderText("Remove " + tostring + " member");
            Optional<ButtonType> result = alert.showAndWait();
            return result.isPresent() && result.get() == ButtonType.OK;
        }
        else return false;
    }
}
