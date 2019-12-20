package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import utils.CommonFunctions;

public class DBAccess_LARS {

	public static Connection con;

	static String dbName = "Billing";
	static String dbUserName = "DBReader";
	static String dbPassword = "dbreader";
	
	//static String dbUserName = "svc-db-ops-portal";
	//static String dbPassword = "zF27HdQ4AN";
	static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dbURL = "jdbc:sqlserver://sdwvdbsql507:1433";
	static String dbURLSP = "jdbc:sqlserver://sdwvdbsql507:1433;databaseName=" + dbName;
	
		public static Connection getConnection() {
			try {
				// dbURL = "jdbc:sqlserver://" + ObjectHelper.dburl + ":1433";

				if (con != null) {
					con.close();
				}
				con = null;
				if (con == null) {

					Class.forName(dbClassName);
					con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
					
				}

			} catch (Exception ex) {
				con = null;
				ex.printStackTrace();
			}
			return con;
		}	
		
		
		public static Connection getConnectionSP() {
			try {
				// dbURL = "jdbc:sqlserver://" + ObjectHelper.dburl + ":1433";

				if (con != null) {
					con.close();
				}
				con = null;
				if (con == null) {

					Class.forName(dbClassName);
					con = DriverManager.getConnection(dbURLSP, dbUserName, dbPassword);
					
				}

			} catch (Exception ex) {
				con = null;
				ex.printStackTrace();
			}
			return con;
		}	

	public static void main(String[] args) {

		System.out.println("State :" + DBAccess_LARS.getConnection());

		System.out.println("Record Present : " + DAO.checkrecordcreated(
				"Select *  FROM [BCTest_Rover].[dbo].[Doctor] where replace(CONVERT( date, Last_Updated, 105), '.' '-') ="
						+ CommonFunctions.getDateNoname(-22)));

	}

}
