package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Service.LoginService;
import Openconnection.example.demo.beans.Credentials;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String login(@RequestBody Credentials usercredentials ) throws LoginException {
        return loginService.login(usercredentials.getUserName(), usercredentials.getUserPass());

    }




}
