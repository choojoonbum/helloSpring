package controller.user;

import command.LoginCommand;
import exception.WrongIdPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.auth.AuthInfo;
import service.auth.AuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/login")
public class LoginController {
    @Autowired
    AuthService authService;

    @GetMapping
    public String form(@ModelAttribute("loginCommand") LoginCommand loginCommand, @CookieValue(value = "rememberUserId", required = false) Cookie cookie) {
        if (cookie != null) {
            loginCommand.setUserId(cookie.getValue());
            loginCommand.setRememberUserId(true);
        }
        return "user.loginForm";
    }

    @PostMapping
    public String submit(@Valid @ModelAttribute("loginCommand") LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
        if (errors.hasErrors()) return "user.loginForm";
        try {
            AuthInfo authInfo = authService.authenticate(loginCommand.getUserId(), loginCommand.getPassword());
            session.setAttribute("authInfo", authInfo);

            Cookie rememberCookie = new Cookie("rememberUserId", loginCommand.getUserId());
            rememberCookie.setPath("/");
            if (loginCommand.isRememberUserId()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 30);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);

            return "user.loginSuccess";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "user.loginForm";
        }
    }
}
