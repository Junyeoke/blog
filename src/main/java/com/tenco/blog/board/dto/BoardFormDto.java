package com.tenco.blog.board.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @packageName : com.tenco.blog.board.dto
 * @fileName : BoardFormDto.java
 * @author : GGG
 * @date : 2024.02.08
 * @description : ===========================================================
 *              DATE AUTHOR NOTE
 *              -----------------------------------------------------------
 *              2024.02.08 GGG 최초 생성
 */

@Data
public class BoardFormDto {

	private Integer id;

	private String title;

	private String content;
	private String author;

}
