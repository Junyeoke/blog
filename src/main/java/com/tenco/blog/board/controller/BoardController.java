package com.tenco.blog.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tenco.blog.board.dto.BoardFormDto;
import com.tenco.blog.board.dto.BoardPageFormDto;
import com.tenco.blog.board.repository.entity.Board;
import com.tenco.blog.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String board(Model model, @RequestParam(defaultValue = "select") String crud,
	                    @RequestParam(defaultValue = "1") int page,
	                    @RequestParam(defaultValue = "10") int size) {
	    model.addAttribute("crud", crud);

	    // 페이지네이션 정보를 포함한 DTO 생성
	    BoardPageFormDto boardPageFormDto = new BoardPageFormDto();
	    boardPageFormDto.setPage(page);
	    boardPageFormDto.setPageSize(size);

	    // 페이지네이션 정보를 사용하여 게시글 목록 조회
	    List<Board> boardList = boardService.readBoardWithPaging(boardPageFormDto);

	    // 페이지 정보 계산
	    int totalPages = (int) Math.ceil(boardService.getTotalBoardCount() / (double) size);

	    model.addAttribute("boardList", boardList);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("pageSize", size);

	    return "/layout/main";
	}




	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		Board board = boardService.readByIdBoard(id); // 해당 ID의 게시글을 가져옴
		model.addAttribute("board", board); // 모델에 게시글 정보를 담아서 화면으로 전달
		return "board/updateForm";
	}

	@PostMapping("/board/{id}/update")
	public String update(@PathVariable int id, @ModelAttribute BoardFormDto boardFormDto) {
		boardFormDto.setId(id); // 수정할 게시글의 ID 설정

		boardService.updateBoard(boardFormDto); // 게시글 업데이트 수행

		return "redirect:/";
	}

	@PostMapping("/board/save")
	public String save(@Validated BoardFormDto boardFormDto) {
		boardService.readBoard(boardFormDto); // 저장 기능을 하는 메서드 호출
		return "redirect:/"; // 저장 후에는 홈 페이지로 리다이렉션
	}

	@PostMapping("/board/{id}/delete")
	public String delete(@PathVariable int id) {
		boardService.deleteBoard(id);
		return "redirect:/";
	}

}
