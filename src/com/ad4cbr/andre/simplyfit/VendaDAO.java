package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VendaDAO {
	public ArrayList<Venda> vendasPorPrev (String prevFrom, String prevTo) {
		final SimpleDateFormat sdForm = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<Venda> ret = new ArrayList<Venda>();
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qSel = "SELECT * FROM venda WHERE d_prev >= ? and d_prev <= ?";
			
			PreparedStatement ppStm = conn.prepareStatement(qSel);
			ppStm.setString(1, prevFrom);
			ppStm.setString(2, prevTo);

			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()) {
				Venda venda = new Venda();
				
				venda.setVenda(Integer.parseInt(rSet.getString(1)));
				venda.setCliente(rSet.getString(2));
				venda.setD_vend(sdForm.parse(rSet.getString(3)));
				venda.setD_prev(sdForm.parse(rSet.getString(4)));
				venda.setD_prod(sdForm.parse(rSet.getString(5)));
				venda.setD_sep(sdForm.parse(rSet.getString(6)));		
				venda.setD_ent(sdForm.parse(rSet.getString(7)));
				venda.setObs(rSet.getString(8));
				
				ret.add(venda);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<iVenda> itensPorVenda (Integer venda) {		
		ArrayList<iVenda> ret = new ArrayList<iVenda>();
		try {
			Connection conn = ConectaMySql.obtemConexao();
			
			String qSel = "SELECT * FROM ivenda WHERE venda = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(qSel);
			ppStm.setInt(1, venda);

			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()) {
				iVenda itens = new iVenda();
				
				itens.setVenda(Integer.parseInt(rSet.getString(1)));
				itens.setIvenda(Integer.parseInt(rSet.getString(2)));
				itens.setMaterial(rSet.getString(3));
				itens.setQtd(Integer.parseInt(rSet.getString(4)));
				itens.setP_unit(Float.parseFloat(rSet.getString(5)));
				
				ret.add(itens);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}	
	
	public int insVenda(Venda venda){
		int ret = 0;
		try {
			final SimpleDateFormat sdForm = new SimpleDateFormat("yyyy-MM-dd");
			String dVenda;
			String dPrev;
			String dProd;
			String dSep;
			String dEnt;
		
			try {
				dVenda = sdForm.format(venda.getD_vend());
			} catch (Exception e) {
				dVenda = "1900-01-01";
			}
			try {
				dPrev = sdForm.format(venda.getD_prev());
			} catch (Exception e) {
				dPrev = "1900-01-01";
			}
			try {
				dProd = sdForm.format(venda.getD_prod());
			} catch (Exception e) {
				dProd = "1900-01-01";
			}
			try {
				dSep = sdForm.format(venda.getD_sep());
			} catch (Exception e) {
				dSep = "1900-01-01";
			}
			try {
				dEnt = sdForm.format(venda.getD_ent());
			} catch (Exception e) {
				dEnt = "1900-01-01";
			}
			
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryInserir = "INSERT INTO venda VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ppStm = conn.prepareStatement(queryInserir, PreparedStatement.RETURN_GENERATED_KEYS);
			ppStm.setString(1, venda.getCliente());
			ppStm.setString(2, dVenda);
			ppStm.setString(3, dPrev);
			ppStm.setString(4, dProd);
			ppStm.setString(5, dSep);
			ppStm.setString(6, dEnt);
			ppStm.setString(7, venda.getObs());
						
			ret = ppStm.executeUpdate();
			
			ResultSet result = ppStm.getGeneratedKeys();
	        if (result.next()){
	        	ret = result.getInt(1);
	        }
	        result.close();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean updVenda(Venda venda){
		try {
			final SimpleDateFormat sdForm = new SimpleDateFormat("yyyy-MM-dd");
			String dVenda;
			String dPrev;
			String dProd;
			String dSep;
			String dEnt;
		
			try {
				dVenda = sdForm.format(venda.getD_vend());
			} catch (Exception e) {
				dVenda = "1900-01-01";
			}
			try {
				dPrev = sdForm.format(venda.getD_prev());
			} catch (Exception e) {
				dPrev = "1900-01-01";
			}
			try {
				dProd = sdForm.format(venda.getD_prod());
			} catch (Exception e) {
				dProd = "1900-01-01";
			}
			try {
				dSep = sdForm.format(venda.getD_sep());
			} catch (Exception e) {
				dSep = "1900-01-01";
			}
			try {
				dEnt = sdForm.format(venda.getD_ent());
			} catch (Exception e) {
				dEnt = "1900-01-01";
			}
			
			Connection conn = ConectaMySql.obtemConexao();
			
			String queryUpdate = "UPDATE venda SET cliente = ?, d_prev = ?, d_prod = ?, d_sep = ?, d_ent = ?, obs = ? WHERE venda = ?";
			PreparedStatement ppStm = conn.prepareStatement(queryUpdate);
			ppStm.setString(1, venda.getCliente());
			ppStm.setString(2, dPrev);
			ppStm.setString(3, dProd);
			ppStm.setString(4, dSep);
			ppStm.setString(5, dEnt);
			ppStm.setString(6, venda.getObs());
			ppStm.setInt(7, venda.getVenda());
						
			ppStm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
