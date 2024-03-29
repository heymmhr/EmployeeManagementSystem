package com.ems.ems.controller;

import com.ems.ems.dto.SampleDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String mainPage(Model model) {

        model.addAttribute("sampleDto", new SampleDto());
        System.out.println("i am here!!");
        return "index";
    }

    @PostMapping("/submit1")
    public String submitForm(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        System.out.println(data1);
        System.out.println(data2);

        redirectAttributes.addFlashAttribute("d1", data1);
        redirectAttributes.addFlashAttribute("d2", data2);
        return "redirect:/";
    }

    @PostMapping("/submit2")
    public String submitForm(@RequestParam("data1") String data1, @RequestParam("data2") String data2, RedirectAttributes redirectAttributes) {
        System.out.println(data1);
        System.out.println(data2);
        redirectAttributes.addFlashAttribute("d3", data1);
        redirectAttributes.addFlashAttribute("d4", data2);
        return "redirect:/";
    }

    @PostMapping("/submit3")
    public String submitForm(@ModelAttribute SampleDto sampleDto, RedirectAttributes redirectAttributes) {

        System.out.println(sampleDto.toString());
        redirectAttributes.addFlashAttribute("d5", sampleDto.getData1());
        redirectAttributes.addFlashAttribute("d6", sampleDto.getData2());

        return "redirect:/";
    }
}
