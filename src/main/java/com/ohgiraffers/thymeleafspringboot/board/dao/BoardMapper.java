package com.ohgiraffers.thymeleafspringboot.board.dao;

import com.ohgiraffers.thymeleafspringboot.board.dto.AttachmentDTO;
import com.ohgiraffers.thymeleafspringboot.board.dto.BoardDTO;
import com.ohgiraffers.thymeleafspringboot.board.dto.ReplyDTO;
import com.ohgiraffers.thymeleafspringboot.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    int selectTotalCount(Map<String, String> searchMap);
    List<BoardDTO> selectBoardList(SelectCriteria selectCriteria);

    BoardDTO selectBoardDetail(Long no);

    List<ReplyDTO> selectReplyList(Long boardNo);

    int insertReply(ReplyDTO registReply);

    int deleteReply(Long no);

    int insertBoard(BoardDTO board);

    List<BoardDTO> selectAllThumbnailList();

    int insertThumbnailContent(BoardDTO thumbnail);

    int insertAttachment(AttachmentDTO attachmentDTO);

    int incrementBoardCount(Long no);

    BoardDTO selectThumbnailDetail(Long no);
}
