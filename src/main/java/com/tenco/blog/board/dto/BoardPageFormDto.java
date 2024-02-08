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
	private Integer pageSize;

	public Integer getOffset() {
		return (page - 1) * pageSize;
	}
	

    // 추가된 pageSize의 getter 메서드
    public Integer getPageSize() {
        return pageSize;
    }
}
