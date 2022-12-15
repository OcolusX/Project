public enum Operation {
    SUM('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    OPEN_BRACKET('('),
    CLOSE_BRACKET(')'),
    EQUALITY('=');

    char operation;

    Operation(char operation) {
        this.operation = operation;
    }

    public static Operation getOperation(char operation) {
        for(Operation o : Operation.values()) {
            if(o.operation == operation) {
                return o;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return operation + "";
    }
}
