enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

//Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){ 
    if (right == 0 && op == Operator.DIVIDE) throw new ArithmeticException("/ by zero"); // Der Fall, dass durch 0 dividiert wird, wurde nicht abgefangen
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (this.op_) {
      case ADD: // "Operator." ist überflüssig
        return this.left_ + this.right_;
      case SUBTRACT: // "Operator." ist überflüssig
        return this.left_ - this.right_;
      case MULTIPLY: // "Operator." ist überflüssig
        return this.left_ * this.right_;
      case DIVIDE: // "Operator." ist überflüssig
        return this.left_ / this.right_;
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4]; // array zu lang, es gibt nur 4 Operatoren
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i, i + 1, ops[i]); // 0 darf nicht rechts stehen
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}

/*
Z 18, 20, 22, 24: "Operator." ist überflüssig

Fehlermeldung:
**************
Debug.java:18: error: an enum switch case label must be the unqualified name of an enumeration constant
      case Operator.ADD:
                   ^
Debug.java:20: error: an enum switch case label must be the unqualified name of an enumeration constant
      case Operator.SUBTRACT:
                   ^
Debug.java:22: error: an enum switch case label must be the unqualified name of an enumeration constant
      case Operator.MULTIPLY:
                   ^
Debug.java:24: error: an enum switch case label must be the unqualified name of an enumeration constant
      case Operator.DIVIDE:
                   ^
4 errors
**************

Die cases eines switch statements dürfen nur Integer sein. 
In diesem Fall kann der Compiler die Ausrücke nicht in solche umwandeln.
*/

/*
Z 10: der Fall, dass der rechte Operand 0 ist und der Operator gleichzeitig 0 ist, wird im Constructor nicht ausgeschlossen.
*/

/*
Z 44: der Fall, dass der rechte Operand 0 ist und der Operator gleichzeitig 0 ist, wird herbeigeführt.

Fehlermeldung:
**************
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Expression.<init>(Debug.java:11)
        at Debug.main(Debug.java:44)
**************
*/

/*
Z 36: Das Operator Array hatte die Länge 5, obwohl es nur 4 Operatoren gibt

Fehlermeldung:
**************
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Expression.evaluate()" because "<local2>[<local3>]" is null
        at Debug.main(Debug.java:48)
**************

Der Compiler meldet einen Fehler, da hier eigentlich auf ein Objekt der Klasse "Expression" zugegriffen werden sollte,
sich an Index 4 jedoch nur "null" befindet. 
*/