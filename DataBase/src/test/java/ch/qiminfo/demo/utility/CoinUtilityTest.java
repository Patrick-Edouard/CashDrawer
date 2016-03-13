package ch.qiminfo.demo.utility;

import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.CoinType;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by patrick-edouard on 3/9/16.
 */
public class CoinUtilityTest {

    @Test
    public void testGetDecimalValue() throws Exception {
        Coin coin = new Coin();
        coin.setCoinType(CoinType.FIFTY_CENT);;
        assertTrue(CoinUtility.getDecimalValue(coin) == 0.5);
        assertFalse(CoinUtility.getDecimalValue(coin) == 50);
    }

    @Test
    public void testGetCentValue(){
        assertTrue(CoinUtility.getCentValue(2.5)==250);
    }
}