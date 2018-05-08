package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialDAO {
	public ArrayList<Material> todosMat (){
		ArrayList<Material> ret = new ArrayList<Material>();
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qSel = "SELECT * FROM material";
			
			PreparedStatement ppStm = conn.prepareStatement(qSel);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()) {
				Material mat = new Material();
				
				mat.setMaterial(rSet.getString(1));
				mat.setDesc(rSet.getString(2));
				mat.setTipo(rSet.getString(3));
				mat.setP_unit(rSet.getFloat(4));
				
				ret.add(mat);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public ArrayList<Material> todosProd(){
		final String PROD = "PRODUTO";
		ArrayList<Material> ret = new ArrayList<Material>();
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qSel = "SELECT * FROM material WHERE tipo = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(qSel);
			ppStm.setString(1, PROD);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()) {
				Material mat = new Material();
				
				mat.setMaterial(rSet.getString(1));
				mat.setDesc(rSet.getString(2));
				mat.setTipo(rSet.getString(3));
				mat.setP_unit(rSet.getFloat(4));
				
				ret.add(mat);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
