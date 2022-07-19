package chap10;

import chap10.model.Order;

import static chap10.MixedBuilder.forCustomer;
import static chap10.NestedFunctionOrderBuilder.*;

/**
 * @author Вагин Михаил
 * date 18.07.2022
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.nestedFunction();
        main.lambda();
        main.mixed();
    }

    public void nestedFunction() {
        Order order = order("BigBank",
                buy(80,
                        stock("IBM", on("NYSE")),
                        at(125.00)),
                sell(50,
                        stock("GOOGLE", on("NASDAQ")),
                        at(375.00))
        );

        System.out.println("Nested function:");
        System.out.println(order);
    }

    public void lambda() {
        Order order = LambdaOrderBuilder.order( o -> {
            o.forCustomer( "BigBank" );
            o.buy( t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell( t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });

        System.out.println("Lambda:");
        System.out.println(order);
    }

    public void mixed() {
        Order order =
                forCustomer("BigBank",
                        chap10.MixedBuilder.buy(t -> t.quantity(80)
                                .stock("IBM")
                                .on("NYSE")
                                .at(125.00)),
                        chap10.MixedBuilder.sell(t -> t.quantity(50)
                                .stock("GOOGLE")
                                .on("NASDAQ")
                                .at(375.00)));

        System.out.println("Mixed:");
        System.out.println(order);
    }
}
