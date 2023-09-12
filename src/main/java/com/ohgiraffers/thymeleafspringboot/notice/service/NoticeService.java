package com.ohgiraffers.thymeleafspringboot.notice.service;

import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRemoveException;
import com.ohgiraffers.thymeleafspringboot.notice.dto.NoticeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeService {

    /* 공지사항 전체 목록 조회용 메소드 */
    public List<NoticeDTO> selectAllNoticeList();

    /* 공지사항 등록용 메소드 */
    @Transactional
    public void registNotice(NoticeDTO notice) throws NoticeRegistException;

    /* 공지사항 상세 페이지 조회용 메소드 */
    public NoticeDTO selectNoticeDetail(Long no);

    /* 공지사항 수정용 메소드 */
    public void modifyNotice(NoticeDTO notice) throws NoticeModifyException;

    /* 공지사항 삭제용 메소드 */
    public void removeNotice(Long no) throws NoticeRemoveException;
}
