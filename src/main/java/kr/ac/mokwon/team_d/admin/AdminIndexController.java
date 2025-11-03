package kr.ac.mokwon.team_d.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdminIndexController {

    @GetMapping("/")
    public String adminIndex(Model model) {
        model.addAttribute("title", "home :: title");
        model.addAttribute("content", "home :: content");
        return "layout/layout";
    }
}
