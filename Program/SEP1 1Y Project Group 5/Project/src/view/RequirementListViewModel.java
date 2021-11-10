package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Project;
import model.ProjectModel;
import model.Requirement;

public class RequirementListViewModel {
    private ObservableList<RequirementViewModel> requirementList;
    private ObservableList<RequirementViewModel> searchRequirementsList;
    private ProjectModel model;
    private ViewState state;

    public RequirementListViewModel(ProjectModel model,ViewState state){
        this.model = model;
        this.requirementList = FXCollections.observableArrayList();
        this.searchRequirementsList = FXCollections.observableArrayList();
        this.state = state;
        update();
    }

    public ObservableList<RequirementViewModel> getRequirementList(){
        return requirementList;
    }

    public ObservableList<RequirementViewModel> getSearchRequirementsList()
    {
        return searchRequirementsList;
    }

    public void update(){
        requirementList.clear();
        for(int i = 0; i < model.getRequirementListSize(state.getSelectedProject()) ; i++){
            requirementList.add(new RequirementViewModel(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),i)));
        }
    }

    public void searchRequirements(int id)
    {
        searchRequirementsList.clear();
        for(int i = 0; i < model.getProject(state.getSelectedProject()).getRequirementSize(); i++)
            if(id == model.getProject(state.getSelectedProject()).getRequirementByIndex(i).getId())
                searchRequirementsList.add(new RequirementViewModel(model.getProject(state.getSelectedProject()).getRequirementByIndex(i)));
    }

    public void addRequirement(Requirement requirement)
    {
        requirementList.add(new RequirementViewModel(requirement));
    }

    public void remove(int index) {
        for (int i = 0; i < requirementList.size(); i++) {
            if (i == index){
                requirementList.remove(i);
                break;
            }
        }
    }
}
