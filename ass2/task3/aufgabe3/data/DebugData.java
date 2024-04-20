package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData { // Klasse war private, da keyword public fehlte
    private double x;
    private double y;
    
    public DebugData(double x, double y) { // Parameter sollen double sein, nicht int
        this.x = x;
        this.y = y;
    }
    
    public double distance(DebugData other) {
        return Math.pow(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2), 0.5); // zweiter Parameter der äußeren Math.pow Methode fehlt, müsste 0.5 sein
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y; // sollte .y und nicht .x sein
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public String str() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}

/* 
Z 6: Klasse war private, da keyword public fehlte

Fehlermeldung:
**************
DebugMain.java:5: error: cannot find symbol
        DebugData a = new DebugData(3.4, 5.6);
        ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:5: error: cannot find symbol
        DebugData a = new DebugData(3.4, 5.6);
                          ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:6: error: cannot find symbol
        DebugData b = new DebugData(1.0, 1.0);
        ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:6: error: cannot find symbol
        DebugData b = new DebugData(1.0, 1.0);
                          ^
  symbol:   class DebugData
  location: class DebugMain
4 errors
**************

DebugMain konnte nicht auf die Klasse "DebugData" des 
Packages "aufgabe3.data", da die Klasse ohne keyword 
standardmäßig private ist und damit nicht außerhalb 
des packages darauf zugegriffen werden kann.
*/

/*
Z 10: Parameter sollen double sein, nicht int

Fehlermeldung:
**************
aufgabe3/DebugMain.java:6: error: incompatible types: possible lossy conversion from double to int
        DebugData a = new DebugData(3.4, 5.6);
                                    ^
aufgabe3/DebugMain.java:7: error: incompatible types: possible lossy conversion from double to int
        DebugData b = new DebugData(1.0, 1.0);
                                    ^
./aufgabe3/data/DebugData.java:16: error: method pow in class Math cannot be applied to given types;
        return Math.pow(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
                   ^
  required: double,double
  found:    double
  reason: actual and formal argument lists differ in length
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
3 errors
**************

Der Compiler warnt vor einer unsauberen type conversion, 
da hier doubles übergeben werden, die Parameter der Funktion 
aber den Typ "Int" haben.
*/

/*
Z 16: zweiter Parameter der äußeren Math.pow Methode fehlt, müsste 0.5 sein

Fehlermeldung:
**************
./aufgabe3/data/DebugData.java:16: error: method pow in class Math cannot be applied to given types;
        return Math.pow(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
                   ^
  required: double,double
  found:    double
  reason: actual and formal argument lists differ in length
1 error
**************

hier fehlt der zweite Parameter der äußeren Methode "Math.pow" 
*/

/*
Z 24: sollte .y und nicht .x sein

hier soll auf das Attrivut "y" zugegriffen werden, es wurde
jedoch auf "x" zugegriffen
*/