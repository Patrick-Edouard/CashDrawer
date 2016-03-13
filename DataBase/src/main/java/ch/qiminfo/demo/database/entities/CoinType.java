package ch.qiminfo.demo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum CoinType {
    FIVE_COIN("FIVE_COIN", 500),
    TWO_COIN("TWO_COIN", 200),
    ONE_COIN("ONE_COIN", 100),
    FIFTY_CENT("FIFTY_CENT", 50),
    TWENTY_CENT("TWENTY_CENT", 20),
    TEN_CENT("TEN_CENT", 10),
    FIVE_CENT("FIVE_CENT", 5);

	@Column
    private final String coinTypeString;
    
	@Id
    private final int value;

    CoinType(String coinTypeString, int value){
        this.coinTypeString = coinTypeString;
        this.value = value;
    }

    public String getCoinTypeString(){
        return coinTypeString;
    }

    public int getValue(){
        return value;
    }
}
