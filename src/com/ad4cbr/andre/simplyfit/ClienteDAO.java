package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {
	public ArrayList<Cliente> todosClientes () {
		ArrayList<Cliente> ret = new ArrayList<Cliente>();
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qSel = "SELECT * FROM cliente";
			
			PreparedStatement ppStm = conn.prepareStatement(qSel);
			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()) {
				Cliente cli = new Cliente();
				
				cli.setCliente(rSet.getString(1));
				cli.setNome(rSet.getString(2));
				cli.setTel(rSet.getString(3));
				cli.setCel(rSet.getString(4));
				cli.setEmail(rSet.getString(5));
				cli.setObs(rSet.getString(6));
				
				ret.add(cli);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean inserirCliente (Cliente cli) {
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qIns = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(qIns);
			ppStm.setString(1, cli.getCliente());
			ppStm.setString(2, cli.getNome());
			ppStm.setString(3, cli.getTel());
			ppStm.setString(4, cli.getCel());
			ppStm.setString(5, cli.getEmail());
			ppStm.setString(6, cli.getObs());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean alterarCliente (Cliente cli) {
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryAlterar = "UPDATE cliente SET nome = ?, tel = ?, cel = ?, email = ?, obs = ? WHERE cliente = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryAlterar);
			ppStm.setString(1, cli.getNome());
			ppStm.setString(2, cli.getTel());
			ppStm.setString(3, cli.getCel());
			ppStm.setString(4, cli.getEmail());
			ppStm.setString(5, cli.getObs());
			ppStm.setString(6, cli.getCliente());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}