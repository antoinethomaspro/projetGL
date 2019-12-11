package Ticketing_Projet;
/**
 * 
 * @author MARTIN Thomas
 *
 */
public interface ConnexionBDD {
	/**
	 * an abstract method to connect you on the database and execute a SQL request
	 * @param SQLRequest a SQL request that you want execute on the database.
	 */
	public void connexionBD(String SQLRequest);
}
