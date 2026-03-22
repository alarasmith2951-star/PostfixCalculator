/**
 * Class that implement DoubleStack
 * @author Aedan Lara-Smith
 * CS251
 */


import java.util.LinkedList;

public class DoubleStack implements Stack<Double> {
    private LinkedList<Double> list;

    //creates linkedlist
    public DoubleStack() {
        list = new LinkedList<>();
    }

    //add top of stack
    @Override
    public void push(Double value) {
        list.addFirst(value);
    }
    //removes top
    @Override
    public Double pop(){
        return list.removeFirst();
    }
    //returns top elm
    @Override
    public Double peek() {
        return list.getFirst();
    }
// ture if empty
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
