package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.*;

public class boardDAO {

	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC";
	private static final String USER ="ssafy";
	private static final String PASSWORD ="ssafy";
	
	static {
		// 1. JDBC Driver 등록
        // 한번만 수행해도 되니 static쪽으로 빼둠
        // 에러가 발생할 수 있으니 예외처리 해야함
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}

	// Insert
	public boolean insertBoard(Board board) {
		// DB와 연결하기 위한 Connection 객체 생성
		Connection conn = null;
		
		// DB와 통신하기 위한 전용통로 PreparedStatement 객체 생성
		PreparedStatement stmt = null;

		// ?라는 와일드 카드를 적용(반복되는 구문을 손쉽게 처리 가능)
		String sql = "insert into board values(?,?,?,?,?,?)";
		try {
			// DB와 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 연결 통로 생성(PreparedStatement이므로 sql 삽입해야함)
			stmt = conn.prepareStatement(sql);

			// 연결해뒀으니 (순서, 값) 으로 값 대입
			stmt.setInt(1, board.getNo());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getAuthor());
			stmt.setInt(4, board.getHits());
			stmt.setString(5, board.getBody());
			stmt.setString(6, board.getDate());

			// SQL을 넣을 필요 없음(stmt에서 이미 넣었음)
			int rowCount = stmt.executeUpdate();
			// 제대로 되면 true 반환
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	// Select
	public Board selectBoard(int memberNo) {
		// 연결을 위한 객체들
		Connection conn = null;
		PreparedStatement stmt = null;

		// 수행 결과를 저장할 ResultSet객체
		ResultSet rs = null;

		// ?를 이용한 select SQL
		String sql = "select no, title, author, hits, body, date from board where no = ?";
		try {
			// 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(sql);
			// ? 에 값 대입
			stmt.setInt(1, memberNo);

			// 결과를 ResultSet객체에 저장
			rs = stmt.executeQuery();

			// Select의 결과를 다음부터 읽어와야함(결과가 없을 수 도 있기 때문에 이렇게 설정됨)
			if (rs.next()) {
				// 속성의 순서로도, 이름으로도 값을 가져올 수 있음
				return new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	// Delete
	public void deleteBoard(String no) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "delete from board \n";
		sql += "where no = ?";
			
		try {
			// DB와 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 연결 통로 생성(PreparedStatement이므로 sql 삽입해야함)
			stmt = conn.prepareStatement(sql);
			
			//값 세팅
			stmt.setString(1, no);
			
			//preparestatement 실행
			int rowCnt = stmt.executeUpdate();
			System.out.println(rowCnt + "개 삭제성공!");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	} 
}
