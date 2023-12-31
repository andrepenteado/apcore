package com.github.andrepenteado.core.web.resources;

import com.github.andrepenteado.core.web.dto.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthResource {

    @GetMapping("/usuario")
    public UserLogin usuario(@AuthenticationPrincipal OidcUser principal) {
        UserLogin userLogin = new UserLogin(
            principal.getAttribute("login"),
            principal.getAttribute("nome"),
            principal.getAttribute("perfis")
        );
        log.info("Buscar usuário logado " + userLogin.login());
        return userLogin;
    }

}
