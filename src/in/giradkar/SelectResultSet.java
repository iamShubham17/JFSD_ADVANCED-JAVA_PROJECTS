package in.giradkar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectResultSet {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";

	private static final String DB_UNAME = "root";

	private static final String DB_PWD = "Shubham@1234";

	private static final String SELECT_SQL = "SELECT * FROM BOOKS";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		rs.absolute(2);

		rs.updateDouble(3, 8500.00);
		rs.updateRow();

		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getDouble(3));

		rs.previous();

		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getDouble(3));

		con.close();

	}

}
