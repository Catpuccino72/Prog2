package debug.model;

import debug.Animal; // import was missing

public class Dog extends Animal{
    
  public Dog(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.getName(); // instead of using the getter, the variable was accessed directly
  }

  @Override
  public int getArms() {
    return 4;
  }

  @Override
  public int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getArms(), this.getLegs());
  }
}