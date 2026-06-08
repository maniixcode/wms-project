package com.wms.mani;

import com.wms.mani.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (passwordEncoder.matches(
                user.getPassword(), dbUser.getPassword())) {
            return jwtUtil.generateToken(
                    dbUser.getUsername(), dbUser.getRole()
            );
        }
        throw new RuntimeException("Invalid password!");
    }
}