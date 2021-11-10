package model;

import java.io.Serializable;

/**
 * Class that represents status.
 */
public class Status implements Serializable
{
  private String status;
  public static final String[] STATUS_SELECTION = {"Not started", "Started", "Ended", "Approved", "Rejected", "Not assigned"};

  /**
   * Constructor for status. It is checked in constructor if the status is valid.
   * @param status status.
   */
  public Status(String status)
  {
    boolean isValid = false;
    for(String a: STATUS_SELECTION)
    {
      if(status.toLowerCase().equals(a.toLowerCase()))
      {
        this.status = status;
        isValid = true;
      }
    }
    if(isValid == false)
    {
      this.status = null;
    }
  }

  /**
   * A method that compares two objects.
   * @param obj dummy object.
   * @return true if objects are identical, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Status))
      return false;
    Status other = (Status) obj;
    return status.equals(other.status);
  }

  /**
   * Getter for status.
   * @return status.
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Setter for status.
   * @param status status.
   */
  public void setStatus(String status)
  {
    this.status = status;
  }

  /**
   * To string method.
   * @return string of a status.
   */
  public String toString()
  {
    return status;
  }

}
