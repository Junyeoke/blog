package com.tenco.blog.board.repository.entity;

import lombok.Data;

/**
* @packageName     : com.tenco.blog.board.repository.entity
* @fileName        : Board.java
* @author          : GGG
* @date            : 2024.02.08
* @description     :
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2024.02.08            GGG       최초 생성
*/

@Data
public class Board {
	
	private Integer id;
	private String title;
	private String content;
	private String author;

}
