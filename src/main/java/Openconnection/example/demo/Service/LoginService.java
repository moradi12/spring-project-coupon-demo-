package Openconnection.example.demo.Service;

import Openconnection.example.demo.Repository.UserRepository;
import Openconnection.example.demo.beans.Credentials;
import Openconnection.example.demo.utills.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final JWT jwt;
    private final UserRepository userRepository;


    public String login(String userName, String userPass) throws LoginException {
        Credentials credentials = userRepository.findByUserNameAndUserPass(userName,userPass);
        if (credentials == null) {
            throw new LoginException("User is not exist!!");

        } else return jwt.generateToken(credentials);

    }
}




//    public String login(String userName, String userPass) throws LoginException {
//        Credentials credentials = new Credentials(1, userName, userPass, "TamirMoradi@mail.com", "admin");
//        if (userName.equals("admin") && userPass.equals("12345678")) {
//            return jwt.generateToken(credentials);
//        } else {
//
//        }
//        throw new LoginException("Invalid username or password");
//    }
//            }
