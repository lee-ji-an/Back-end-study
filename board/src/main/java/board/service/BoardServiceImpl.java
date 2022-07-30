package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.common.FileUtils;
import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public BoardDto selectBoardDetail(int boardIdx) {
		boardMapper.updateHitCount(boardIdx);
		
		BoardDto boardDto = boardMapper.selectBoardDetail(boardIdx);
		List<BoardFileDto> boardFileInfo = boardMapper.selectBoardFileList(boardIdx);
		boardDto.setFileInfoList(boardFileInfo);
		
		return boardDto;
	}
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board, MultipartHttpServletRequest request) throws Exception {
// 게시글 정보를 등록 -> 등록하면 게시판 아이디를 반환		
		boardMapper.insertBoard(board);
		
		// 첨부 파일을 저장하고 첨부 파일 정보를 반환
		List<BoardFileDto> fileInfoList = fileUtils.parseFileInfo(board.getBoardIdx(), request);
		// 첨부 파일 정보를 저장
		if (!CollectionUtils.isEmpty(fileInfoList)) {
			boardMapper.insertBoardFileList(fileInfoList);
		}
	}



	@Override
	public void updateBoard(BoardDto boardDto) {
		boardMapper.updateBoard(boardDto);
	}


	@Override
	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);
	}

	@Override
	public BoardFileDto selectBoardFileInfo(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInfo(idx, boardIdx);
	}


}
