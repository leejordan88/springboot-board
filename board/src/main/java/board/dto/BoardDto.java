package board.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "BoardDto : 게시글 내용", description = "게시글 내용")
@Data
public class BoardDto {
	@ApiModelProperty("게시글 번호")
	private int boardIdx;
	@ApiModelProperty("게시글 제목")
	private String title;
	@ApiModelProperty("게시글 내용")
	private String contents;
	@ApiModelProperty("게시글 조회수")
	private int hitCnt;
	@ApiModelProperty("작성자 아이디")
	private String creatorId;
	@ApiModelProperty("작성시간")
	private String createdDatetime;
	@ApiModelProperty("수정자 아이디")
	private String updaterId;
	@ApiModelProperty("수정시간")
	private String updateDateTime;
	@ApiModelProperty("첨부파일 목록")
	private List<BoardFileDto> fileList;
}
