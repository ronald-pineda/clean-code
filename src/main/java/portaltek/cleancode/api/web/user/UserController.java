package portaltek.cleancode.api.web.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.core.security.JwtService;
import portaltek.cleancode.spi.datastore.model.User;
import portaltek.cleancode.core.service.UserService;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/api/auth/user/")
class UserController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "me", method = GET)
    public ResponseEntity<String> getUserMe(
            @RequestHeader(value = "${jwt.header}") String token) {

        Long userId = jwtService.getUserIdFromToken(token.substring(6));
        User user = userService.read(userId);
        var msg = "Hello, " + user.getUsername();
        return ok(msg);
    }

    @RequestMapping(value = "ping", method = GET)
    public ResponseEntity<String> ping() {
        return ok("Pong!");
    }

}