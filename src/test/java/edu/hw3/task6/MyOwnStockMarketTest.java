package edu.hw3.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyOwnStockMarketTest {
    MyOwnStockMarket myOwnStockMarket;

    @BeforeEach void stockMarketInitialization() {
        myOwnStockMarket = new MyOwnStockMarket();
    }

    @Test
    @DisplayName("Добавление существующей акции") void testExistingStockAddition() {
        // given
        Stock stock1 = new Stock("SBER", 250);
        Stock stock2 = new Stock("SBER", 260);

        // expected
        myOwnStockMarket.add(stock1);
        Assertions.assertThrows(StockMarketException.class, () -> myOwnStockMarket.add(stock2));
    }

    @Test
    @DisplayName("Удаление несуществующей акции") void testNonexistingStockDeleting() {
        // expected
        Assertions.assertThrows(
            StockMarketException.class,
            () -> myOwnStockMarket.remove(new Stock("ALROSA", 100))
        );
    }

    @Test
    @DisplayName("Вывод самой дорогостоящей акции") void testMostValuableStockOutput() {
        // given
        Stock stock1 = new Stock("SBER", 200);
        Stock stock2 = new Stock("AAPL", 1000);
        Stock stock3 = new Stock("ALROSA", 100);

        myOwnStockMarket.add(stock1);
        myOwnStockMarket.add(stock2);
        myOwnStockMarket.add(stock3);

        // expected
        assertEquals(myOwnStockMarket.mostValuableStock(), stock2);
    }

}
