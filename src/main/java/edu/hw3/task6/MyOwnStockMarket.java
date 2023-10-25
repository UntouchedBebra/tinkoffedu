package edu.hw3.task6;

import java.util.PriorityQueue;
import java.util.logging.Logger;

public class MyOwnStockMarket implements StockMarket {
    private final PriorityQueue<Stock> store;
    private final Logger logger;

    public MyOwnStockMarket() {
        store = new PriorityQueue<>();
        logger = Logger.getLogger(MyOwnStockMarket.class.getName());
    }

    @Override
    public void add(Stock stock) {
        if (store.contains(stock)) {
            throw new StockMarketException("Данная акция уже залисчена");
        } else {
            store.add(stock);
        }
    }

    @Override
    public void remove(Stock stock) {
        if (store.remove(stock)) {
            logger.info("Акция удалена");
        } else {
            throw new StockMarketException("Акция отсутствует в списке, удаление невозможно");
        }
    }

    @Override
    public Stock mostValuableStock() {
        if (store.peek() == null) {
            throw new StockMarketException("Список акций пуст, получение самой дорогой акции невозможно");
        } else {
            return store.peek();
        }
    }

}
