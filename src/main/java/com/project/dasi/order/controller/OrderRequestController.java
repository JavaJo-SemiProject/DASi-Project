package com.project.dasi.order.controller;

import com.project.dasi.order.model.dto.OrderFileDTO;
import com.project.dasi.order.model.dto.OrderListDTO;
import com.project.dasi.order.model.service.OrderRequestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/content/order")
public class OrderRequestController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    @Value("${spring.servlet.multipart.location}")
    private String ROOT_LOCATION;

    private final OrderRequestServiceImpl orderRequestServiceImpl;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public OrderRequestController(OrderRequestServiceImpl orderRequestServiceImpl) {
        this.orderRequestServiceImpl = orderRequestServiceImpl;
    }

    @GetMapping("/orderGuidePage")
    public String goOrderGuidePage(){
        return "/content/order/orderGuidePage";
    }


    @GetMapping("/orderRequestPage")
    public String goOrderRequestPage(){
        return "/content/order/orderRequestPage";
    }

    @PostMapping("/orderRequestPage")
    public String orderRegist(@ModelAttribute OrderListDTO order
                                , HttpServletRequest request
                                , @RequestParam("orderImg1") MultipartFile orderImg1
                                , @RequestParam("orderImg2") MultipartFile orderImg2
                                , @RequestParam("orderImg3") MultipartFile orderImg3
                                , RedirectAttributes rttr){

        log.info("");
        log.info("");
        log.info("[OrderRequestController] =========================================================");

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/original";
        String orderImgDirectory = rootLocation + "/upload/orderImg";

        File dir= new File(fileUploadDirectory);
        File dir2= new File(orderImgDirectory);

        log.info("[OrderRequestController] fileUploadDirectory : " + dir);
        log.info("[OrderRequestController] orderImgDirectory : " + dir2);

        if (!dir.exists() || !dir2.exists()) {

            log.info("[OrderRequestController] 폴더 생성 : " + dir.mkdirs());
            log.info("[OrderRequestController] 폴더 생성 : " + dir2.mkdirs());
        }

        List<Map<String, String>> fileList = new ArrayList<>();

        List<MultipartFile> paramFileList = new ArrayList<>();
        paramFileList.add(orderImg1);
        log.info("[OrderRequestController] orderImg1 : " + orderImg1);
        paramFileList.add(orderImg2);
        log.info("[OrderRequestController] orderImg2 : " + orderImg2);
        paramFileList.add(orderImg3);
        log.info("[OrderRequestController] orderImg3 : " + orderImg3);

        try{
            for(MultipartFile paramFile : paramFileList){
                if(paramFile.getSize() > 0){
                    String originFileName = paramFile.getOriginalFilename();

                    log.info("[OrderRequestController] originFileName : " + originFileName);

                    String ext = originFileName.substring(originFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-","")+ext;

                    log.info("[OrderRequestController] 변경한 이름 : " + savedFileName);

                    log.info("[OrderRequestController] paramFile : " + fileUploadDirectory + "/" + savedFileName);
                    paramFile.transferTo(new File(fileUploadDirectory+"/"+savedFileName));

                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("originFileName", originFileName);
                    fileMap.put("savedFileName", savedFileName);
                    fileMap.put("savePath", fileUploadDirectory);

                    fileMap.put("orderImgPath", "/orderImg" + savedFileName);

                    fileList.add(fileMap);

                    System.out.println("fileMap : " + fileMap);

                }
            }

            order.setOrderFileList(new ArrayList<OrderFileDTO>());
            List<OrderFileDTO> list = order.getOrderFileList();
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                OrderFileDTO tempFileInfo = new OrderFileDTO();
                tempFileInfo.setOriginName(file.get("originFileName"));
                tempFileInfo.setSavedName(file.get("savedFileName"));
                tempFileInfo.setSavePath(file.get("savePath"));
                tempFileInfo.setUploadPath(file.get("uploadPath"));

                list.add(tempFileInfo);
            }
            log.info("[OrderRequestController] orderImg : " + order);

            orderRequestServiceImpl.registOrder(order);


        } catch (IOException e) {
            e.printStackTrace();

            int cnt = 0;
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(orderImgDirectory + "/thumbnail_" + file.get("savedFileName"));
                boolean isDeleted2 = deleteThumbnail.delete();

                if (isDeleted1 && isDeleted2) {
                    cnt++;
                }
            }

            if (cnt == fileList.size()) {
                log.info("[OrderRequestController] 업로드에 실패한 모든 사진 삭제 완료!");
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }

        }


        rttr.addFlashAttribute("message","주문 요청이 성공하셨습니다.");

        return "redirect:/admin/order/adminOrderList";
    }


}
