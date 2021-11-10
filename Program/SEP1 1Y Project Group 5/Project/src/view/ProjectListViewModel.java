package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class ProjectListViewModel {
    private ObservableList<ProjectViewModel> projectList;
    private ObservableList<ProjectViewModel> searchProjectsList;
    private ProjectModel model;

    public ProjectListViewModel(ProjectModel model)
    {
        this.model = model;
        this.projectList = FXCollections.observableArrayList();
        this.searchProjectsList = FXCollections.observableArrayList();
        update();
    }

    public ObservableList<ProjectViewModel> getProjectList()
    {
        return projectList;
    }

    public ObservableList<ProjectViewModel> getSearchProjectsList()
    {
        return searchProjectsList;
    }

    public void update()
    {
        projectList.clear();
        for(int i = 0; i < model.projectListSize(); i++)
        {
            projectList.add(new ProjectViewModel(model.getProject(i)));
        }
    }

    public void searchProjects(int id)
    {
         searchProjectsList.clear();
         for(int i = 0; i < model.projectListSize(); i++)
             if(id == model.getProject(i).getProjectId())
                 searchProjectsList.add(new ProjectViewModel(model.getProject(i)));
    }

    public void addProject(Project project)
    {
        projectList.add(new ProjectViewModel(project));
    }

    public void remove(int index ) {
        for(int i = 0; i < projectList.size(); i++)
            if(i == index)
                projectList.remove(i);
            }
        }

