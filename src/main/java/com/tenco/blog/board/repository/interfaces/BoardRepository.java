package com.tenco.blog.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.tenco.blog.board.dto.BoardFormDto;
import com.tenco.blog.board.dto.BoardPageFormDto;
import com.tenco.blog.board.repository.entity.Board;

/**
 * @packageName : com.tenco.blog.board.repository.interfaces
 * @fileName : BoardRepository.java
 * @author : GGG
 * @date : 2024.02.08
 * @description : ===========================================================
 *              DATE AUTHOR NOTE
 *              -----------------------------------------------------------
 *              2024.02.08 GGG 최초 생성
 */

@Mapper
public interface BoardRepository {

	// insert
	public int insert(BoardFormDto boardFormDto);

	// select
	public List<Board> selectByBoardDto(BoardPageFormDto BoardPageFormDto);

	// select
	public Board selectById(Integer id);

	// update
	public int updateByBoardDto(BoardFormDto boardFormDto);

	// delete
	public int deleteById(Integer id);
	

	
	
	

}
