package com.ems.ems.controller.email;


import com.ems.ems.dto.EmailDto;
import com.ems.ems.utils.EmailSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email-service")
public class EmailController {

    @Autowired
    private EmailSenderUtil emailSenderUtil;


    @GetMapping
    public String openEmailServicePage(Model model){

        model.addAttribute("emailDto", new EmailDto());
        return "email/emailsender";
    }

    @PostMapping
    public String sendEmailMessage(@ModelAttribute EmailDto emailDto, RedirectAttributes redirectAttributes){
        System.out.println(emailDto.toString());
        String message = emailSenderUtil.sendEmail(emailDto);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/email-service";
    }

    @PostMapping("/attachment")
    public String sendEmailWithAttachment(@ModelAttribute EmailDto emailDto, RedirectAttributes redirectAttributes){

        String message = emailSenderUtil.sendEmailWithAttachment(emailDto);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/email-service";

    }
}
