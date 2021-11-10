package model;

import java.io.Serializable;

/**
 * A class that represents scrum master.
 */
public class ScrumMaster extends Member implements Serializable
{
  /**
   * A constructor for scrum master.
   * @param name
   */
  public ScrumMaster(String name)
  {
    super(name);
  }

  /**
   * Getter for scrum master role (the role is "Scrum master").
   * @return role of scrum master.
   */
  public String getRole()
  {
    return "Scrum Master";
  }

  /**
   * A method that compares two objects.
   * @param obj The dummy object of member.
   * @return true if objects are identical, otherwise false.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof ScrumMaster))
      return false;
    ScrumMaster other = (ScrumMaster) obj;
    return super.equals(other) && getRole().equals(other.getRole());
  }
}
