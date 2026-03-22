/**
 * Class that implement PostfixCalculator
 * @author Aedan Lara-Smith
 * CS251
 */


import java.util.*;

//Constructor for the calc creates stack(operandStack) and Map also links symbol
public class PostfixCalculator {
    private DoubleStack operandStack;
    private Map<String, Operator> operatorMap;

    public PostfixCalculator() {
        operandStack = new DoubleStack();
        operatorMap = new HashMap<>();

        operatorMap.put("+", new AddOperator());
        operatorMap.put("add", new AddOperator());

        operatorMap.put("-", new SubtractOperator());
        operatorMap.put("*", new MultiplyOperator());
        operatorMap.put("multi", new MultiplyOperator());

        operatorMap.put("/", new DivideOperator());
        operatorMap.put("div", new DivideOperator());

        operatorMap.put("sqrt", new SqrtOperator());
        operatorMap.put("=", new PrintOperator());

    }

    //Takes double and pushes on stack
    public void storeOperand(double value) {
        operandStack.push(value);
    }

    //Finds op in map, checks if it exists, determines how many, pops it,
    //calls eval, then push
    public void evaluateOperator(String symbol) {

        Operator op = operatorMap.get(symbol);


        int numArgs = op.numArgs();
        List<Double> args = new ArrayList<>();

        for (int i = 0; i < numArgs; i++) {
            args.add(0, operandStack.pop());
        }

        double result = op.eval(args);
        operandStack.push(result);
    }

//Adds
    private static class AddOperator implements Operator {
        public int numArgs() {
            return 2;
        }

        public double eval(List<Double> args) {
            return args.get(0) + args.get(1);
        }
    }

    // Subtracts
    private static class SubtractOperator implements Operator {
        public int numArgs() {
            return 2;
        }

        public double eval(List<Double> args) {
            return args.get(0) - args.get(1);
        }
    }

    //multiply
    private static class MultiplyOperator implements Operator {
        public int numArgs() {
            return 2;
        }

        public double eval(List<Double> args) {
            return args.get(0) * args.get(1);
        }
    }

    //Divide
    private static class DivideOperator implements Operator {
        public int numArgs() {
            return 2;
        }

        public double eval(List<Double> args) {
            return args.get(0) / args.get(1);
        }
    }

    //Square root
    private static class SqrtOperator implements Operator {
        public int numArgs() {
            return 1;
        }

        public double eval(List<Double> args) {
            return Math.sqrt(args.get(0));
        }
    }

    //returns arg
    private static class PrintOperator implements Operator {
        public int numArgs() {
            return 1;
        }

        public double eval(List<Double> args) {
            double value = args.get(0);
            System.out.println(value);
            return value;
        }
    }
}


