package com.example.kyrgyzpatentbackend.service.impl;

import com.example.kyrgyzpatentbackend.config.jwt.JwtService;
import com.example.kyrgyzpatentbackend.db.dto.request.AuthenticateRequest;
import com.example.kyrgyzpatentbackend.db.dto.request.RegisterRequest;
import com.example.kyrgyzpatentbackend.db.dto.response.AuthenticationResponse;
import com.example.kyrgyzpatentbackend.db.exceptions.AlreadyExistException;
import com.example.kyrgyzpatentbackend.db.exceptions.BadRequestException;
import com.example.kyrgyzpatentbackend.db.exceptions.NotFoundException;
import com.example.kyrgyzpatentbackend.db.model.User;
import com.example.kyrgyzpatentbackend.db.model.enums.Role;
import com.example.kyrgyzpatentbackend.repository.UserRepository;
import com.example.kyrgyzpatentbackend.service.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final AuthenticationManager manager;
    private final JwtService jwtService;
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);


    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        User user = userRepository.findByEmail(request.email()).orElseThrow(() -> {
            logger.error("User with email: " + request.email() + " not found!");
            throw new NotFoundException("Пользователь с электронной почтой: " + request.email() + " не найден!");
        });
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            logger.error("Wrong password!");
            throw new BadRequestException("Неправильный пароль!");
        }
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            log.error(String.format("Пользователь с адресом электронной почты %s уже существует", request.email()));
            throw new AlreadyExistException(String.format("Пользователь с адресом электронной почты %s уже существует", request.email()));
        }

        User user = User.builder()
                .fullName(request.fullName())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .isActive(true)
                .build();

        userRepository.save(user);
        log.info(String.format("Пользователь %s успешно сохранен!", user.getEmail()));

        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }
}
