package model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class representing the project.
 */
public class Project implements Serializable
{
  private String name;
  private String description;
  private int projectId;
  private Status status;
  private ArrayList<Requirement> requirements;
  private StartDate startDate;
  private DeadLine deadLine;
  private ArrayList<Member> members;

  /**
   * A constructor for project.
   *
   * @param name        the name of the project.
   * @param description the description of the project.
   * @param deadLine    deadline of the project.
   * @param startDate   start date of the project.
   */
  public Project(String name, String description, DeadLine deadLine, StartDate startDate)
  {
    Random random = new Random();
    this.name = name;
    this.description = description;
    this.deadLine = deadLine;
    this.startDate = startDate;
    this.projectId = random.nextInt(9999);
    this.requirements = new ArrayList<>();
    this.members = new ArrayList<>();
    this.status = new Status("Not started");

  }

  /**
   * Constructor for project without dates and with project id.
   *
   * @param name        name of project.
   * @param description description of project.
   * @param projectId   id of project.
   */
  public Project(String name, String description, int projectId)
  {
    this.name = name;
    this.description = description;
    this.projectId = projectId;
    this.requirements = new ArrayList<>();
    this.members = new ArrayList<>();
    this.status = new Status("Not started");
    this.deadLine = null;
    this.startDate = null;
  }

  /**
   * Constructor for project with id and dates.
   *
   * @param name        name of project.
   * @param description description of project.
   * @param projectId   id of project.
   * @param deadLine    deadline of project.
   * @param startDate   start date of project.
   */
  public Project(String name, String description, int projectId, DeadLine deadLine, StartDate startDate)
  {
    this.name = name;
    this.description = description;
    this.projectId = projectId;
    this.deadLine = deadLine;
    this.startDate = startDate;
    this.requirements = new ArrayList<>();
    this.members = new ArrayList<>();
    this.status = new Status("Not started");
  }

  /**
   * Getter for project description.
   *
   * @return project description.
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Getter for project status.
   *
   * @return project status.
   */
  public Status getStatus()
  {
    return status;
  }

  /**
   * Getter for project ID.
   *
   * @return project ID.
   */
  public int getProjectId()
  {
    return projectId;
  }

  /**
   * Getter for project start date.
   *
   * @return start date of project.
   */
  public StartDate getStartDate()
  {
    return startDate;
  }

  /**
   * Getter for project deadline.
   *
   * @return deadline of project.
   */
  public DeadLine getDeadLine()
  {
    return deadLine;
  }

  /**
   * Getter for name of project.
   *
   * @return name of project.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Getter for project status.
   *
   * @param status status of project.
   */
  public void setStatus(Status status)
  {
    this.status = status;
  }

  /**
   * Setter for project name.
   *
   * @param name name of project.
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Setter for description.
   *
   * @param description description of project.
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * Getter for requirement by ID.
   *
   * @param id ID of requirement.
   * @return requirement of this ID.
   */
  public Requirement getRequirementByID(int id)
  {
    for (int i = 0; i < requirements.size(); i++)
      if (requirements.get(i).getId() == id)
        return requirements.get(i);
    return null;
  }

  /**
   * Setter for project deadline.
   *
   * @param deadLine deadline of project.
   */
  public void setDeadLine(DeadLine deadLine)
  {
    this.deadLine = deadLine;
  }

  public ArrayList<Member> getAllMembers()
  {
    return members;
  }

  /**
   * A method that returns an arraylist of all requirements that a project has.
   *
   * @return arraylist of requirements.
   */
  public ArrayList<Requirement> getAllRequirements()
  {
    return requirements;
  }

  public Requirement getRequirementByIndex(int index)
  {
    return requirements.get(index);
  }

  /**
   * Setter for requirement.
   *
   * @param requirement requirement.
   * @param index       index of that requirement in arraylist.
   */
  public void setRequirement(Requirement requirement, int index)
  {
    requirements.add(index, requirement);
  }

  /**
   * Setter for requirement name.
   *
   * @param requirement requirement.
   * @param name        name that u want to set.
   */
  public void setRequirementName(Requirement requirement, String name)
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).equals(requirement))
      {
        requirements.get(i).setRequirementName(name);
      }
    }
  }

  /**
   * Setter for requirement description.
   *
   * @param requirement requirement.
   * @param description description that u want to set.
   */
  public void setRequirementDescription(Requirement requirement, String description)
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).equals(requirement))
      {
        requirements.get(i).setRequirementDescription(description);
      }
    }
  }

  /**
   * Setter fro requirements.
   *
   * @param requirementsList requirement arraylist.
   */
  public void setRequirements(ArrayList<Requirement> requirementsList)
  {
    this.requirements = requirementsList;
  }

  /**
   * A method to add requirement.
   *
   * @param requirement requirement.
   */
  public void addRequirement(Requirement requirement)
  {
    for (int i = 0; i < requirements.size(); i++)
      if (requirements.get(i).getId() == requirement.getId())
      {
        requirement.setId();
      }
    requirements.add(requirement);
  }

  /**
   * A method to add task to requirement.
   *
   * @param requirementId requirement ID.
   * @param task          task that u want to add.
   */
  public void addTask(int requirementId, Task task)
  {
    for (Requirement a : requirements)
    {
      if (a.getId() == requirementId)
      {
        a.addTask(task);
      }
    }
  }

  /**
   * A method that adds team member.
   *
   * @param member member.
   */
  public void addTeamMember(Member member)
  {
    members.add(member);
  }

  public void removeTeamMember(Member member)
  {
    members.remove(member);
  }

  /**
   * A to string method.
   *
   * @return String of instance variables of this class.
   */
  @Override public String toString()
  {
    return "Project{" + "name='" + name + '\'' + ", description='" + description
        + '\'' + ", projectId=" + projectId + ", status=" + status.getStatus() + ", requirements=" + requirements + ", startDate=" + startDate
        + ", deadLine=" + deadLine + ", members=" + members + '}';
  }

  /**
   * Getter for all not completed requirements.
   *
   * @return An array list of not completed requirements.
   */
  public ArrayList<Requirement> getAllNotCompletedRequirements()
  {
    ArrayList<Requirement> requirements1 = new ArrayList<>();
    for (Requirement a : requirements)
    {
      if (!a.getStatus().equals("Ended"))
      {
        requirements1.add(a);
      }
    }
    return requirements1;
  }

  /**
   * Getter for number of members.
   *
   * @return the number of members.
   */
  public int getNumberOfMembers()
  {
    return members.size();
  }

  /**
   * A method that removes a requirement.
   *
   * @param index the index of the requirement that is set to remove.
   */
  public void removeRequirement(int index)
  {
    for (int i = 0; i < requirements.size(); i++)
      if (i == index)
        requirements.remove(requirements.get(index));
  }

  /**
   * Getter for requirement size.
   *
   * @return the size of the requirements arraylist.
   */
  public int getRequirementSize()
  {
    return requirements.size();
  }

  /**
   * A method that checks if requirement ID is unique.
   *
   * @param requirement requirement.
   * @return true if ID is unique, false if otherwise.
   */
  public boolean hasUniqueID(Requirement requirement)
  {
    for (int i = 0; i < requirements.size(); i++)
      if (requirements.get(i).getId() == requirement.getId())
        return false;
    return true;
  }
}
