package boardClone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boardClone.dto.BoardDto;
import boardClone.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//		상세 정보 조회
//	@RequestMapping("board/openBoardDetail.do")
//	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
//		ModelAndView mv = new ModelAndView("/board/boardDetail");
//		
//		BoardDto board = boardService.selectBoardDetail(boardIdx);
//		mv.addObject("board", board);
//		
//		return mv;
//	}
	
	
	//		글쓰기 페이지에 대한 요청 처리
	@RequestMapping("/boardClone/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	// 글 저장 처리에 대한 요청 처리
	@RequestMapping("/boardClone/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/boardClone/openBoardList.do";
	}
	
	@RequestMapping("/boardClone/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
