package boardClone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boardClone.dto.BoardDto;
import boardClone.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	//private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;
	
	//수정 처리
	@RequestMapping("/boardClone/updateBoard.do")
	public String updateBoard(BoardDto boardDto) throws Exception {
		boardService.updateBoard(boardDto);
		return "redirect:/boardClone/openBoardList.do";
	}
	
	//삭제 처리
	@RequestMapping("/boardClone/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/boardClone/openBoardList.do";
	}
	
	
	//		상세 정보 조회
	@RequestMapping("/boardClone/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		//화면에 뿌려주기 위해서 html에서 쓸 수 있도록 mv에 추가
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
					//"변수이름", 변수에 넣을 데이터 값
		return mv;
	}
	
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
		log.trace("openBoardList() is called by trace");
		log.debug("openBoardList() is called by debug");
		log.info("openBoardList() is called by info");
		
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
