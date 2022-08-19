package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//	글쓰기 페이지에 대한 요청 처리
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return "/board/boardWrite";
	}
	
	//	글 저장 처리에 대한 요청 처리
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
