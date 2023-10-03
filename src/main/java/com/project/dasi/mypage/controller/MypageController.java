package com.project.dasi.mypage.controller;

import com.project.dasi.admin.order.model.service.AdminOrderService;
import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.auth.model.service.UserService;
import com.project.dasi.mypage.model.service.MypageService;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/content/mypage")
public class MypageController {


    private final MypageService mypageService;// 사용자 정보 서비스
    private final AdminOrderService orderService;
    private final PasswordEncoder passwordEncoder;


    private UserService userService; // UserService를 주입

    public MypageController(MypageService  mypageService, AdminOrderService orderService, PasswordEncoder passwordEncoder) {
        this.mypageService = mypageService;
        this.orderService = orderService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/mypageMain")
    public String mypageMain(Model model, Principal principal) {
        // 현재 로그인한 사용자의 ID를 가져온다.
        String userId = principal.getName();

        //디버깅용으로 로강을 추가하여 사용자 ID를 올바르게 가져오는지 확인
        System.out.println("Logged in user ID:" + userId);

        //Service를 사용하여 사용자 정보를 가져온다.
        UserDTO userDTO = mypageService.getUserInfo(userId);

        // 디버깅용으로 로깅을 추가하여 사용자 정보가 어떻게 반환되는지 확인
        System.out.println("UserDTO: " + userDTO);


        if (userDTO != null) {
            model.addAttribute("userDTO",userDTO);
//            return "/content/mypage/mypageMain"; //사용자를 찾지 못한 경우 예외처리 페이지로 이동
        } else {
            return "/content/mypage/mypageMain";
        }
//        if (userDTO.getUserId() != null) {
//        model.addAttribute("user", userDTO);
        //}
        //모델에 사용자 정보를 추가한다.
        model.addAttribute("user", userDTO);
        System.out.println("userid, userdto : " + userDTO  + userId);

        return "/content/mypage/mypageMain";
    }


    @RequestMapping(value = "/content/mypage/mypageUpdate", method = RequestMethod.POST)
    public String postMypageUpdate(
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            Principal principal,
            RedirectAttributes redirectAttributes
    ) {
        String userId = principal.getName();

        if (newPassword.equals(confirmPassword)) {
            // 비밀번호가 일치하면 비밀번호를 업데이트합니다.
            mypageService.updatePassword(userId, newPassword);
            redirectAttributes.addFlashAttribute("successMessage", "비밀번호가 성공적으로 변경되었습니다.");
        } else {
            // 비밀번호가 일치하지 않으면 에러 메시지를 표시합니다.
            redirectAttributes.addFlashAttribute("errorMessage", "비밀번호가 일치하지 않습니다. 다시 시도하세요.");
        }
        return "redirect:/content/mypage/mypageMain";
    }

    @GetMapping("/mypageUpdate")
    public String goMypageUpdate(HttpServletRequest request, Model model) {
        String userId = request.getParameter("userId");


        return "content/mypage/mypageUpdate";
    }

    @GetMapping("/myOrderList")
    public ModelAndView myOrderList(ModelAndView mv, Principal principal) {
        String userId = principal.getName();
        List<OrderListDTO> orderList = orderService.selectMyOrderList(userId);
        mv.addObject("orderList", orderList);
        mv.setViewName("/content/mypage/myOrderList");

        System.out.println("orderList : " + orderList);

        return mv;
    }


    @GetMapping("/myOrderDetail")
    public String adminOrderDetail(HttpServletRequest request, Model model){

        String orderId = request.getParameter("orderId");

        OrderListDTO orderDetail = orderService.selectOrderDetail(orderId);

        model.addAttribute("order",orderDetail);

        return "/content/mypage/myOrderDetail";
    }

    @PostMapping("/myOrderDetail")
    @ResponseBody
    public String updateMyOrder(@RequestBody OrderListDTO order){


        System.out.println("order :" + order);

        orderService.updateDeliver(order);

        return "/content/mypage/myOrderList";
    }


    @PostMapping("/cancel")
    @ResponseBody
    public ResponseEntity<String> cancel(@RequestBody OrderListDTO order) {

        JSONObject jsonObject = new JSONObject(order);

        String status = jsonObject.getString("status");
        int orderId = jsonObject.getInt("orderId");
        System.out.println("deliverEnd : " + status);
        System.out.println("orderId : " + orderId);

        try {
            OrderListDTO orderList = new OrderListDTO();
            orderList.setStatus(status);
            orderList.setOrderId(orderId);

            orderService.updateDeliver(order);

            System.out.println("order con : " + orderList);

            return new ResponseEntity<>("주문 취소 성공", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("주문 취소장 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

