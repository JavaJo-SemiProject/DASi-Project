package com.project.dasi.member.order.controller;

import com.project.dasi.member.order.dto.OrderListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

   /* @Value("${image.imageDir}")
    private String imageDir;

    @Value("${spring.servlet.multipart.loction}")
    private String uploadPath;

    private final OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }*/


    @RequestMapping("/member/order/orderGuidePage")
    public void goOrderGuidePage() {
    }

    @RequestMapping ("/member/order/orderRequestPage")
    public String goOrderRequestPage() {
        return "/member/order/orderRequestPage";
    }



   /* @PostMapping("/member/order/orderRequestPage")
    public String multiFileUpload(@ModelAttribute OrderListDTO orderImg, HttpServletRequest request,
                                  @RequestParam("orderImg1") MultipartFile orderImg1,
                                  @RequestParam("orderImg2") MultipartFile orderImg2,
                                  @RequestParam("orderImg3") MultipartFile orderImg3,
                                  RedirectAttributes rttr) {

        log.info("");
        log.info("[OrderController]");

        String root = uploadPath + imageDir;

        String fileUploadDir = root + "/upload/original";
        String orderImgDir = root + "/upload/orderImg";

        File dir = new File(fileUploadDir);
        File dir2 = new File(orderImgDir);

        log.info("[OrderController] fileUploadDir : " + dir);
        log.info("[OrderController] orderImgDir : " + dir2);

        if (!dir.exists() || !dir.exists()) {

            log.info("[OrderController] 폴더 생성 : " + dir.mkdirs());
            log.info("[OrderController] 폴더 생성 : " + dir2.mkdirs());
        }

        List<Map<String, String>> files = new ArrayList<>();

        List<MultipartFile> paramFileList = new ArrayList<>();

        paramFileList.add(orderImg1);
        log.info("[OrderController] orderImg1 : " + orderImg1);
        paramFileList.add(orderImg2);
        log.info("[OrderController] orderImg2 : " + orderImg2);
        paramFileList.add(orderImg3);
        log.info("[OrderController] orderImg3 : " + orderImg3);


        try {
            for (MultipartFile paramFile : paramFileList) {
                if (paramFile.getSize() > 0) {
                    String originFileName = paramFile.getOriginalFilename();

                    log.info("[OrderController] originFileName : " + originFileName);

                    String ext = originFileName.substring(originFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                    log.info("[OrderController] 변경한 이름 : " + savedFileName);

                    log.info("[OrderController] paramFile : " + fileUploadDir + "/" + savedFileName);

                    paramFile.transferTo(new File(fileUploadDir + "/" + savedFileName));

                    *//*db에 업로드한 파일 정보를 저장 및 필요한 정보를 map형태로 등록*//*
                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("originName", originFileName);
                    fileMap.put("transferName", savedFileName);
                    fileMap.put("uploadPath", fileUploadDir);

                    *//*썸네일*//*
                    int width = 0;
                    int height = 0;

                    String fieldName = paramFile.getName();
                    log.info("[OrderController] 필드 name : " + fieldName);

                    if ("orderImg1".equals(fieldName)){
                        fileMap.put("fileType","TITLE");

                        width=300;
                        height=300;

                    }else {
                        log.info("[OrderController] 사이즈 변경 실패 ");
                    }

                    Thumbnails.of(fileUploadDir + "/" + savedFileName).size(width, height)
                            .toFile(orderImgDir + "/orderImg_" + savedFileName);

                    fileMap.put("savedPath","/orderImg_"+savedFileName);

                    files.add(fileMap);
                }

            }
            log.info("[OrderController] files : " + files);

            orderImg.setOrderFiles(new ArrayList<OrderFileDTO>());
            List<OrderFileDTO> list = orderImg.getOrderFiles();
            for(int i = 0; i < files.size(); i++){
                Map<String,String> file = files.get(i);

                OrderFileDTO tempFileInfo = new OrderFileDTO();
                tempFileInfo.setOriginName(file.get("originFileName"));
                tempFileInfo.setTransferName(file.get("savedFileName"));
                tempFileInfo.setUploadPath(file.get("savePath"));
                tempFileInfo.setExt(file.get("fileType"));

                list.add(tempFileInfo);
            }

            log.info("[OrderController] orderImg : " + orderImg);

            orderServiceImpl.registOrderImg(orderImg);

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();

            int cnt = 0;
            for(int i = 0; i< files.size(); i++){
                Map<String,String> file = files.get(i);

                File deleteFile = new File(fileUploadDir + "/" + file.get("savedFileName"));
                boolean isDeleted1 = deleteFile.delete();

                File deleteOrderImg = new File(fileUploadDir + "/orderImg_" + file.get("savedFileName"));
                boolean isDeleted2 = deleteFile.delete();

                if(cnt == files.size()){
                    log.info("[OrderController] 업로드에 실패한 모든 사진 삭제 완료!");
                    e.printStackTrace();
                }else {
                    e.printStackTrace();
                }
            }
            log.info("[OrderController]");

            return "redirct:/member/order/orderRequestPage";

        }

        return null;
    }*/

    @PostMapping("/member/order/orderRequestPage")
    public String orderRegist(@ModelAttribute OrderListDTO orderList, RedirectAttributes rttr){
        log.info("");
        log.info("");
        log.info("[OrderContorller]");
        log.info("[OrderContorller] orderRegist Request : " + orderList);

/*
        orderServiceImpl.registOrder(orderList);
*/
        return null;
    }



    @RequestMapping("/member/order/orderSuccessPage")
    public void goOrderSuccessPage() {
    }

}

