package ifs.repository;

import ifs.domain.Destination1;
import ifs.domain.Destination2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;

@org.springframework.stereotype.Repository
public class DestinationRepository {
	@Autowired
	DataSource dataSource;

	
	private DatabaseMetaData getDatabaseMetaData() throws SQLException
	{
		Connection con;
		DatabaseMetaData metadata=null;
			con = (Connection) dataSource.getConnection();
			metadata = (DatabaseMetaData) con.getMetaData();
		return metadata;
	}
	
	public List<Map<String, Object>> getDestinationTableNameRepository() {
		String table[] = { "TABLE" };
		ArrayList tables = null;
		try {
			DatabaseMetaData metadata =getDatabaseMetaData();

			ResultSet rs = null;
			rs = metadata.getTables(null, null, null, table);
			tables = new ArrayList();
			while (rs.next()) {
				if (rs.getString("TABLE_NAME").startsWith("d"))
					tables.add(rs.getString("TABLE_NAME"));
			}
			return tables;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tables;

	}

	public List<String> getDestinationColumnNameRepository(String tablename) {
		ArrayList<String> columnNames = new ArrayList<String>();

		try {
			DatabaseMetaData metadata = getDatabaseMetaData();
			ResultSet rs = null;

			rs = metadata.getColumns(null, null, tablename, null);
			while (rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
				columnNames.add(rs.getString("COLUMN_NAME"));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return columnNames;

	}

}
