package debug;

import debug.model.*;

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}

/**
Fehler 1
Dog.java Z: 3
Fehlermeldung:
**************
./debug/model/Dog.java:3: error: cannot find symbol
public class Dog extends Animal{
                         ^
  symbol: class Animal
debug/Debug.java:9: error: incompatible types: Dog cannot be converted to Animal
    animals[1] = new Dog("Barks");
                 ^
./debug/model/Dog.java:10: error: method does not override or implement a method from a supertype
  @Override
  ^
./debug/model/Dog.java:12: error: cannot find symbol
    return super.name_;
           ^
  symbol:   variable super
  location: class Dog
./debug/model/Dog.java:15: error: method does not override or implement a method from a supertype
  @Override
  ^
./debug/model/Dog.java:20: error: method does not override or implement a method from a supertype
  @Override
  ^
./debug/model/Dog.java:25: error: method does not override or implement a method from a supertype
  @Override
  ^
./debug/model/Monkey.java:7: error: constructor Animal in class Animal cannot be applied to given types;
    super(name);
    ^
  required: String
  found:    String
  reason: Animal(String) is not public in Animal; cannot be accessed from outside package
./debug/model/Monkey.java:13: error: name_ has private access in Animal
    return super.name_;
                ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
9 errors
**************
Der Compiler findet das Symbol Animal nicht, da die Animal Class nicht importiert war.
 */

/*
Fehler 2,3
Animal.java Z: 9, 15
Fehlermeldung:
**************
./debug/model/Dog.java:8: error: constructor Animal in class Animal cannot be applied to given types;
    super(name);
    ^
  required: String
  found:    String
  reason: Animal(String) is not public in Animal; cannot be accessed from outside package
./debug/model/Dog.java:14: error: name_ has private access in Animal
    return super.name_;
                ^
./debug/model/Monkey.java:7: error: constructor Animal in class Animal cannot be applied to given types;
    super(name);
    ^
  required: String
  found:    String
  reason: Animal(String) is not public in Animal; cannot be accessed from outside package
./debug/model/Monkey.java:13: error: name_ has private access in Animal
    return super.name_;
                ^
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
4 errors
**************
beide Konstructoren der Klasse Animal hatten kein keyword, 
sodass sie standardmäßig auf private gesetzt wurden und auf diese somit nicht von außerhalb des packages 
zugegriffen werden kann.
 */


 /*
Fehler 4, 5
Dog.java Z: 14, Monkey.java Z: 13
Fehlermeldung:
**************
./debug/model/Dog.java:14: error: name_ has private access in Animal
    return super.name_;
                ^
./debug/model/Monkey.java:13: error: name_ has private access in Animal
    return super.name_;
                ^
2 errors
**************
hier wurde versucht, direkt auf die Membervariable "name_" zuzugreifen, da diese jedoch private ist, schlägt dies fehl.
Korrekt wäre die Verwendung des getters für den Namen.
  */