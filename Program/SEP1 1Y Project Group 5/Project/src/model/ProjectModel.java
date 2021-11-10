package model;

/**
 * A class that represent Project model (interface).
 */
public interface ProjectModel
{
    ///////////////////////////////////////////////////////////// ProjectListView
    /**
     * A method that removes project by it's index.
     * @param index index.
     */
    public void removeProject(int index);
    /**
     * Getter for project array list size.
     * @return size of projects array list.
     */
    public int projectListSize();
    /**
     * Getter for project by index.
     * @param index index of project.
     * @return project.
     */
    public Project getProject(int index);
    /**
     * Getter for all projects.
     * @return An array list of all projects.
     */
    public ProjectList getAllProjects();


    ////////////////////////////////////////////////////////////// addProjectView
    /**
     * A method that adds a project.
     * @param project project.
     */
    public void addProject(Project project);
    /**
     * A method that adds member to a project.
     * @param project project.
     * @param member member.
     */
    public void addMember(Project project, Member member);

    ////////////////////////////////////////////////////////////// DetailsProjectView
    /**
     * Getter for requirement by it's ID.
     * @param id id of requirement.
     * @param project project.
     * @return Requirement.
     */
    public Requirement getRequirementById(int id, Project project);
    /**
     * Getter for requirement by it's index.
     * @param project project.
     * @param index index of requirement.
     * @return requirement.
     */
    public Requirement getRequirementByIndex(Project project,int index);
    /**
     * Getter for requirement ID.
     * @param requirement requirement.
     * @return ID of requirement.
     */
    public int getRequirementId(Requirement requirement);
    /**
     * A method that removes requirement.
     * @param index index of requirement.
     * @param project project.
     */
    public void removeRequirement(int index, Project project);

    ////////////////////////////////////////////////////////////// DetailsRequirementView
    /**
     * method to remove task.
     * @param index index of task.
     * @param requirement requirement.
     */
    public void removeTask(int index, Requirement requirement);
    /**
     * Getter for task.
     * @param requirement requirement.
     * @param index index of task.
     * @return task.
     */
    public Task getTask(Requirement requirement,int index);

    ////////////////////////////////////////////////////////////// AddRequirementView
    /**
     * A method that adds requirement.
     * @param requirement requirement.
     * @param project project.
     */
    public void addRequirement(Requirement requirement, Project project);

    ////////////////////////////////////////////////////////////// AddTaskView
    /**
     * A method that adds task to a requirement.
     * @param task task.
     * @param requirement requirement that task will be added to.
     */
    public void addTask(Task task, Requirement requirement);
    /**
     * Getter for task list size.
     * @param requirement requirement.
     * @return size of task list.
     */
    public int taskListSize(Requirement requirement);

    ////////////////////////////////////////////////////////////// AddResponsibleTeamMember
    /**
     * A method that adds responsible member to a requirement. Only requirements have responsible members (RPM).
     * @param requirement requirement.
     * @param member responsible team member.
     */
    public void addRPMinRequirement(Requirement requirement, Member member);

    ////////////////////////////////////////////////////////////// CustomizeProjectView
    /**
     * Getter for requirement list size.
     * @param index index of requirement list.
     * @return size of requirement list size.
     */
    public int getRequirementListSize(int index);
    ////////////////////////////////////////////////////////////// CustomizeTaskMemberView
    /**
     * Setter for member role.
     * @param task task that member belongs to.
     * @param member member.
     * @param index index of member.
     */
    public void setRole(Task task, Member member, int index);
    ////////////////////////////////////////////////////////////// CustomizeRequirementsView
    /**
     * Getter for project Name.
     * @param project project.
     * @return project name.
     */
    public String getProjectName(Project project);
    /**
     * Setter for requirement description.
     * @param requirement requirement.
     * @param description description of requirement.
     * @param project project that has this requirement.
     */
    public void setRequirementDescription(Requirement requirement, String description, Project project);
    /**
     * Setter for requirement name.
     * @param requirement requirement.
     * @param name requirement name that is going to be set.
     * @param project project that has this requirement.
     */
    public void setRequirementName(Requirement requirement, String name, Project project);

    ////////////////////////////////////////////////////////////// CustomizeTaskView
    /**
     * Setter for task.
     * @param task task is going to be set.
     * @param index index of that task.
     * @param requirement requirement.
     */
    public void setTask(Task task, int index, Requirement requirement);

    ////////////////////////////////////////////////////////////// RequirementDescriptionView
    /**
     * Getter for requirement description.
     * @param requirement requirement.
     * @return requirement description.
     */
    public String getRequirementDescription(Requirement requirement);


    ////////////////////////////////////////////////////////////// TaskDescriptionView
    /**
     * Getter for task description.
     * @param task task.
     * @return task description.
     */
    public String getTaskDescription(Task task);

}
