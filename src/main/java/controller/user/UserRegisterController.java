package controller.user;

import command.UserRegisterCommand;
import exception.ExistMemberException;
import exception.WrongIdPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.user.UserRegisterService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @GetMapping
    public String registerForm(@ModelAttribute("formData") UserRegisterCommand request) {
        return "user.register";
    }

    @PostMapping
    public String registerSubmit(@ModelAttribute("formData") @Valid UserRegisterCommand request, Errors errors) {
        if (errors.hasErrors()) return "user.register";
        try {
            userRegisterService.join(request);
            return "user.success";
        } catch (ExistMemberException e) {
            if (e.getMessage() == "email") errors.rejectValue("email", "duplicate");
            if (e.getMessage() == "userId") errors.rejectValue("userId", "duplicate");
            return "user.register";
        } catch (WrongIdPasswordException e) {
            errors.rejectValue("confirmPassword", "nomatch");
            return "user.register";
        }
    }
}
