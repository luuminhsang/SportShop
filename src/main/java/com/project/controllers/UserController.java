package com.project.controllers;

import com.project.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("formRegister", new AccountDTO());
        return mav;
    }

    @PostMapping(value = "/register")
    public Object register(@ModelAttribute("formRegister") AccountDTO form, BindingResult bindingResult,
                           RedirectAttributes attributes) {
//        registerValidator.validate(form, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/register");
        }

        AccountDTO user = new AccountDTO(form.getUserName(), form.getPassword(), form.getEmail(), form.getFullName(),
                UserRoles.ROLE_VIEWER);
        userService.register(user);
        UserViewer viewer = new UserViewer(user);
        viewerService.save(viewer);
        attributes.addFlashAttribute("message", "Register success");
        return new RedirectView("/login");

    }
}
