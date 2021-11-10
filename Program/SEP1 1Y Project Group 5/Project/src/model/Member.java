package model;

import java.io.Serializable;

/**
 * An abstract class that represents a member.
 */
public abstract class Member implements Serializable
{
  private String name;

  /**
   * Constructor for the member.
   * @param name the name of the member.
   */
  public Member(String name)
  {
    this.name = name;
  }

  /**
   * Getter for name.
   * @return Member name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Setter for name
   * @param name Member name.
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * An abstract method for getting a Member role.
   * @return Role of the member.
   */
  public abstract String getRole();

  /**
   * An equals method.
   * @param obj The dummy object of member.
   * @return true if dummy object is instance of this class and it's instance variable are equals to member variables.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Member))
      return false;
    Member other = (Member)obj;
    return name.equals(other.name);
  }
}
