package astralplane.spell.exception;

import astralplane.exception.ResourceNotFoundException;

/**
 * Captures Spell Exceptions when retrieving record(s) from Database
 * @author ianww
 *
 */
public class SpellResourceException extends ResourceNotFoundException {

	
	private static final long serialVersionUID = 6957666163382166678L;
	
	public SpellResourceException(int id) {
		super("Could not locate spell with ID: " + id);
	}

}
