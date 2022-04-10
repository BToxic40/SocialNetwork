package ru.learn.learnSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learn.learnSpring.api.response.CaptchaResponse;
import ru.learn.learnSpring.api.response.CheckResponse;
import ru.learn.learnSpring.api.response.RegisterResponse;
import ru.learn.learnSpring.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final AuthService authService;

    public ApiAuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/check")
    public ResponseEntity<CheckResponse> checkUserAuth() {
        return ResponseEntity.ok(authService.check());
    }

    @GetMapping("/captcha")
    public ResponseEntity<CaptchaResponse> checkCaptcha() {
        return ResponseEntity.ok(authService.captcha());
    }

    @GetMapping("/register")
    public ResponseEntity<RegisterResponse> registration() {
        return ResponseEntity.ok(authService.register());
    }
}


