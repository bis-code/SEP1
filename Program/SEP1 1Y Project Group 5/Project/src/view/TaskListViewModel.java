package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
public class TaskListViewModel {
    private ObservableList<TaskViewModel> taskList;
    private ProjectModel model;
    private ViewState state;
    public TaskListViewModel(ProjectModel model, ViewState state)
    {
        this.model = model;
        this.taskList = FXCollections.observableArrayList();
        this.state = state;
        update();
    }
    public ObservableList<TaskViewModel> getList() {
        return taskList;
    }
    public void update(){
        taskList.clear();
        for(int i = 0; i < model.taskListSize(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),state.getSelectedRequirement())); i++){
            taskList.add(new TaskViewModel(model.getTask(model.getRequirementByIndex(model.getProject(state.getSelectedProject()),
                state.getSelectedRequirement()),i)));
        }
    }

    public void addTask(Task task)
    {
        taskList.add(new TaskViewModel(task));
    }

    public void remove(int index) {
        for(int i = 0; i < taskList.size(); i++)
            if(i == index)
                taskList.remove(i);
        }
    }
