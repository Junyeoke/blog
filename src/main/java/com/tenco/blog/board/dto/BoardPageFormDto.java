package com.tenco.blog.board.dto;

import lombok.Data;

/**
 * @packageName : com.tenco.blog.board.dto
 * @fileName : BoardPageFormDto.java
 * @author : GGG
 * @date : 2024.02.08
 * @description : ===========================================================
 *              DATE AUTHOR NOTE
 *              -----------------------------------------------------------
 *              2024.02.08 GGG 최초 생성
 */

@Data
public class BoardPageFormDto {

	private Integer page;
	private Integer size;
	private Integer offset;
	
	// 기본 생성자
    public BoardPageFormDto() {}

    // 생성자
    public BoardPageFormDto(Integer page, Integer size) {
        this.page = page;
        this.size = size;
        this.offset = (page - 1) * size; // 페이지 번호와 페이지당 항목 수를 이용하여 오프셋 계산
    }

}
