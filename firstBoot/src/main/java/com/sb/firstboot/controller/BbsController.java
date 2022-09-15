package com.sb.firstboot.controller;

import com.sb.firstboot.domain.Bbs;
import com.sb.firstboot.domain.Pagination;
import com.sb.firstboot.domain.User;
import com.sb.firstboot.repository.BbsDao;
import com.sb.firstboot.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/bbs")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @Autowired
    private BbsDao bbsDao;

    @GetMapping("/board")
    public String board(Model model,
                        @RequestParam(required = false, defaultValue = "1") int page){
        int totalListCount = bbsDao.getBoardListCnt();

        Pagination pagination = new Pagination(); // 페이지네이션 객체 생성

        pagination.paginate(page, totalListCount); // 페이지네이션 초기화

        model.addAttribute("pagination", pagination);
        model.addAttribute("BBS_LIST", bbsDao.getBoardList(pagination));
        return null;
    }

    @PostMapping ("/board")
    public String board(){
        return null;
    }

    @GetMapping("/insert")
    public String insert(){
        return "/bbs/input";
    }

    @PostMapping ("/insert")
    public String insert(Bbs bbs, HttpSession session, MultipartFile file){
        User loggedInUser = (User) session.getAttribute("USER");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        bbs.setOriginal_img(file.getOriginalFilename());
        String uuid = UUID.randomUUID().toString();
        String uuidImg = uuid+file.getOriginalFilename();
        bbs.setImg(uuidImg);
        bbs.setDate(dateFormat.format(date));
        bbs.setTime(timeFormat.format(date));
        bbs.setUsername(loggedInUser.getUsername());

        File uploadFile = new File(uuidImg);
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bbsService.insertBbs(bbs);

        return "redirect:/bbs/board";
    }

    @GetMapping("/detail")
    public String detail(Model model, long id){
        Bbs bbs = bbsService.findBbsById(id);
        model.addAttribute("BBS", bbs);
        return null;
    }
    @GetMapping("/get/img")
    public String infinity(){

        return null;
    }
    @GetMapping("/video")
    public String video(){
        return null;
    }
}
