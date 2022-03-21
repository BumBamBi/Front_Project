package com.ssafy.model.test.boardDAOTest;

import com.ssafy.model.dao.*;
import com.ssafy.model.dto.*;

public class temp {

	public static void main(String[] args) {

        boardDAO dao = new boardDAO();
		System.out.println("삽입 : " + dao.insertBoard(new Board(1, "제목", "작성자", 0, "내용", "날짜")));	// PK 중복값 대입 안됨
		// System.out.println("조회 : " + dao.selectDept(70));
	}

}
