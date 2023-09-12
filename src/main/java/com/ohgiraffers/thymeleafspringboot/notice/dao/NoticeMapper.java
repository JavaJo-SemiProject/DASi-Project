package com.ohgiraffers.thymeleafspringboot.notice.dao;

import com.ohgiraffers.thymeleafspringboot.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectAllNoticeList();

    int insertNotice(NoticeDTO notice);

    int incrementNoticeCount(Long no);

    NoticeDTO selectNoticeDetail(Long no);

    int updateNotice(NoticeDTO notice);

    int deleteNotice(Long no);
}
