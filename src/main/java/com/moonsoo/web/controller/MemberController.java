package com.moonsoo.web.controller;

import com.moonsoo.web.entity.Member;
import com.moonsoo.web.model.MemberDto;
import com.moonsoo.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/index")
    public ModelAndView index() {
        List<Member> members = memberService.list();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("members", members);
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }

    @PostMapping("/index")
    public String create(MemberDto memberDto) throws UnsupportedEncodingException {
        memberService.insert(memberDto.getUsername(), memberDto.getPassword());
        return "redirect:index";
    }
}
