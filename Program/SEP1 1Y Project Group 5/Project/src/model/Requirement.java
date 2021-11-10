package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import model.*;

/**
 * A class that represent requirement.
 */
public class Requirement implements Serializable
{
  private String requirementName;
  private String description;
  private Status status;
  private int id;
  private Member teamMember;
  private Time estimatedTime;
  private ArrayList<Task> tasks;

  /**
   * A constructor for requirement.
   * @param requirementName name of requirement.
   * @param description description of requirement.
   * @param estimatedTime estimated requirement time.
   */
  public Requirement(String requirementName, String description, Time estimatedTime)
  {
    this.estimatedTime = estimatedTime;
    this.requirementName = requirementName;
    this.description = description;
    this.status = new Status("Not started");
    this.teamMember = null;
    Random random = new Random();
    this.id = random.nextInt(9999);
    this.tasks = new ArrayList<>();
  }

  /**
   * A constructor for requirement with additional ID, status and team member.
   * @param requirementName name of requirement.
   * @param description description of requirement.
   * @param id ID of requirement.
   * @param estimatedTime estimated requirement time.
   * @param status requirement status.
   * @param teamMember a team member of requirement.
   */
  public Requirement(String requirementName, String description, int id, Time estimatedTime, Status status, Member teamMember)
  {
    this.estimatedTime = estimatedTime;
    this.requirementName = requirementName;
    this.description = description;
    this.status = status;
    this.teamMember = teamMember;
    this.id = id;
    this.tasks = new ArrayList<>();
  }

  /**
   * Getter for requirement name.
   * @return name of requirement.
   */
  public String getRequirementName()
  {
    return requirementName;
  }

  /**
   * Getter for requirement description.
   * @return description of requirement.
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Getter for requirement status.
   * @return status of requirement.
   */
  public Status getStatus()
  {
    return status;
  }

  /**
   * Method that returns time spent on tasks.
   * @return time spent on tasks.
   */
  public Time getTimeSpentOnTasks()
  {
    int timeSpent = 0;
    for(Task a: tasks)
    {
      timeSpent += a.getTimeSpent().getTimeInMinutes();
    }
    Time timeSpentOnTasks = new Time(timeSpent);
    return timeSpentOnTasks;
  }

  /**
   * Setter for estimated time.
   * @param estimatedTime estimated requirement time.
   */
  public void setEstimatedTime(Time estimatedTime)
  {
    this.estimatedTime = estimatedTime;
  }

  /**
   * Getter for member.
   * @return team member.
   */
  public Member getMember()
  {
    return teamMember;
  }

  /**
   * Getter for team member.
   * @return if member is not assigned "Not assigned" is returned, otherwise team member's name is returned.
   */
  public String getTeamMember()
  {
    if(teamMember == null)
      return "Not assigned.";
    else return teamMember.getName();
  }

  /**
   * Getter for estimated time.
   * @return estimated time.
   */
  public Time getEstimatedTime()
  {
    return estimatedTime;
  }

  /**
   * Setter for requirement name.
   * @param name name of requirement.
   */
  public void setRequirementName(String name)
  {
    this.requirementName = name;
  }

  /**
   * Setter for requirement description.
   * @param description description of requirement.
   */
  public void setRequirementDescription(String description)
  {
    this.description = description;
  }

  /**
   * Setter for responsible team member.
   * @param member responsible team member.
   */
  public void setResponsibleTeamMember(Member member)
  {
    this.teamMember = member;
  }

  /**
   * Setter for requirement status.
   * @param status status of requirement.
   */
  public void setStatus(Status status)
  {
    this.status = status;
  }

  /**
   * Getter for requirement ID.
   * @return requirement ID.
   */
  public int getId()
  {
    return id;
  }

  /**
   * Setter for task.
   * @param task task.
   * @param index index of a task.
   */
  public void setTask(Task task, int index)
  {
    tasks.add(index, task);
  }

  /**
   * Getter for task array list size.
   * @return size of task array list.
   */
  public int sizeTask()
  {
    return tasks.size();
  }

  /**
   * Getter for task array list.
   * @return array list of tasks.
   */
  public ArrayList<Task> getTasks()
  {
    return tasks;
  }

  /**
   * A method that adds a task.
   * @param task task.
   */
  public void addTask(Task task)
  {
    tasks.add(task);
  }

  /**
   * A method that removes a task.
   * @param index index of a task that is going to be removed.
   */
  public void removeTask(int index){
    for(int i = 0; i < tasks.size(); i++)
      if(i == index)
        tasks.remove(tasks.get(index));
  }

  /**
   * A method that removes a task by it's name.
   * @param taskName name of the task.
   */
  public void removeTaskByName(String taskName)
  {
    for(Task a: tasks)
    {
      if(a.getTaskName().equals(taskName))
      {
        tasks.remove(a);
      }
    }
  }

  /**
   * Getter for task by index.
   * @param index index of a task.
   * @return task.
   */
  public Task getTaskByIndex(int index)
  {
    return tasks.get(index);
  }

  /**
   * Getter for number of unfinished tasks.
   * @return number of unfinished tasks.
   */
  public String getNumberOfUnfinishedTasks()
  {
    String all = "";
    int count = 0;
    for(int i = 0; i < tasks.size(); i++)
      if(!(tasks.get(i).getStatus().equals("Ended")))
        count++;
    return count + " / " + tasks.size();
  }

  /**
   * A method that compares two objects.
   * @param obj object that compared with instance of requirement class and it's instance variables.
   * @return true if objects are identical, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Requirement))
      return false;
    Requirement other = (Requirement)obj;
    return requirementName.equals(other.requirementName) && description.equals(other.description) &&
        status.equals(other.status) && id == other.id && tasks.equals(other.tasks);
  }

  /**
   * To string method.
   * @return string of instance variables of this class.
   */
  @Override public String toString()
  {
    return "Requirement{" + "requirementName='" + requirementName + '\''
        + ", description='" + description + '\'' + ", status='" + status + '\''
        + ", id=" + id + ", tasks=" + tasks + '}';
  }

  /**
   * A setter for requirement ID.
   */
  public void setId()
  {
    Random random = new Random();
    this.id = random.nextInt(9999);
  }
}
