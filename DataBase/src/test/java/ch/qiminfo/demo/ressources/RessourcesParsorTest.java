package ch.qiminfo.demo.ressources;

import ch.qiminfo.demo.database.entities.CoinType;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by patrick-edouard on 3/9/16.
 */
public class RessourcesParsorTest {

    @org.junit.Test
    public void testGetDbProperties() throws Exception {
        Map<String, String> reStringStringMap = RessourcesParsor.getDbProperties();
        assertTrue(reStringStringMap.get(CoinType.FIFTY_CENT+"_NUMBER").equals("350"));
    }
}