package service.auth;

import exception.WrongIdPasswordException;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.user.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public AuthInfo authenticate(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user == null || !user.matchPassword(password)) {
            throw new WrongIdPasswordException();
        }

        return new AuthInfo(user.getUserNo(), user.getUserId(), user.getRole());
    }
}
