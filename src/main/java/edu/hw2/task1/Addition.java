package edu.hw2.task1;

public record Addition(Expression firstExpression, Expression secondExpression) implements Expression {
    @Override
    public double evaluate() {
        return firstExpression.evaluate() + secondExpression.evaluate();
    }
}
