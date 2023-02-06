package fr.nil.demojwt.services;

import fr.nil.demojwt.auth.requests.AuthenticationRequest;
import fr.nil.demojwt.auth.requests.RegisterRequest;
import fr.nil.demojwt.auth.response.AuthenticationResponse;
import fr.nil.demojwt.entities.user.Role;
import fr.nil.demojwt.entities.user.User;
import fr.nil.demojwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request)
    {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mail(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request)
    {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepository.findByMail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
