/**
 * 
 */
package general_DAO;

import java.text.ParseException;

public interface DAO<T> {

	public abstract T getById (int id) throws ParseException;
	public abstract boolean create (T object);
	public abstract boolean update (T object);
	public abstract boolean delete (T object);
	
}
