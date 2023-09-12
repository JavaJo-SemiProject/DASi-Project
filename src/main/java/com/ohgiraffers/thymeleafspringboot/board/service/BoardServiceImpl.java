package com.ohgiraffers.thymeleafspringboot.board.service;

import com.ohgiraffers.thymeleafspringboot.board.dao.BoardMapper;
import com.ohgiraffers.thymeleafspringboot.board.dto.AttachmentDTO;
import com.ohgiraffers.thymeleafspringboot.board.dto.BoardDTO;
import com.ohgiraffers.thymeleafspringboot.board.dto.ReplyDTO;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.BoardRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRemoveException;
import com.ohgiraffers.thymeleafspringboot.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.thymeleafspringboot.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {
        this.mapper = mapper;
    }

    /* 해당 게시글 전체 갯수 조회용 메소드 */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    /* 게시글 전체 조회용 메소드 */
    @Override
    public List<BoardDTO> selectBoardList(SelectCriteria selectCriteria) {

        List<BoardDTO> boardList = mapper.selectBoardList(selectCriteria);

        return boardList;
    }

    /* 게시글 상세 페이지 조회용 메소드 */
    @Override
    @Transactional
    public BoardDTO selectBoardDetail(Long no) {
        BoardDTO boardDetail = null;

        int result = mapper.incrementBoardCount(no);

        if(result > 0){
            boardDetail = mapper.selectBoardDetail(no);
        }

        return boardDetail;
    }

    /* 해당 게시글의 전체 댓글 조회용 메소드 */

    @Override
    public List<ReplyDTO> selectAllReplyList(Long boardNo) {
        List<ReplyDTO> replyList = null;

        replyList = mapper.selectReplyList(boardNo);

        return replyList;
    }


    /* 댓글 등록용 메소드 */
    @Override
    @Transactional
    public List<ReplyDTO> registReply(ReplyDTO registReply) throws ReplyRegistException {
        List<ReplyDTO> replyList = null;

        int result = mapper.insertReply(registReply);

        if(result > 0) {
            replyList = mapper.selectReplyList(registReply.getRefBoardNo());
        } else {
            throw new ReplyRegistException("댓글 등록에 실패하셨습니다.");
        }

        return replyList;
    }

    /* 댓글 삭제용 메소드 */
    @Override
    @Transactional
    public List<ReplyDTO> removeReply(ReplyDTO removeReply) throws ReplyRemoveException {
        List<ReplyDTO> replyList = null;

        int result = mapper.deleteReply(removeReply.getNo());

        if(result > 0) {
            replyList = mapper.selectReplyList(removeReply.getRefBoardNo());
        } else {
            throw new ReplyRemoveException("댓글 삭제에 실패하셨습니다.");
        }

        return replyList;
    }

    /* 게시글 등록용 메소드 */
    @Override
    @Transactional
    public void registBoard(BoardDTO board) throws BoardRegistException {
        int result = mapper.insertBoard(board);

        if(!(result > 0)) {
            throw new BoardRegistException("게시글 등록에 실패하셨습니다.");
        }
    }

    /* 전체 썸네일 게시글 조회용 메소드 */
    @Override
    public List<BoardDTO> selectAllThumbnailList() {
        List<BoardDTO> thumbnailList = mapper.selectAllThumbnailList();

        return thumbnailList;
    }

    /* 썸네일 게시글 등록용 메소드 */
    @Override
    @Transactional
    public void registThumbnail(BoardDTO thumbnail) throws ThumbnailRegistException {

        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
        int boardResult = mapper.insertThumbnailContent(thumbnail);

        /* Attachment 리스트를 불러온다. */
        List<AttachmentDTO> attachmentList = thumbnail.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for(int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setRefBoardNo(thumbnail.getNo());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for(int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.insertAttachment(attachmentList.get(i));
        }

        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if(!(boardResult > 0 && attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }

    /* 게시글 상세 페이지 조회용 메소드 */
    @Override
    public BoardDTO selectThumbnailDetail(Long no) {
        BoardDTO thumbnailDetail = null;

        int result = mapper.incrementBoardCount(no);

        if(result > 0) {
            thumbnailDetail = mapper.selectThumbnailDetail(no);
        }

        return thumbnailDetail;
    }
}
