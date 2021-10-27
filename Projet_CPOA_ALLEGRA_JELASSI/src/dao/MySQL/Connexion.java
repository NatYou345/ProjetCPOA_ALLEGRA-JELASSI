/**
 * 
 */
package dao.MySQL;

import java.sql.*;

public class Connexion {
  public Connection creeConnexion() {
String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/allegra2u_CPOA_bdd";
String login = "allegra2u_appli";
String pwd = "32009729"; 
Connection maConnexion = null;
try { 
maConnexion = DriverManager.getConnection(url, login, pwd);
} catch (SQLException sqle) {
System.out.println("Erreur connexion" + sqle.getMessage());
}
return maConnexion;
  }
}