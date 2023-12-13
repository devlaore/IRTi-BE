package laoreProjects.IRTiBE.authentication.jwtElements;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class JWTUserDetails implements UserDetails {

    //private final User_Entity userEntity;
    private String matricola;
    private String password;
    private List<GrantedAuthority> roles;

    public JWTUserDetails(String matricola, String password) {
        this.matricola = matricola;
        this.password = password;
    }

    public JWTUserDetails(AccountEntity accountEntity) {
        this.matricola = accountEntity.getMatricola();
        this.password = accountEntity.getPassword();
        //this.roles = Arrays.stream(accountEntity.getRoles().split(";")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return matricola;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
