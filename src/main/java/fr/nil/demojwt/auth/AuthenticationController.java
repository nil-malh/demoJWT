package fr.nil.demojwt.auth;


import fr.nil.demojwt.auth.execeptions.EmailAlreadyUsedException;
import fr.nil.demojwt.auth.execeptions.InvalidEmailException;
import fr.nil.demojwt.auth.requests.AuthenticationRequest;
import fr.nil.demojwt.auth.requests.RegisterRequest;
import fr.nil.demojwt.auth.response.AuthenticationResponse;
import fr.nil.demojwt.repositories.UserRepository;
import fr.nil.demojwt.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request)
    {
        if(!request.getEmail().contains("@"))
            throw new InvalidEmailException();
        if(userRepository.existsByMail(request.getEmail()))
            throw new EmailAlreadyUsedException();

       return ResponseEntity.ok(authenticationService.register(request));

    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request)
    {
        if(!request.getEmail().contains("@"))
            throw new InvalidEmailException();

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }






}
