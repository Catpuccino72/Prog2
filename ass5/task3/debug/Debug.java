package debug;

import debug.model.*;


public class Debug {
  public static void main(String[] args) {
    
    IntBinTreeNode treeSorted = new SortedIntBinTreeNode(1, null, null);
    IntBinTreeNode treeUnsorted = new UnsortedIntBinTreeNode(1, null, null);
    int[] toInsert = { 4, 2, 6, 8, 0, 2, 1, 5, 1 };
    // for each i in toInsert
    for (int i : toInsert) {
      treeSorted.insert(i);
      treeUnsorted.insert(i);
    }
    System.out.println(treeSorted);
    System.out.println(treeUnsorted);
  }
}

/*
Klasse UnsortedIntBinTreeNode: constructor fehlt
Fehlermeldung:
*********************
debug/Debug.java:10: error: constructor UnsortedIntBinTreeNode in class UnsortedIntBinTreeNode cannot be applied to given types;
    IntBinTreeNode treeUnsorted = new UnsortedIntBinTreeNode(1, null, null);
                                  ^
  required: no arguments
  found:    int,<null>,<null>
  reason: actual and formal argument lists differ in length
*********************
Da hier Parameter angegeben wurden, sucht der Compiler nach einem Konstruktor dieser Art, es ist jedoch keiner vorhanden.
*/

/*
Klasse SortedIntBinTreeNode, Zeile: 5
Fehlermeldung:
*********************
  ./debug/model/SortedIntBinTreeNode.java:5: error: SortedIntBinTreeNode is not abstract and does not override abstract method contains(int) in IntBinTreeNode
  public class SortedIntBinTreeNode extends IntBinTreeNode {
*********************
in der abstract class ist die methode contains(int) deklariert, die nicht implementiert wird.
*/

/*
Klasse UnsortedIntBinTreeNode, Zeile: 22
Fehlermeldung:
*********************
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.Random.nextBoolean()" because "debug.model.UnsortedIntBinTreeNode.rand" is null
        at debug.model.UnsortedIntBinTreeNode.insert(UnsortedIntBinTreeNode.java:22)
        at debug.Debug.main(Debug.java:15)
*********************
Das Attribut Random rand wird nicht initialisiert.
 */

 /*
Klasse SortedIntBinTreeNode, Zeile: 26, 31
hier sollten die Werte je nachdem, ob sie größer oder kleiner sind, in den jeweils anderen Teilbaum eingesetzt werden.
 */


