package com.ohgiraffers.thymeleafspringboot.board.controller;

import com.ohgiraffers.thymeleafspringboot.board.dto.BoardDTO;
import com.ohgiraffers.thymeleafspringboot.board.dto.ReplyDTO;
import com.ohgiraffers.thymeleafspringboot.board.service.BoardServiceImpl;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.BoardRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRemoveException;
import com.ohgiraffers.thymeleafspringboot.common.paging.Pagenation;
import com.ohgiraffers.thymeleafspringboot.common.paging.SelectCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BoardServiceImpl boardServiceImpl;

    public BoardController(BoardServiceImpl boardServiceImpl) {
        this.boardServiceImpl = boardServiceImpl;
    }

    @GetMapping(value = "/list")
    public ModelAndView boardList(HttpServletRequest request, @RequestParam(required = false) String searchCondition,
                                  @RequestParam(required = false) String searchValue, @RequestParam(value="currentPage", defaultValue = "1") int pageNo
                                  , ModelAndView mv) {

        log.info("");
        log.info("");
        log.info("[BoardController] =========================================================");
        /*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[BoardController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */
        int totalCount = boardServiceImpl.selectTotalCount(searchMap);
        log.info("[BoardController] totalBoardCount : " + totalCount);

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 10;		//얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[BoardController] selectCriteria : " + selectCriteria);

        /* 조회해 온다 */
        List<BoardDTO> boardList = boardServiceImpl.selectBoardList(selectCriteria);

        log.info("[BoardController] boardList : " + boardList);

        mv.addObject("boardList", boardList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[BoardController] SelectCriteria : " + selectCriteria);
        mv.setViewName("content/board/boardList");

        log.info("[BoardController] =========================================================");
        return mv;
    }

    @GetMapping("/detail")
    public String selectBoardDetail(HttpServletRequest request, Model model) {
        log.info("");
        log.info("");
        log.info("[BoardController] =========================================================");

        Long no = Long.valueOf(request.getParameter("no"));
        BoardDTO boardDetail = boardServiceImpl.selectBoardDetail(no);
        log.info("[BoardController] boardDetail : " + boardDetail);

        model.addAttribute("board", boardDetail);

        /* 댓글 작성 완료 후 추가할 것 */
        List<ReplyDTO> replyList = boardServiceImpl.selectAllReplyList(no);
        model.addAttribute("replyList", replyList);
        log.info("[BoardController] replyList : " + replyList);

        log.info("[BoardController] =========================================================");
        return "content/board/boardDetail";
    }

    @PostMapping("/registReply")
    public ResponseEntity<List<ReplyDTO>> registReply(@RequestBody ReplyDTO registReply) throws ReplyRegistException {

        log.info("");
        log.info("");
        log.info("[BoardController] =========================================================");
        log.info("[BoardController] registReply Request : " + registReply);

        List<ReplyDTO> replyList = boardServiceImpl.registReply(registReply);

        log.info("[BoardController] replyList : " + replyList);
        log.info("[BoardController] =========================================================");

        return ResponseEntity.ok(replyList);
    }

    @DeleteMapping("/removeReply")
    public ResponseEntity<List<ReplyDTO>> removeReply(@RequestBody ReplyDTO removeReply) throws ReplyRemoveException {

        log.info("");
        log.info("");
        log.info("[BoardController] =========================================================");
        log.info("[BoardController] removeReply Request : " + removeReply);

        List<ReplyDTO> replyList = boardServiceImpl.removeReply(removeReply);

        log.info("[BoardController] replyList : " + replyList);
        log.info("[BoardController] =========================================================");

        return ResponseEntity.ok(replyList);
    }

    @GetMapping("/regist")
    public String goRegister() {
        return "content/board/boardRegist";
    }

    @PostMapping("/regist")
    public String registBoard(@ModelAttribute BoardDTO board, RedirectAttributes rttr) throws BoardRegistException {

        log.info("");
        log.info("");
        log.info("[BoardController] registBoard =========================================================");
        log.info("[BoardController] registBoard Request : " + board);

        boardServiceImpl.registBoard(board);

        rttr.addFlashAttribute("message", "게시글 등록에 성공하셨습니다!");

        log.info("[BoardController] registBoard =========================================================");

        return "redirect:/board/list";
    }


}
