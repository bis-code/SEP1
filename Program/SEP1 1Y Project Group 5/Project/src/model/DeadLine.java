package model;

import java.io.Serializable;

/**
 * A class representing the deadline.
 */

public class DeadLine implements Serializable
{
  private int year;
  private int month;
  private int day;

  /**
   * Constructor for deadline.
   * @param year the year.
   * @param month the month.
   * @param day the day.
   */
  public DeadLine(int year, int month, int day)
  {
    setDeadLine(year, month, day);
  }

  /**
   * Setter for deadline.
   * @param year the year.
   * @param month the month.
   * @param day the day.
   */
  public void setDeadLine(int year, int month, int day)
  {
    if(year <= -1)
      throw new IllegalArgumentException();
    else this.year = year;
    if(month <= -1 || month >= 13)
      throw new IllegalArgumentException();
    else this.month = month;
    if(day <= -1 || day > numberOfDaysInMonth(month))
      throw new IllegalArgumentException();
    else this.day = day;
  }

  /**
   * Getter for year.
   * @return the year.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Getter for month.
   * @return the month.
   */
  public int getMonth()
  {
    return month;
  }
  /**
   * Getter for day.
   * @return the day.
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Method counting the number of days in a month.
   * @param month the month
   * @return days
   */
  public int numberOfDaysInMonth(int month)
  {
    if(month == 2 && isLeapYear() == true)
    {
      return 29;
    }
    if(month == 2 && isLeapYear() == false)
    {
      return 28;
    }
    if(month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
      return 31;
    }
    if(month == 0)
      return 1;
    return 0;
  }

  /**
   * A method checking if the year is leap year or not.
   * @return true if it is leap year and false if not.
   */
  public boolean isLeapYear()
  {
    if(year % 4 == 0 && ((year % 100 != 0) || year % 400 == 0))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * Method that changes the deadline using setter for it.
   * @param deadLine the deadline.
   */
  public void changeDeadLine(DeadLine deadLine)
  {
    setDeadLine(deadLine.getYear(), deadLine.getMonth(), deadLine.getDay());
  }

  /**
   * A to string method.
   * @return a string with instance variable if this class.
   */
  public String toString()
  {
    return year + "/" + month + "/" + day;
  }
}
