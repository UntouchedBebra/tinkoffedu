package homework2.task1;

public sealed interface Expression permits Constant, Negate, Exponent, Addition, Multiplication {
    double evaluate();
}
