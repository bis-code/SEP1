package model;

import java.io.Serializable;

/**
 * Class that represents time.
 */
public class Time implements Serializable
{
  private int hours;
  private int minutes;

  /**
   * Constructor of time.
   * @param h hours.
   * @param m minutes.
   */
  public Time(int h, int m)
  {
    this.hours = h;
    this.minutes = m;
  }

  /**
   * Constructor of time passing in only minutes.
   * @param m minutes.
   */
  public Time(int m)
  {
    this.hours = m/60;
    this.minutes = m - (60*hours);
  }

  /**
   * Getter for time in minutes.
   * @return minutes.
   */
  public int getTimeInMinutes()
  {
    int a = 0;
    a = minutes + hours*60;
    return a;
  }

  /**
   * A method that adds time.
   * @param time time.
   */
  public void addTime(Time time)
  {
    int t = time.getTimeInMinutes();
    if(t<0)
    {
      throw new IllegalArgumentException("Negative value");
    }
    this.hours += t/60;
    this.minutes += t%60;
  }
  /**
   * A method that compares two objects.
   * @param obj object compared with time class object.
   * @return true if objects are identical, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Time))
      return false;
    Time other = (Time)obj;
    return hours == other.hours && minutes == other.minutes;
  }

  /**
   * A to string method.
   * @return string of instance variable of this class.
   */
  public String toString()
  {
    if(minutes == 0)
      return hours + " hours";
    else if(hours == 0)
      return minutes + " minutes";
    else return hours + ":" + minutes;
  }
}
