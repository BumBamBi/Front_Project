package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseDeal;


public class HouseDealDAO {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://127.0.0.1:3306/dbtest?serverTimezone=UTC";
	private static final String USER ="ssafy";
	private static final String PASSWORD = "ssafy";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertHouseDeal(HouseDeal houseDeal) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into housedeal(aptCode, dealAmount, dealYear, dealMonth, dealDay, area, floor, type, rentMoney) " + 
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,  houseDeal.getAptCode());
			stmt.setString(2,  houseDeal.getDealAmount());
			stmt.setInt(3,  houseDeal.getDealYear());
			stmt.setInt(4,  houseDeal.getDealMonth());
			stmt.setInt(5,  houseDeal.getDealDay());
			stmt.setString(6,  houseDeal.getArea());
			stmt.setString(7,  houseDeal.getFloor());
			stmt.setString(8,  houseDeal.getType());
			stmt.setString(9,  houseDeal.getRentMoney());

			int rowCount = stmt.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
	public List<HouseDeal> selectHouseDealsByDongCode(String dongCode) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select no, aptCode, dealAmount, dealYear, dealMonth, dealDay, area, floor, type, rentMoney " + 
				"from housedeal join houseinfo " + 
				"on housedeal.aptCode = houseinfo.aptCode " + 
				"where houseinfo.dongCode = ?;";
		List<HouseDeal> houseDeals = new ArrayList<HouseDeal>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dongCode);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				houseDeals.add(new HouseDeal(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return houseDeals;
	}
	
}
