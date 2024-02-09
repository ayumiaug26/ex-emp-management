package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.model.Administrator;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService service;

    @Autowired
    private HttpSession session;

    /**
     * InsertAdministratorFormを引数で受け取り,
     * administrator/insert.htmlへフォワード.
     * 
     * @param form
     * @return
     */
    @GetMapping({ "/toInsert", "/toInsert/" })
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";

    }

    /**
     * 管理者情報を登録する.
     * 
     * @param form
     * @return
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator admin = new Administrator();
        admin.setName(form.getName());
        admin.setMailAddress(form.getMailAddress());
        admin.setPassword(form.getPassword());

        service.insert(admin);

        return "redirect:/";

    }

    /**
     * ログインページを表示する.
     * 
     * @param form
     * @return
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";

    }

    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator admin = service.login(form.getMailAddress(), form.getPassword());
        if (admin == null) {
            model.addAttribute("msg", "メールアドレスまたはパスワードが不正です。");
            return "administrator/login";
        }

        session.setAttribute("administratorName", admin.getName());

        return "redirect:/employee/showList";
    }
}
