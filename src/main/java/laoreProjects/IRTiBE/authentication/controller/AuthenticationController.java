package laoreProjects.IRTiBE.authentication.controller;

import io.jsonwebtoken.ExpiredJwtException;
import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import laoreProjects.IRTiBE.authentication.jwtElements.JWTAuthenticationResponse;
import laoreProjects.IRTiBE.authentication.service.AuthenticationService;
import laoreProjects.IRTiBE.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final LogService logService;


    /******************************************************************************************
     *  Endpoints on TABLE account
     *****************************************************************************************/
    @GetMapping("/getLista_ACCOUNT") // Postman request: "getLista_TD_EVENTO_TESTATA_By_ID_BANDO"
    public ResponseEntity<List<AccountEntity>> getLista_ACCOUNT() {

        List<AccountEntity> listaAccountEntity = authenticationService.getLista_ACCOUNT();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listaAccountEntity);
    }
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

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam Integer idSessione) {
            return ResponseEntity.ok(authenticationService.logout(idSessione));

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
