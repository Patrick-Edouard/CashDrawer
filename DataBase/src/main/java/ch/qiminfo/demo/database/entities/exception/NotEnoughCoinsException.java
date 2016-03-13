package ch.qiminfo.demo.database.entities.exception;

/**
 * Created by patrick-edouard on 3/7/16.
 */
public class NotEnoughCoinsException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughCoinsException(){
        //super("Not enough coins available");
    }

    public String getMessage(){
        return "Not enough coins available\n"+super.getMessage();
    }
}
