package laoreProjects.IRTiBE.authentication.jwtElements;

import com.fasterxml.jackson.annotation.JsonProperty;

import laoreProjects.IRTiBE.authentication.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTAuthenticationResponse {

    private Integer idSessione;
    private AccountEntity account;
    @JsonProperty("access_token")
    private String accessToken;


    //	  @JsonProperty("refresh_token")
//	  private String refreshToken;
}
