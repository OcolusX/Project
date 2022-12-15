import java.util.Stack;

public class Expression {

    private boolean doubleMulDivOperation;
    private Double result;
    private Stack<Node> nodes;

    Expression() {
        nodes = new Stack<>();
    }

    public void add(Double value, Operation operation) {
        doubleMulDivOperation = false;
        if (nodes.empty()) {
            nodes.push(new Node(value, operation));
            result = value;
        } else {
            switch (operation) {
                case SUM:
                case SUBTRACTION: {
                    calculate(value);
                    nodes.push(new Node(result, operation));
                    break;
                }
                case MULTIPLICATION:
                case DIVISION: {
                    Operation previousOperation = nodes.peek().operation;
                    if (previousOperation == Operation.MULTIPLICATION || previousOperation == Operation.DIVISION) {
                        doubleMulDivOperation = true;
                        calculate(value);
                        nodes.push(new Node(result, operation));
                    } else {
                        nodes.push(new Node(value, operation));
                    }
                    break;
                }
                case OPEN_BRACKET:
                    nodes.push(new Node(value, operation));
                    break;
                case CLOSE_BRACKET:
                    nodes.push(new Node(value, operation));
                    calculate(null);
                    nodes.pop();
                    break;
                case EQUALITY: {
                    calculate(value);
                    break;
                }
            }
        }
    }

    public void popLast() {
        nodes.pop();
    }

    public Double getResult() {
        return result;
    }

    public boolean isDoubleMulDivOperation() {
        return doubleMulDivOperation;
    }

    public void clear() {
        result = 0.0;
        nodes.clear();
        doubleMulDivOperation = false;
    }

    private void calculate(Double value) {
        while (!nodes.empty()) {
            if(nodes.peek().operation == Operation.OPEN_BRACKET) {
                break;
            }
            Node pop = nodes.pop();
            switch (pop.operation) {
                case SUM:
                    value = pop.value + value;
                    break;
                case SUBTRACTION:
                    value = pop.value - value;
                    break;
                case MULTIPLICATION:
                    value = pop.value * value;
                    break;
                case DIVISION:
                    value = pop.value / value;
                    break;
                case CLOSE_BRACKET:
                    value = pop.value;
                    break;
            }
            if (doubleMulDivOperation) {
                break;
            }
        }
        result = value;
    }

    private static class Node {
        Double value;
        Operation operation;

        public Node(Double value, Operation operation) {
            this.value = value;
            this.operation = operation;
        }

    }
}
