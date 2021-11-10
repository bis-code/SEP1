package model;

import java.io.Serializable;

/**
 * Class representing the Product Owner.
 */
public class ProductOwner extends Member implements Serializable
{
  /**
   * Constructor for product owner.
   * @param name Name of product owner.
   */
  public ProductOwner(String name)
  {
    super(name);
  }

  /**
   * Getter for product owner role(His role is: "Product Owner").
   * @return the role of this member.
   */
  public String getRole()
  {
    return "Product Owner";
  }

  /**
   * A method that compares two objects.
   * @param obj The dummy object of member.
   * @return true if objects and their variables are equal and false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof ProductOwner))
      return false;
    ProductOwner other = (ProductOwner)obj;
    return super.equals(other) && getRole().equals(other.getRole());
  }
}
