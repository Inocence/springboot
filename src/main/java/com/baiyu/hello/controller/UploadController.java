package com.baiyu.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }
    @RequestMapping(value = "uploadDo", method = RequestMethod.POST)
    public String uploadDo(HttpServletRequest request, MultipartFile file, Model model) {
        try{
            String name = System.currentTimeMillis() + file.getOriginalFilename();
            String fileName = request.getServletContext().getRealPath("") + "upload" + File.separator + name;
            model.addAttribute("fileName", name);
            File new_file = new File(fileName);
            new_file.getParentFile().mkdirs();

            file.transferTo(new_file);
        }catch (IOException e) {
            e.printStackTrace();
            return "上传失败" + e.getMessage();
        }

        return "show";
    }
}
