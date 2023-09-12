package com.ohgiraffers.thymeleafspringboot.notice.service;

import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRemoveException;
import com.ohgiraffers.thymeleafspringboot.notice.dao.NoticeMapper;
import com.ohgiraffers.thymeleafspringboot.notice.dto.NoticeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper mapper;

    public NoticeServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    /* 공지사항 전체 목록 조회용 메소드 */
    @Override
    public List<NoticeDTO> selectAllNoticeList() {

        List<NoticeDTO> noticeList = mapper.selectAllNoticeList();

        return noticeList;
    }

    /* 공지사항 등록용 메소드 */
    @Override
    @Transactional
    public void registNotice(NoticeDTO notice) throws NoticeRegistException {

        int result = mapper.insertNotice(notice);

        if(!(result > 0)) {
            throw new NoticeRegistException("공지사항 등록에 실패하셨습니다.");
        }
    }

    /* 공지사항 상세 페이지 조회용 메소드 */
    @Override
    public NoticeDTO selectNoticeDetail(Long no) {

        NoticeDTO noticeDetail = null;

        int result = mapper.incrementNoticeCount(no);

        if(result > 0) {
            noticeDetail = mapper.selectNoticeDetail(no);
        }

        return noticeDetail;
    }

    /* 공지사항 수정용 메소드 */
    @Override
    @Transactional
    public void modifyNotice(NoticeDTO notice) throws NoticeModifyException {

        int result = mapper.updateNotice(notice);

        if(!(result > 0)) {
            throw new NoticeModifyException("공지사항 수정에 실패하셨습니다.");
        }
    }

    /* 공지사항 삭제용 메소드 */
    @Override
    @Transactional
    public void removeNotice(Long no) throws NoticeRemoveException {

        int result = mapper.deleteNotice(no);

        if(!(result > 0)) {
            throw new NoticeRemoveException("공지사항 삭제에 실패하셨습니다.");
        }
    }
}
