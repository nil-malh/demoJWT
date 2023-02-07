package fr.nil.demojwt.auth;


import fr.nil.demojwt.auth.execeptions.EmailAlreadyUsedException;
import fr.nil.demojwt.auth.execeptions.InvalidEmailException;
import fr.nil.demojwt.auth.execeptions.InvalidUsernameException;
import fr.nil.demojwt.auth.execeptions.UnsecuredPasswordException;
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

        // TODO: 07/02/2023 : Need to add a @Profile("prod") to disable those check in the dev env to be more faster when creating temp users 
        if(request.getPassword().length() < 12)
            throw new UnsecuredPasswordException();
        if(InvalidUsernameException.BLACKLISTED_USERNAME_LIST.contains(request.getFirstName()) || InvalidUsernameException.BLACKLISTED_USERNAME_LIST.contains(request.getLastName()))
            throw new InvalidUsernameException(request.getFirstName()  + "||" + request.getLastName());
       return ResponseEntity.ok(authenticationService.register(request));

    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
        if(!request.getEmail().contains("@"))
            throw new InvalidEmailException();

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }






}
