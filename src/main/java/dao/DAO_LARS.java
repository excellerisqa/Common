package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;

public class DAO_LARS {

	public static Connection con;
	public static Statement st;
	public static ResultSet rs;
	public static PreparedStatement ps;
	
	private static SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yy");
	private static SimpleDateFormat outSDF = new SimpleDateFormat("m/d/yyyy");
	private static SimpleDateFormat msSQLType = new SimpleDateFormat("yyyy-mm-dd");
	

	public static boolean checkrecordcreated(String sql) {
		boolean response = false;
		try {
			con = DBAccess_LARS.getConnection();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				response = true;
			}

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			response = false;
		}

		return response;
	}

	public static ArrayList<String> getRecords(String sql) {

		ArrayList<String> datalist = new ArrayList<String>();
		try {

			con = DBAccess_LARS.getConnection();

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
	
	
	public static ArrayList<String> getMultipleRecords(String sql) {

		ArrayList<String> datalist = new ArrayList<String>();
		try {

			con = DBAccess_LARS.getConnection();

			st = con.createStatement();
	//		rs = st.executeQuery(sql);
			
			
			boolean results = st.execute(sql);
			int rowsAffected = 0;
  /*         
            if (results) {
                System.out.println("call successful!");            	
            }
   */         
            while (results || rowsAffected != -1) {
                if (results) {
                    rs = st.getResultSet();
                    break;
                } else {
                    rowsAffected = st.getUpdateCount();
                }
                results = st.getMoreResults();
            }            
			
			

			if (rs != null) {
            	ResultSetMetaData metadata = rs.getMetaData();
            	int columnCount =  metadata.getColumnCount();
            	
            	String heading = "";
            	for (int i = 1; i <= columnCount; i++) {
            		heading +=metadata.getColumnName(i) + "|";
            	}
      			datalist.add(heading);
           	
            	while (rs.next()) {
            		String row = "";
            		for (int i = 1; i <= columnCount; i++) {
                        row += rs.getString(i) + "|";          
                    }
            		datalist.add(row);
    //        		System.out.print(datalist.toString());
            	}
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

			con = DBAccess_LARS.getConnection();

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

			con = DBAccess_LARS.getConnection();

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

			con = DBAccess_LARS.getConnection();

			ps = con.prepareStatement(sql);
			ps.executeUpdate();

			response = true;

			ps.close();
			con.close();
		} catch (Exception e) {

		}

		return response;
	}
	
	
	public static ArrayList<String> getRecordsSP(String spname, Map<String, Object> pmap) {

		ArrayList<String> datalist = new ArrayList<String>();
		
		try {

			Connection con = DBAccess_LARS.getConnectionSP();
            CallableStatement cs = null;
            
            System.out.println(spname);
            cs = (CallableStatement) con.prepareCall(spname,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            if(!pmap.isEmpty()) {
       
	            int index=1;
				for(String name:pmap.keySet()){
					Object value=pmap.get(name);
					if(value instanceof String){
						cs.setString(index,(String)value);									
					}else if(value instanceof Date){
						Date date=(Date)value;
						cs.setDate(index, new java.sql.Date(date.getTime()));
					}else if(value instanceof Integer){
						cs.setInt(index, (Integer)value);
					}else if(value instanceof Float){
						cs.setFloat(index, (Float)value);
					}else if(value instanceof Double){
						cs.setDouble(index, (Double)value);
					}else{
						cs.setObject(index, value);
					}
					index++;
				}
            }	

          
            boolean results = cs.execute();
            ResultSet rs = cs.getResultSet();
            
            int rowsAffected = 0;
            if (results) {
                System.out.println("call successful!");            	
            }
            
            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cs.getResultSet();
                    break;
                } else {
                    rowsAffected = cs.getUpdateCount();
                }
                results = cs.getMoreResults();
            }            
            
            if (rs != null) {
            	ResultSetMetaData metadata = rs.getMetaData();
            	int columnCount =  metadata.getColumnCount();

            	String heading = "";
            	for (int i = 1; i <= columnCount; i++) {
            		heading +=metadata.getColumnName(i) + "|";
            	}
      			datalist.add(heading);
           	
            	while (rs.next()) {
            		String row = "";
            		for (int i = 1; i <= columnCount; i++) {
                        row += rs.getString(i) + "|";          
                    }
            		datalist.add(row);
    //        		System.out.print(datalist.toString());
            	}
            }
            
           

            rs.close();
            cs.close();
            con.close();
            
   		} catch (Exception e) {
			e.printStackTrace();
			datalist = null;
		}

		return datalist;
	}
	
	public static ArrayList<Integer> randownumberList(int lowerlimit, int upperLimit){
		
		ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
		
		for (int i=lowerlimit; i<upperLimit; i++) {
			randomNumberList.add(i);
		}
		Collections.shuffle(randomNumberList);
			
		return randomNumberList;
	}
	
	/**
    * <p>
    * Computes sample size based on confidence of 85%, 90%, 95%, 97% or 99%
    * These confidence values correspond to these Z scores: 1.44, 1.65, 1.96, 2.17, 2.58
    *
    * E.g., sampleSize(650000,.95,.03) -> sample size of 1,066
    * </p>
    * @param p - overall population size
    * @param c - confidence - 85%, 90%, 95%, 97% or 99% - uses 95%  if anything else is sent.
    * @param e - Margin of error.
    * @return - the number of samples.
    */
    public static long sampleSize(long p, double c, double e) {
             double z = c==0.85?1.44:c==.90?1.65:c==.95?1.96:c==.97?2.17:c==.99?2.58:1.96;
             double n = 0.25*Math.pow((z/e), 2);
             double size = Math.ceil((p*n)/(n+p-1));
             return (long)(size+.5);
    }

}
