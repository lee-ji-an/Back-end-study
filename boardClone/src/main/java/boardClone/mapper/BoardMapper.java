package boardClone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boardClone.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public List<BoardDto> selectBoardList() throws Exception;

	public void insertBoard(BoardDto board);

	public BoardDto selectBoardDetail(int boardIdx);

	public void updateHitCount(int boardIdx);



}
