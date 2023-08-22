package service.user;

import command.UserRegisterCommand;
import exception.ExistMemberException;
import exception.WrongIdPasswordException;
import model.user.Role;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRegisterService {
    @Autowired
    private UserRepository userRepository;

    public void join(UserRegisterCommand req) {
        if (!req.isPasswordEqualToConfirmPassword()) {
            throw new WrongIdPasswordException();
        }

        List<User> users = userRepository.findByEmailOrUserId(req.getEmail(), req.getUserId());
        if (! users.isEmpty()) {
            for (User user : users) {
                if (user.getEmail().equals(req.getEmail())) {
                    throw new ExistMemberException("email");
                }
                if (user.getUserId().equals(req.getUserId())) {
                    throw new ExistMemberException("userId");
                }
            }
        }

        User newUser = new User(req.getUserId(), req.getPassword(), req.getEmail(), req.getName());
        userRepository.save(newUser);
    }
}
