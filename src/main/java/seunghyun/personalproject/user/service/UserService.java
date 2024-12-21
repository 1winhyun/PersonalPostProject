package seunghyun.personalproject.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import seunghyun.personalproject.user.domain.User;
import seunghyun.personalproject.user.dto.AddUserRequestDTO;
import seunghyun.personalproject.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long addUser(AddUserRequestDTO requestDTO){
        User user=requestDTO.make();
        user.setPassword(bCryptPasswordEncoder.encode(requestDTO.getPassword()));
        return userRepository.save(user).getId();
    }
}