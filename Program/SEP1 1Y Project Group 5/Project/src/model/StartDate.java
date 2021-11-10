package model;

import java.io.Serializable;

/**
 * Class that represents start date.
 */
public class StartDate implements Serializable
{
  private int year;
  private int month;
  private int day;

  /**
   * Constructor for start date.
   * @param year year.
   * @param month month.
   * @param day day.
   */
  public StartDate(int year, int month, int day)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Start date constructor without any variable. Variables then are set to 0.
   */
  public StartDate()
  {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }

  /**
   * Setter for start date.
   * @param year year.
   * @param month month.
   * @param day day.
   */
  public void setStartDate(int year, int month, int day)
  {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  /**
   * Getter for year.
   * @return year of start date.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Getter for month.
   * @return month of start date.
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Getter for day.
   * @return day of start date.
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Mehtod that counts number of days in a month.
   * @param month month.
   * @return days in a month.
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
    return 0;
  }

  /**
   * Method that checks if a year is leap year.
   * @return true if it is leap year, false if otherwise.
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
   * Method that changes start date.
   * @param startDate start date.
   */
  public void changeStartDate(StartDate startDate)
  {
    setStartDate(startDate.getYear(), startDate.getMonth(), startDate.getDay());
  }

  /**
   * To string method.
   * @return string of instance variables of this class.
   */
  public String toString()
  {
    return year + "/" + month + "/" + day;
  }
}
