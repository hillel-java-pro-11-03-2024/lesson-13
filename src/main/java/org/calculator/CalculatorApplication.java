package org.calculator;

import static java.lang.System.exit;

import java.math.BigDecimal;

public class CalculatorApplication {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Illegal number of arguments: " + args.length);
      exit(1);
    }

    BigDecimal operand1 = BigDecimal.ZERO;
    BigDecimal operand2 = BigDecimal.ZERO;
    String operator = args[1];

    try {
      operand1 = BigDecimal.valueOf(Double.parseDouble(args[0]));
      operand2 = BigDecimal.valueOf(Double.parseDouble(args[2]));
    } catch (NumberFormatException e) {
      System.out.println("Illegal number format: " + e.getMessage());
      exit(1);
    }

    if (!operator.matches("[+\\-*/]") || operator.length() != 1) {
      System.out.println("Illegal operator: " + operator);
      exit(1);
    }

    BigDecimal result = BigDecimal.ZERO;
    switch(operator) {
      case "+" -> result = operand1.add(operand2);
      case "-" -> result = operand1.subtract(operand2);
      case "*" -> result = operand1.multiply(operand2);
      case "/" -> {
        if (operand2.equals(BigDecimal.ZERO)) {
          System.out.println("Division by zero");
          exit(1);
        }
        result = operand1.divide(operand2, 2);
      }
      default -> System.out.println("Illegal operator: " + operator);
    }

    System.out.println("Result: " + result);
  }

}
