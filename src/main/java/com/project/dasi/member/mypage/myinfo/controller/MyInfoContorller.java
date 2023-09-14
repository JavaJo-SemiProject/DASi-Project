package com.project.dasi.member.mypage.myinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyInfoContorller {

        @RequestMapping("/member/mypage/mypageMain")
        public void goMypageMain() {}
        @RequestMapping("/member/mypage/passworkCheck")
        public void goPassworkCheck() {}
        @RequestMapping("/member/mypage/myInfo/mypageInfoEdit")
        public void goMypageMainEdit() {}
        @RequestMapping("/member/mypage/myInfo/mypageAddrEdit")
        public void goMypageAddrEdit() {}
        @RequestMapping("/member/mypage/myInfo/mypageNewAddr")
        public void goMypageNewAddr() {}

}
