package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class iVendaDAO {
	public boolean insIVenda(iVenda iVenda){
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryInserir = "INSERT INTO ivenda VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			ppStm.setInt(1, iVenda.getVenda());
			ppStm.setInt(2, iVenda.getIvenda());
			ppStm.setString(3, iVenda.getMaterial());
			ppStm.setInt(4, iVenda.getQtd());
			ppStm.setString(5, Float.toString(iVenda.getP_unit()));
					
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updIVenda(iVenda iVenda){
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryUpdate = "UPDATE ivenda SET material = ?, qtd = ?, p_unit = ? WHERE venda = ? and ivenda = ?";
			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);
			ppStm.setString(1, iVenda.getMaterial());
			ppStm.setInt(2, iVenda.getQtd());
			ppStm.setFloat(3, iVenda.getP_unit());
			ppStm.setInt(4, iVenda.getVenda());
			ppStm.setInt(5, iVenda.getIvenda());
			
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
