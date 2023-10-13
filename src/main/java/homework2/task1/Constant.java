package homework2.task1;

public record Constant(double number) implements Expression {
    @Override public double evaluate() {
        return this.number;
    }
}
