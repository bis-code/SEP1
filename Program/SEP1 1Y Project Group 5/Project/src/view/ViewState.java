package view;

public class ViewState {
    private int selectedProject;
    private int selectedRequirement;
    private int selectedTask;
    private int selectedMembers;

    public ViewState(){
        this.selectedProject=-1;
        this.selectedRequirement = -1;
        this.selectedTask = -1;
        this.selectedMembers = -1;
    }

    public int getSelectedProject(){
        return selectedProject;
    }

    public int getSelectedRequirement(){
        return selectedProject;
    }

    public int getSelectedTask(){
        return selectedProject;
    }

    public void setSelectedProject(int id){
        this.selectedProject = id;
    }

    public void setSelectedRequirement(int id){
        this.selectedRequirement = id;
    }

    public void setSelectedTask(int id){
        this.selectedTask = id;
    }
    public int getSelectedMembers() {
        return selectedMembers;
    }
    public void setSelectedMembers(int id) {
        this.selectedMembers = id;
    }
}
