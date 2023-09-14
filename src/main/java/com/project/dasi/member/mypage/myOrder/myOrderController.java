package com.project.dasi.member.mypage.myOrder;

import com.project.dasi.member.order.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/myOrder")
public class myOrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final OrderServiceImpl orderServiceImpl;

    public myOrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    /*@GetMapping(value = "/myOrderList")
    public ModelAndView myOrderList(HttpServletRequest request, @RequestParam(required = false) String searchCondition,
                                    )*/





}
