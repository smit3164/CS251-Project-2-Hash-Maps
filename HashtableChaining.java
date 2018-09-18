import java.util.ArrayList;
import java.util.LinkedList;

/*  Links:
    https://drive.google.com/file/d/1Ry0RA8j1F_tRw77TJij7jMuX6iwtUwN6/view
    https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 */

public class HashtableChaining {

    double LOAD_FACTOR = 0.75;
    int HASHCODE_CONST = 37;
    private ArrayList<LinkedList<Pair>> table;    //ArrayList of Linked Lists.

    public HashtableChaining(int size) {
        table = new ArrayList<LinkedList<Pair>>(size);
    }

    public boolean insert(String key) { //Note: May want void return type instead.

        /*  Idea: Call the rehashing function every time and have the insert() method return the number of items
            currently in the table. The rehashing function takes a int argument and checks to see if the table needs
            to be rehashed. LIMITS: Would make manual rehashing weird though. Perhaps overload? Or might not even want
            to do this depending on the expected implementation of rehash()
         */
        //Todo: Check if the table needs to be rehashed before inserting.

        /*  Note: I'm not sure if the .contains(new Pair(key)) will correctly match to a Pair that is already in the
            LinkedList because they may have different pointers.
         */
        if(table.get(hash(key)).contains(new Pair(key))) {
            table.get(hash(key)).get(table.get(hash(key)).indexOf(new Pair(key))).increment();
            //Increment the number stored with the key by 1.
            return true;
        }

        try  {
            table.get(hash(key)).add(new Pair(key));
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;   //Todo: return true if it worked, false otherwise.
    }

    public boolean remove(String key) { //Note: May want void return type instead.

        /*  May need to consider when to downsize. Not sure what the expected implementation is. Look at this when
            the official release drops on Blackboard.
         */
        //Todo: add code
        return false;   //Todo: return true if it worked, false otherwise.
    }

    public boolean contains(String key) {
        //Todo: add code
        return false;   //Todo: return true if it worked, false otherwise.
    }

    public int size() {
        //Todo: add code
        return -1;
    }

    private int hash(String key) {   //Note: May want void return type instead.
        //Todo: add code
        return -1;   //Todo: return the index of the hash
        //Note: % size_of_table
    }

    private boolean rehash() {   //Note: May want void return type instead.
        // Some potentially helpful links:
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
        // https://www.google.com/search?client=ubuntu&channel=fs&q=prime+number+generator+algorithm&ie=utf-8&oe=utf-8
        //Todo: add code
        return false;
    }
}

//Todo: May need to create a .equals() method for comparisons
class Pair {
    private String keyString;
    private int numEntries = 0;

    public Pair(String key) {
        keyString = key;
        numEntries++;
    }
    public void increment() {
        numEntries++;
    }
    public void decrement() {
        numEntries--;
    }
}
