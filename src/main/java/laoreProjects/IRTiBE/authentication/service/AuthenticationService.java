package laoreProjects.IRTiBE.authentication.service;

import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import laoreProjects.IRTiBE.authentication.jwtElements.JWTAuthenticationResponse;
import laoreProjects.IRTiBE.authentication.jwtElements.JWTService;
import laoreProjects.IRTiBE.authentication.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


//import it.laore.JWTAuth.controller.authentication.AuthenticationResponse;
//import it.laore.JWTAuth.controller.authentication.LoginRequest;
//import it.laore.JWTAuth.controller.manageUser.UserRequest;
//import it.laore.JWTAuth.entity.UserEntity;
//import it.laore.JWTAuth.repository.JWTRepository;
//import it.laore.JWTAuth.service.jwt.JWTService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager AuthenticationManager;

    public AccountEntity get_ACCOUNT_By_MATRICOLA(String matricola) {

        AccountEntity accountEntity = accountRepository.get_ACCOUNT_By_MATRICOLA(matricola)
                .orElseThrow();

        return accountEntity;
    }

    public JWTAuthenticationResponse login(AccountEntity accountRequest) {

        // Autentico lo user. Se l'autenticazione non va a buon fine viene lanciata un'eccezione
        AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountRequest.getMatricola(), accountRequest.getPassword()));

        AccountEntity accountEntity = accountRepository.get_ACCOUNT_By_MATRICOLA(accountRequest.getMatricola())
                .orElseThrow();

        String token = jwtService.generateToken(accountEntity.getMatricola());

        return JWTAuthenticationResponse
                .builder()
                .account(accountEntity)
                .accessToken(token)
                .build();
    }

    public JWTAuthenticationResponse createAccount(AccountEntity accountRequest) {
        AccountEntity accountEntity = AccountEntity.builder()
                .matricola(accountRequest.getMatricola())
                .password(passwordEncoder.encode(accountRequest.getPassword()))
                //.roles(createUserRequest.getRole())
                .build();

        String token = jwtService.generateToken(accountRequest.getMatricola());

        accountRepository.save(accountEntity);

        return JWTAuthenticationResponse
                .builder()
                .accessToken(token)
                .build();
    }

    public String deleteAccount(AccountEntity accountRequest) {

        AccountEntity accountEntity = accountRepository.get_ACCOUNT_By_MATRICOLA(accountRequest.getMatricola())
                .orElseThrow();

        accountRepository.delete_ACCOUNT_By_MATRICOLA(accountEntity.getMatricola());

        return "the user " + accountRequest.getMatricola() + " has been deleted";
    }

    public AccountEntity changePasswordAccount(AccountEntity accountRequest) {

        AccountEntity accountEntity = accountRepository.get_ACCOUNT_By_MATRICOLA(accountRequest.getMatricola())
                .orElseThrow();

        accountEntity.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        accountEntity.setReset_password(accountRequest.getReset_password());

        accountRepository.save(accountEntity);

        return accountEntity;
    }

}
