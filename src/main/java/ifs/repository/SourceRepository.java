package ifs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;

@Repository
public class SourceRepository {

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
	
	
	
	public List<Map<String, Object>> getSourceTableNameRepository() {
		String table[] = { "TABLE" };
		ArrayList tables = null;
		try {
			DatabaseMetaData metadata = getDatabaseMetaData();
			ResultSet rs = null;
			rs = metadata.getTables(null, null, null, table);
			tables = new ArrayList();
			while (rs.next()) {
				if (rs.getString("TABLE_NAME").startsWith("s"))
					tables.add(rs.getString("TABLE_NAME"));
			}
			return tables;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	public List<String> getSourceColumnNameRepository(String tablename) {
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