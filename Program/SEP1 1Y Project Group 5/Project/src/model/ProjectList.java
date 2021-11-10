package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that represents project list.
 */
public class ProjectList implements Serializable
{
  private ArrayList<Project> projects;

  /**
   * A constructor for project list.
   */
  public ProjectList()
  {
    this.projects = new ArrayList<>();
  }

  /**
   * Getter for project by ID.
   * @param id ID of project that is wanted.
   * @return project.
   */
  public Project getProjectById(int id)
  {
    for(Project a: projects)
    {
      if(a.getProjectId() == id)
      {
        return a;
      }
    }
    return null;
  }

  /**
   * Getter for project by name.
   * @param name name of project that is wanted.
   * @return project.
   */
  public Project getProjectByName(String name)
  {
    for(Project a: projects)
    {
      if(a.getName().equals(name))
      {
        return a;
      }
    }
    return null;
  }

  /**
   * Getter for project by status.
   * @param status status of project.
   * @return project.
   */
  public Project getProjectByStatus(String status)
  {
    for(Project a: projects)
    {
      if(a.getStatus().getStatus().equals(status))
      {
        return a;
      }
    }
    return null;
  }

  /**
   * Getter fro project by index.
   * @param index index of wanted project.
   * @return project.
   */
  public Project getProject(int index)
  {
    return projects.get(index);
  }

  /**
   * Setter for projects.
   * @param project project.
   * @param index index that project is goin to be added at.
   */
  public void setProjects(Project project, int index)
  {
    projects.add(index, project);
  }

  /**
   * A method that removes project.
   * @param index index of project that is going to be removed.
   */
  public void removeProject(int index){
    for(int i = 0; i < projects.size(); i++)
      if(i == index)
        projects.remove(projects.get(i));
  }

  /**
   * Getter for projects arraylist size.
   * @return size of projects array list.
   */
  public int getSize()
  {
    return projects.size();
  }

  /**
   * A method that adds project.
   * @param project project that is going to be added.
   */
  public void addProject(Project project){
    projects.add(project);
  }
}
