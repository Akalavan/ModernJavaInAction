package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Transaction {

    private Trader trader;
    private int year;
    private double price;

    public Transaction(int year, double price) {
        this.year = year;
        this.price = price;
    }

    public Transaction(Trader trader, int year, double price) {
        this.trader = trader;
        this.year = year;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return year == that.year &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(trader, that.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trader, year, price);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "year=" + year +
                ", price=" + price +
                '}';
    }

    public static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(Trader.TRADERS.get(0), 2010, 500),
            new Transaction(Trader.TRADERS.get(1), 2011, 200),
            new Transaction(Trader.TRADERS.get(2), 2015, 560),
            new Transaction(Trader.TRADERS.get(3), 2011, 340),
            new Transaction(Trader.TRADERS.get(4), 2013, 900),
            new Transaction(Trader.TRADERS.get(5), 2012, 123.4),
            new Transaction(Trader.TRADERS.get(6), 2011, 2400)
    );
}
