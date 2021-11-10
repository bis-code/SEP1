package model;

import java.io.Serializable;

/**
 * Class that represents team member.
 */
public class TeamMember extends Member implements Serializable
{
  /**
   * Constructor for team member.
   * @param name name of team member.
   */
  public TeamMember(String name)
  {
    super(name);
  }

  /**
   * Getter for team member role ("Team member").
   * @return team member role.
   */
  public String getRole()
  {
    return "Team model.Member";
  }
  /**
   * A method that compares two objects.
   * @param obj object compared with team member class object.
   * @return true if objects are identical, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof TeamMember))
      return false;
    TeamMember other = (TeamMember) obj;
    return super.equals(other) && getRole().equals(other.getRole());
  }
}
