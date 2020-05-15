package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement st = null;
		
		try {
			conexao = DB.getConexao();
			st = conexao.prepareStatement("delete from department where id=?;");
			st.setInt(1, 2);
			int linhasAfetadas = st.executeUpdate();
			System.out.println("Linhas afetadas: "+linhasAfetadas);
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConexao();
		}
	}

}
