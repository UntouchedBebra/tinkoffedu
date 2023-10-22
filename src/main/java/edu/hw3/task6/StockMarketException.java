package edu.hw3.task6;

public class StockMarketException extends RuntimeException {
    public StockMarketException(String info) {
        super(info);
    }

    public StockMarketException(String info, Exception cause) {
        super(info, cause);
    }

}
