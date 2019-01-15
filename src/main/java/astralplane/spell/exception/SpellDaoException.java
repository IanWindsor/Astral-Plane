package astralplane.spell.exception;

/**
 * Captures Spell Exceptions when retrieving record(s) from Database
 * @author ianww
 *
 */
public class SpellDaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6957666163382166678L;
	
	public SpellDaoException(String message) {
		super(message);
	}

}
