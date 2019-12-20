package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class DAO {

	public static Connection con;
	public static Statement st;
	public static ResultSet rs;
	public static PreparedStatement ps;

	public static boolean checkrecordcreated(String sql) {
		boolean response = false;
		try {
			con = DBAccess.getConnection();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				response = true;
			}

			rs.close();
			st.close();
			// con.close();

		} catch (Exception e) {
			e.printStackTrace();
			response = false;
		}

		return response;
	}

	public static ArrayList<String> getRecords(String sql) {

		ArrayList<String> datalist = new ArrayList<String>();
		try {

			con = DBAccess.getConnection();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				datalist.add(rs.getString(1));
			}

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			datalist = null;
		}

		return datalist;
	}

	/* when the particular columnNumber is known */
	public static ArrayList<String> getRecords(String sql, int columnNumber) {

		ArrayList<String> datalist = new ArrayList<String>();
		try {

			con = DBAccess.getConnection();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				datalist.add(rs.getString(columnNumber));
			}

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			datalist = null;
		}

		return datalist;
	}

	public static String getSingleRecord(String sql) {

		String data = null;
		try {

			con = DBAccess.getConnection();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				data = rs.getString(1);
			}

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			data = null;
		}

		return data;
	}

	public static boolean updateTable(String sql) {
		boolean response = false;
		try {

			con = DBAccess.getConnection();

			ps = con.prepareStatement(sql);
			ps.executeUpdate();

			response = true;

			ps.close();
			con.close();
		} catch (Exception e) {

		}

		return response;
	}

	public static void executeStoredProcedure(String spname) {

		try {

			con = DBAccess_LARS.getConnection();
			CallableStatement cs = null;

			cs = con.prepareCall(spname);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(1, 1);
			cs.execute();

			rs = cs.getResultSet();

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		executeStoredProcedure("test");
	}
}
