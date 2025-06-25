package theo.bank.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import theo.bank.authentication.dto.AuthenticationDTO;
import theo.bank.authentication.dto.LoginDTO;
import theo.bank.authentication.model.AuthenticationModel;
import theo.bank.authentication.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    AuthRepository repo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

    public ResponseEntity<AuthenticationDTO> registerAuth(AuthenticationDTO dto) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        AuthenticationModel auth = new AuthenticationModel();
        auth.setPassword(encoder.encode(dto.getPassword()));
        auth.setEmail(dto.getEmail());
        auth.setPin(dto.getPin());
        auth.setUserId(dto.getUserId());

        repo.save(auth);

        return ResponseEntity.ok().body(dto);
    }


    public String login(LoginDTO dto) {
        try{

            AuthenticationModel authenticationModel = repo.findByEmail(dto.getEmail());
            int user_id = authenticationModel.getUserId();
            if(authenticationModel != null){
                Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

                if(auth.isAuthenticated()){

                    return jwtService.generateToken(dto.getEmail(), user_id);
                }
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
