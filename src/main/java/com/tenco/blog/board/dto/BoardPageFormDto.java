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

	/* 현재 페이지, 디폴트 값은 1 */
	int pg = 1;

	/* 페이지 당 레코드 수, 디폴트 값은 5 */
	int sz = 5;

	/* 전체 레코드 수 */
	int recordCount;

	public String getQueryString() {
		return String.format("pg=%d&sz=%d", pg, sz);
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getSz() {
		return sz;
	}

	public void setSz(int sz) {
		this.sz = sz;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

}
