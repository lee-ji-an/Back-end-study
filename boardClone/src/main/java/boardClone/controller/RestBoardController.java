package boardClone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import boardClone.dto.BoardDto;
import boardClone.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestBoardController {
	//REST = 주소(URL) + 요청방식(method) -> 서비스 구현
	
	//private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;
	
	//게시판 수정 처리
//	@RequestMapping("/boardClone/updateBoard.do")
	@RequestMapping(value="/boardClone/{boardIdx})", method=RequestMethod.PUT)
	public String updateBoard(BoardDto boardDto) throws Exception {
		boardService.updateBoard(boardDto);
		return "redirect:/boardClone";
	}
	
	//게시판 삭제 처리
//	@RequestMapping("/boardClone/deleteBoard.do")
	@RequestMapping(value="/boardClone/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/boardClone";
	}
	
	
	//		상세 정보 조회
//	@RequestMapping("/boardClone/openBoardDetail.do")
	@RequestMapping(value="/boardClone/(boardIdx)", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		
		ModelAndView mv = new ModelAndView("/board/restboardDetail");
		//화면에 뿌려주기 위해서 html에서 쓸 수 있도록 mv에 추가
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
					//"변수이름", 변수에 넣을 데이터 값
		return mv;
	}
	
	//		글쓰기 페이지에 대한 요청 처리, 게시판 작성 화면
//	@RequestMapping("/boardClone/openBoardWrite.do")
	@RequestMapping(value="/boardClone/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/board/restBoardWrite";
	}
	
	// 글 저장 처리에 대한 요청 처리, 게시판 작성
//	@RequestMapping("/boardClone/insertBoard.do")
	@RequestMapping(value="/boardClone/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/boardClone";
	}
	
	//게시판 목록
//	@RequestMapping("/boardClone/openBoardList.do")
	@GetMapping("/boardClone")
	public ModelAndView openBoardList() throws Exception {
		log.trace("openBoardList() is called by trace");
		log.debug("openBoardList() is called by debug");
		log.info("openBoardList() is called by info");
		
		ModelAndView mv = new ModelAndView("/board/restboardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
