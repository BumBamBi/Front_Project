package com.ssafy.model.test;

import com.ssafy.model.dao.StarredLocationDAO;

public class StarredLocationTest {

	public static void main(String[] args) {
		StarredLocationDAO starredLocationDAO = new StarredLocationDAO();
		System.out.println("삽입: " + starredLocationDAO.insertStarredLocation(100, "jaewanhwang"));
		// System.out.println("조회: " + starredLocationDAO.selectStarredLocations("jaewanhwang"));
		// System.out.println("삭제: " + starredLocationDAO.deleteStarredLocations(3));
	}

}
