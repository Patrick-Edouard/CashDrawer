package ch.qiminfo.demo.database.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import ch.qiminfo.demo.utility.CoinUtility;

/**
 * Created by patrick-edouard on 3/7/16.
 */

@Entity
@NamedQuery(
        name="findAllCoinsByType",
        query="SELECT OBJECT(coin) FROM Coin coin WHERE coin.coinType = :type"
)
//@SecondaryTable(name="CoinType", pkJoinColumns={@PrimaryKeyJoinColumn(name="value",referencedColumnName="value")})
public class Coin implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @Enumerated
    private CoinType coinType;
    
    private static final long serialVersionUID = 1L;

    public Coin(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return coinType.getValue();
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public void setCoinType(CoinType coinType) {
        this.coinType = coinType;
    }

    public String toString(){
        String result = "";

        double coinValue = CoinUtility.getDecimalValue(this);
        result+=" [COIN]"+coinValue+ "[ID]"+getId();;

        return result;
    }
}
