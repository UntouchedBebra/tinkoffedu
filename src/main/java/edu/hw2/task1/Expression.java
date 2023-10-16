package edu.hw2.task1;

public sealed interface Expression permits Constant, Negate, Exponent, Addition, Multiplication {
    double evaluate();
}
