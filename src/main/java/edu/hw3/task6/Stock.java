package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private String code;
    private double price;

    public Stock(String code, double currentPrice) {
        if (isCodeValid(code) && isCurrentPriceValid(currentPrice)) {
            this.code = '$' + code.toUpperCase();
            this.price = currentPrice;
        } else {
            throw new StockException("Невалидные данные");
        }
    }

    private boolean isCurrentPriceValid(double currentPrice) {
        return currentPrice > 0;
    }

    private boolean isCodeValid(String inputCode) {
        return inputCode != null && !inputCode.isEmpty() && doesCodeContainOnlyLetters(inputCode);
    }

    private boolean doesCodeContainOnlyLetters(String inputCode) {
        for (char symbol : inputCode.toCharArray()) {
            if (!Character.isLetter(symbol)) {
                return false;
            }
        }
        return true;
    }

    public double getCurrentPrice() {
        return price;
    }


    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return Double.compare(o.getCurrentPrice(), this.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return code.equals(((Stock) obj).getCode());
    }

    @Override
    public String toString() {
        return String.format("{ %s -> %.3f }", code, price);
    }

}
