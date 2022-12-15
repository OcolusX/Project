import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private JButton clearButton;
    private JButton button_7;
    private JButton button_5;
    private JButton button_8;
    private JButton button_9;
    private JButton button_4;
    private JButton button_6;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_0;
    private JButton sumButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton equalButton;
    private JPanel calculatorPanel;
    private JTextField expressionField;
    private JButton commaButton;
    private JButton deleteButton;
    private JButton openBracketButton;
    private JButton closeBracketButton;

    private String value = "";
    private Operation operation;
    private boolean isOpenBracket;
    private boolean isCloseBracket;
    private Expression expression;

    private static final DecimalFormat doubleFormat = new DecimalFormat("#.#####");
    private static final DecimalFormat integerFormat = new DecimalFormat("#");

    public Calculator() {
        expression = new Expression();

        button_0.addActionListener(e -> digitButtonListener(button_0));
        button_1.addActionListener(e -> digitButtonListener(button_1));
        button_2.addActionListener(e -> digitButtonListener(button_2));
        button_3.addActionListener(e -> digitButtonListener(button_3));
        button_4.addActionListener(e -> digitButtonListener(button_4));
        button_5.addActionListener(e -> digitButtonListener(button_5));
        button_6.addActionListener(e -> digitButtonListener(button_6));
        button_7.addActionListener(e -> digitButtonListener(button_7));
        button_8.addActionListener(e -> digitButtonListener(button_8));
        button_9.addActionListener(e -> digitButtonListener(button_9));
        commaButton.addActionListener(e -> digitButtonListener(commaButton));

        sumButton.addActionListener(e -> operationButtonListener(sumButton));
        subButton.addActionListener(e -> operationButtonListener(subButton));
        mulButton.addActionListener(e -> operationButtonListener(mulButton));
        divButton.addActionListener(e -> operationButtonListener(divButton));
        equalButton.addActionListener(e -> operationButtonListener(equalButton));

        openBracketButton.addActionListener(e -> bracketButtonListener(openBracketButton));
        closeBracketButton.addActionListener(e -> bracketButtonListener(closeBracketButton));

        deleteButton.addActionListener(e -> {
            String text = expressionField.getText();
            char c = text.charAt(text.length() - 1);
            if (c > '0' && c < '9') {
                value = value.substring(0, value.length() - 1);
            } else {
                value = expression.getResult().toString();
                expression.popLast();
            }
            text = text.substring(0, text.length() - 1);
            expressionField.setText(text);
        });

        clearButton.addActionListener(e -> {
            expressionField.setText("");
            value = "";
            expression.clear();
        });

        expressionField.setDisabledTextColor(Color.BLACK);
    }

    private void digitButtonListener(JButton button) {
        String digit = button.getText();
        expressionField.setText(expressionField.getText() + digit);
        value += digit;
    }

    private void bracketButtonListener(JButton button) {
        operation = Operation.getOperation(button.getText().charAt(0));
        expressionField.setText(expressionField.getText() + operation);
        if(operation == Operation.OPEN_BRACKET) {
            expression.add(null, operation);
            isOpenBracket = true;
        } else if(operation == Operation.CLOSE_BRACKET){
            expression.add(Double.parseDouble(value.replace(",", ".")), operation);
            isCloseBracket = true;
        }
        value = "";
    }

    private void operationButtonListener(JButton button) {
        operation = Operation.getOperation(button.getText().charAt(0));
        if(isCloseBracket) {
            isCloseBracket = false;
            Double result = expression.getResult();
            expression.add(result, operation);
            String stringResult = stringResult(result);
            String text = expressionField.getText();
            Matcher matcher = Pattern.compile("\\(.+?\\)").matcher(text);
            if(matcher.find()) {
                text = text.substring(0, matcher.start()) + stringResult + text.substring(matcher.end());
                if(operation == Operation.EQUALITY) {
                    expressionField.setText(text);
                } else {
                    expressionField.setText(text + operation);
                }
            }
            return;
        }
        expression.add(Double.parseDouble(value.replace(",", ".")), operation);
        if(isOpenBracket) {
            isOpenBracket = false;
            expressionField.setText(expressionField.getText() + operation);
            value = "";
            return;
        }
        switch (operation) {
            case SUM:
            case SUBTRACTION: {
                Double result = expression.getResult();
                expressionField.setText(stringResult(result) + operation);
                value = "";
                break;
            }
            case MULTIPLICATION:
            case DIVISION: {
                if (expression.isDoubleMulDivOperation()) {
                    Double result = expression.getResult();
                    value = stringResult(result);
                    expressionField.setText(expressionField.getText()
                            .replaceFirst("\\d+,?\\d*\\*\\d+,?\\d*", value + operation)
                    );

                } else {
                    expressionField.setText(expressionField.getText() + operation);
                }
                value = "";
                break;
            }
            case EQUALITY: {
                Double result = expression.getResult();
                value = stringResult(result);
                expressionField.setText(value);
                break;
            }
        }
    }

    private String stringResult(Double result) {
        if(result % 1 == 0.0) {
            return integerFormat.format(result);
        } else {
            return doubleFormat.format(result);
        }
    }

    public JPanel getPanel() {
        return calculatorPanel;
    }


}
