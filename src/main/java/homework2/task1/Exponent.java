package homework2.task1;

public record Exponent(Expression base, double power) implements Expression {
    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), power);
    }
}
