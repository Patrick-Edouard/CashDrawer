package ch.qiminfo.demo.utility;

import ch.qiminfo.demo.database.entities.Coin;

/**
 * Created by patrick-edouard on 3/9/16.
 */
public class CoinUtility {

    public static final int CENT_COEF = 100;

    public static double getDecimalValue(Coin coin) {
        return (double)coin.getValue() / CENT_COEF;
    }

    public static int getCentValue(double amount){ return (int)(amount*CENT_COEF); }
}
