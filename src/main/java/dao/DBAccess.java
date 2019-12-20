package dao;

import java.sql.Connection;
import java.time.Duration;
import java.time.Instant;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBAccess {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;

	public volatile static Connection con;

	static String dbName = "QA4_Rover";
	static String dbUserName = "svc-db-ops-portal";
	static String dbPassword = "zF27HdQ4AN";
	static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dbURL = "jdbc:sqlserver://10.1.1.129:1433";

	// public static Connection getConnection() {
	// try {
	// // dbURL = "jdbc:sqlserver://" + ObjectHelper.dburl + ":1433";
	//
	// if (con != null) {
	// con.close();
	// }
	// con = null;
	// if (con == null) {
	//
	// Class.forName(dbClassName);
	// con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	// }
	//
	// } catch (Exception ex) {
	// con = null;
	// ex.printStackTrace();
	// }
	// return con;
	// }

	public static void main(String[] args) {
		int n = 10, min = 0, max = 0, avg = 0;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			Instant start = Instant.now();

			// System.out.println("State :" + DBAccess.getConnection());

			// System.out.println("Record Present : " + DAO.checkrecordcreated("Select *
			// FROM [BCTest_Rover].[dbo].[Doctor]"));

			DAO.checkrecordcreated("Select * FROM [BCTest_Rover].[dbo].[Doctor]");

			Instant finish = Instant.now();
			a[i] = Integer.parseInt(Long.toString(Duration.between(start, finish).toMillis()));
			// System.out.println(Duration.between(start, finish).toMillis()); // in millis
		}

		// max number
		max = a[0];
		for (int i = 0; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		// max number
		min = a[0];
		for (int i = 0; i < n; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		// avg number
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += a[i];
		}
		avg = (total / n);
		System.out.println("Max :" + max + "\nMin :" + min + "\nAvg :" + avg);
	}

	static {
		config.setJdbcUrl(dbURL);
		config.setUsername(dbUserName);
		config.setPassword(dbPassword);
		config.setConnectionTimeout(120000);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	public static Connection getConnection() {
		try {

			if (con == null || con.isClosed()) {
				Class.forName(dbClassName);
				con = ds.getConnection();
			}

		} catch (Exception ex) {
			con = null;
			ex.printStackTrace();
		}
		return con;
	}
}
