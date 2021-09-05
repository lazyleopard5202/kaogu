package com.kaogu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {

    @RequestMapping("/index")
    public String index() {
        return "index-my";
    }

    @RequestMapping("/article")
    public String article() { return  "Articles"; }

    @RequestMapping("/article1")
    public String article1() { return  "Articles-1"; }

    @RequestMapping("/article2")
    public String article2() { return  "Articles-2"; }

    @RequestMapping("/image")
    public String image() { return  "Image"; }

    @RequestMapping("/video")
    public String video() { return  "Video"; }

    @RequestMapping("/video1")
    public String video1() { return  "Video-1"; }

    @RequestMapping("/video2")
    public String video2() { return  "Video-2"; }

    @RequestMapping("/reference")
    public String reference() { return  "Reference"; }
}
