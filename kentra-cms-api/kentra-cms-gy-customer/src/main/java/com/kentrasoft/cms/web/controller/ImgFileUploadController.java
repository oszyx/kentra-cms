package com.kentrasoft.cms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author liyang
 * @Description: 图片上传
 * @date 22018年6月29日 17:06:28
 */
@RestController
@RequestMapping("/img")
public class ImgFileUploadController {
    private static Logger logger = LoggerFactory.getLogger(ImgFileUploadController.class);

    private String server = "localhost";
    private String savePath = "D://";
    
//    private String server = "171.221.205.67:9110";
//    private String savePath = "/mnt/image/gy";
    

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> UploadFile(HttpServletRequest request) throws IllegalStateException, IOException {
//        System.out.println("upload...");
        Map<String, Object> uploadResult = new HashMap<String, Object>();
        uploadResult.put("code", 200);
        uploadResult.put("msg", "上传成功");
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            /*String userDefined = multipartRequest.getParameter("appName");
            if (!StringUtils.isEmpty(userDefined)) {//加上自定义位置
                SAVE_FILE_PRE_DIR = userDefined;
            }*/
            // 获取上传的文件
            MultipartFile multiFile = multipartRequest.getFile("files");
            //转为流
            //InputStream inputStream = multiFile.getInputStream();
            //获取上传的全名
            String originalFilename = multiFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileName = (new Random()).nextInt(9) + "." + suffix;

            String urlPath = server + "/gy" ;
            String dirPath = savePath + File.separator ;

            File dirPathFile = new File(dirPath);
            if (!dirPathFile.exists()) {
                dirPathFile.mkdirs();
            }
            multiFile.transferTo(new File(dirPath + fileName));
            
            String imgUrl = urlPath + fileName;
            uploadResult.put("data", imgUrl);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            uploadResult.put("code", 300);
            uploadResult.put("msg", "上传失败");
            return uploadResult;
        }
        return uploadResult;
    }

}
