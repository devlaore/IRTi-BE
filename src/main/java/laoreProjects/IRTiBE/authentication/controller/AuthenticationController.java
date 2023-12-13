package laoreProjects.IRTiBE.authentication.controller;

import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import laoreProjects.IRTiBE.authentication.jwtElements.JWTAuthenticationResponse;
import laoreProjects.IRTiBE.authentication.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/get_ACCOUNT_By_MATRICOLA")
    public ResponseEntity<AccountEntity> get_ACCOUNT_By_MATRICOLA(@RequestParam String matricola) {

        AccountEntity accountEntity = authenticationService.get_ACCOUNT_By_MATRICOLA(matricola);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountEntity);
    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthenticationResponse> login(@RequestBody AccountEntity accountRequest) {
        return ResponseEntity.ok(authenticationService.login(accountRequest));
    }

    @PostMapping("/createAccount")
    public ResponseEntity<JWTAuthenticationResponse> createUser(@RequestBody AccountEntity accountRequest) {
        return ResponseEntity.ok(authenticationService.createAccount(accountRequest));
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<Object> deleteUser(@RequestBody AccountEntity accountRequest) {
        return ResponseEntity.ok(authenticationService.deleteAccount(accountRequest));
    }

    @PostMapping("/changePasswordAccount")
    public ResponseEntity<AccountEntity> changePasswordAccount(@RequestBody AccountEntity accountRequest) {
        return ResponseEntity.ok(authenticationService.changePasswordAccount(accountRequest));
    }

}
