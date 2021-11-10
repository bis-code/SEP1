package model;

import java.util.ArrayList;
/**
 * Class that represents project model manager.
 */
public class ProjectModelManager implements ProjectModel{

    private ProjectList projectList;
    /**
     * Project model manager constructor.
     */
    public ProjectModelManager()
    {
        this.projectList = new ProjectList();
    }
    /**
     * Method that removes project.
     * @param index index.
     */
    @Override
    public void removeProject(int index) {
        projectList.removeProject(index);
    }
    /**
     * Getter for project array list size.
     * @return size of the project array list.
     */
    @Override
    public int projectListSize()
    {
        return projectList.getSize();
    }
    /**
     * Getter for project
     * @param index index of project.
     * @return projetc.
     */
    @Override
    public Project getProject(int index)
    {
        return projectList.getProject(index);
    }
    /**
     * Getter for all projects.
     * @return Array list of projects.
     */
    @Override public ProjectList getAllProjects()
    {
        return null;
    }
    /**
     * Getter for requirement by index.
     * @param project project.
     * @param index index of requirement.
     * @return requirement.
     */
    @Override
    public Requirement getRequirementByIndex(Project project,int index)
    {
        return project.getRequirementByIndex(index);
    }

    /**
     * A method that adds responsible member(RPM).
     * @param requirement requirement.
     * @param member responsible team member.
     */
    @Override
    public void addRPMinRequirement(Requirement requirement, Member member)
    {
        requirement.setResponsibleTeamMember(member);
    }
    /**
     * Getter for project name.
     * @param project project.
     * @return name of project.
     */
    @Override
    public String getProjectName(Project project)
    {
        return project.getName();
    }
    /**
     * Setter for requirement description.
     * @param requirement requirement.
     * @param description description of requirement.
     * @param project project that has this requirement.
     */
    @Override
    public void setRequirementDescription(Requirement requirement, String description, Project project) {
        project.setRequirementDescription(requirement,description);
    }
    /**
     * Setter for requirement name.
     * @param requirement requirement.
     * @param name requirement name that is going to be set.
     * @param project project that has this requirement.
     */
    @Override
    public void setRequirementName(Requirement requirement, String name, Project project) {
        project.setRequirementName(requirement,name);
    }
    /**
     * A method that adds a project.
     * @param project project.
     */
    @Override
    public void addProject(Project project) {
        projectList.addProject(project);

    }
    /**
     * Setter for member role.
     * @param task task that member belongs to.
     * @param member member.
     * @param index index of member.
     */
    @Override
    public void setRole(Task task, Member member, int index)
    {
        task.setMember(index,member);
    }
    /**
     * A method that adds member.
     * @param project project.
     * @param member member.
     */
    @Override
    public void addMember(Project project, Member member) {
        project.addTeamMember(member);
    }
    /**
     * Getter for requirement by ID.
     * @param id id of requirement.
     * @param project project.
     * @return
     */
    @Override
    public Requirement getRequirementById(int id, Project project) {
        return project.getRequirementByID(id);
    }
    /**
     * Getter for requirement ID.
     * @param requirement requirement.
     * @return ID of requirement.
     */
    @Override
    public int getRequirementId(Requirement requirement) {
        return requirement.getId();
    }
    /**
     * A method that removes requirement.
     * @param index index of requirement.
     * @param project project.
     */
    @Override
    public void removeRequirement(int index, Project project) {
        project.removeRequirement(index);
    }
    /**
     * Getter for task.
     * @param requirement requirement.
     * @param index index of task.
     * @return
     */
    @Override
    public Task getTask(Requirement requirement,int index) {
        return requirement.getTaskByIndex(index);
    }
    /**
     * A method that removes a task.
     * @param index index of task.
     * @param requirement requirement.
     */
    @Override
    public void removeTask(int index, Requirement requirement) {
        requirement.removeTask(index);
    }
    /**
     * A method that adds a requirement.
     * @param requirement requirement.
     * @param project project.
     */
    @Override
    public void addRequirement(Requirement requirement, Project project) {
        project.addRequirement(requirement);
    }
    /**
     * A method that adds a task.
     * @param task task.
     * @param requirement requirement that task will be added to.
     */
    @Override
    public void addTask(Task task, Requirement requirement) {
        requirement.addTask(task);
        System.out.println(task.getDescription());
    }
    /**
     * A setter for task.
     * @param task task is going to be set.
     * @param index index of that task.
     * @param requirement requirement.
     */
    @Override
    public void setTask(Task task, int index, Requirement requirement) {
        requirement.setTask(task, index);
    }
    /**
     * Getter for requirement description.
     * @param requirement requirement.
     * @return description of requirement.
     */
    @Override
    public String getRequirementDescription(Requirement requirement) {
        return requirement.getDescription();
    }
    /**
     * Getter for task description.
     * @param task task.
     * @return description of task.
     */
    public String getTaskDescription(Task task)
    {
        return task.getDescription();
    }
    /**
     * Getter for task array list size.
     * @param requirement requirement.
     * @return size of task array list.
     */
    @Override
    public int taskListSize(Requirement requirement)
    {
        return requirement.sizeTask();
    }
    /**
     * Getter for requirement array list size.
     * @param index index of requirement.
     * @return size of requirement array list.
     */
    @Override
    public int getRequirementListSize(int index){
        return projectList.getProject(index).getRequirementSize();
    }
}
