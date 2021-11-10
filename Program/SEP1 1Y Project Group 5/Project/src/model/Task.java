package model;

import model.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that represents task.
 */
public class Task implements Serializable
{
  private String taskName;
  private String description;
  private Status status;
  private ArrayList<Member> members;
  private DeadLine deadLine;
  private Time timeSpent;

  /**
   * Constructor for task.
   * @param taskName name of task.
   * @param description description of the task.
   * @param deadLine deadline of task.
   */
  public Task(String taskName, String description, DeadLine deadLine)
  {
    this.taskName = taskName;
    this.description = description;
    this.members = new ArrayList<>();
    this.deadLine = deadLine;
    this.status = new Status("Not assigned");
    this.timeSpent = new Time(0,0);
  }

  /**
   * Constructor with additional variables: status, time spent.
   * @param taskName name of the task.
   * @param description description of task.
   * @param deadLine deadline of task.
   * @param status status of task.
   * @param timeSpent time spent on a task.
   */
  public Task(String taskName, String description, DeadLine deadLine, Status status, Time timeSpent)
  {
    this.taskName = taskName;
    this.description = description;
    this.members = new ArrayList<>();
    this.deadLine = deadLine;
    this.status = status;
    this.timeSpent = timeSpent;
  }

  /**
   * Setter for the task name.
   * @param taskName name of the task.
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  /**
   * Setter for deadline of the task.
   * @param deadLine deadline of task.
   */
  public void setDeadLine(DeadLine deadLine) {
    this.deadLine = deadLine;
  }

  /**
   * Setter for task member.
   * @param index index of member.
   * @param member member.
   */
  public void setMember(int index, Member member)
  {
    members.add(index,member);
  }

  /**
   * Getter for task name.
   * @return name of task.
   */
  public String getTaskName()
  {
    return taskName;
  }

  /**
   * Getter for task descriptipn.
   * @return description of task.
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Getter for task status.
   * @return status of a task.
   */
  public Status getStatus()
  {
    return status;
  }

  /**
   * Getter for time spent on a task.
   * @return time spent on a task.
   */
  public Time getTimeSpent()
  {
    return timeSpent;
  }

  /**
   * Getter for task members.
   * @return array list of task members.
   */
  public ArrayList<Member> getTaskMembers()
  {
    return members;
  }

  /**
   * Getter for task deadline.
   * @return task deadline.
   */
  public DeadLine getDeadLine()
  {
    return deadLine;
  }

  /**
   * Setter for task status.
   * @param status task status.
   */
  public void setStatus(Status status)
  {
    this.status = status;
  }

  /**
   * Setter for task description.
   * @param description description of a task.
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * Setter for time spent on a task.
   * @param timeSpent1 time spent on a task.
   */
  public void setTimeSpent(Time timeSpent1)
  {
    this.timeSpent.addTime(timeSpent1);
  }

  /**
   * A method that compares two objects.
   * @param obj object compared with task class object.
   * @return true if objects are identical, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Task))
      return false;
    Task other = (Task)obj;
    return taskName.equals(other.taskName) && description.equals(other.description) &&
        status.equals(other.status) && members.equals(other.members) && deadLine.equals(other.deadLine) &&
        timeSpent.equals(other.timeSpent);
  }

  /**
   * To string method.
   * @return string of instance variables of task class.
   */
  @Override public String toString()
  {
    return "Task{" + "taskName='" + taskName + '\'' + ", description='"
        + description + '\'' + ", status=" + status + ", members=" + members
        + ", deadLine=" + deadLine + ", time=" + timeSpent + '}';
  }
}
