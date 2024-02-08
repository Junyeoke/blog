package com.tenco.blog.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tenco.blog.board.dto.BoardFormDto;
import com.tenco.blog.board.dto.BoardPageFormDto;
import com.tenco.blog.board.repository.entity.Board;
import com.tenco.blog.board.repository.interfaces.BoardRepository;

/**
 * @packageName : com.tenco.blog.board.service
 * @fileName : BoardService.java
 * @author : GGG
 * @date : 2024.02.08
 * @description : ===========================================================
 *              DATE AUTHOR NOTE
 *              -----------------------------------------------------------
 *              2024.02.08 GGG 최초 생성
 */

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	// 게시글 작성
	public void readBoard(@Validated BoardFormDto boardFormDto) {
		int resultRowCount = boardRepository.insert(boardFormDto);
		if (resultRowCount != 1) {
			System.out.println("게시글 작성오류");
		}
	}

	// 게시글 조회
	public List<Board> readBoard(BoardPageFormDto boardPageFormDto) {
		List<Board> boardList = boardRepository.selectByBoardDto(boardPageFormDto);
		return boardList;

	}

	// 게시글 상세조회
	public Board readByIdBoard(Integer id) {
		Board board = boardRepository.selectById(id);
		return board;
	}

	// 게시글 수정
	public int updateBoard(BoardFormDto boardFormDto) {
		int resultRowCount = boardRepository.updateByBoardDto(boardFormDto);
		if (resultRowCount != 1) {
			System.out.println("게시글 수정 오류");
		}

		return resultRowCount;
	}

	// 게시글 삭제
	public int deleteBoard(Integer id) {
		int resultRowCount = boardRepository.deleteById(id);
		return resultRowCount;
	}

	// 페이징된 게시글 조회
	public List<Board> readBoardWithPaging(BoardPageFormDto boardPageFormDto) {
		List<Board> boardList = boardRepository.selectWithPagingAndOffset(boardPageFormDto);
		return boardList;
	}

	// 게시글의 총 개수를 반환하는 메서드
	public int getTotalBoardCount() {
		return boardRepository.getTotalBoardCount();
	}

}
