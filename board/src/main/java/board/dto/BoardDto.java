package board.dto;

import lombok.Data;

// T_BOARD 테이블에 데이터를 담는 객체 
// 해당 객체의 필드는 해당 테이블에 컬럼과 유사

// 모든 필드의 getter, setter, toString, hashCode, equals 메서드를 자동으로 생성 
// final로 선언된 필드에는 setter 메서드를 생성하지 않음  
@Data					
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDateTime;
	private String updaterId;
	private String updatedDateTime;
}
