package huy.module4casestudy.service.user;

import huy.module4casestudy.configuration.DTO.UserPrinciple;
import huy.module4casestudy.model.User;
import huy.module4casestudy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return UserPrinciple.build(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not allowed to list add users");
    }

    @Override
    public Optional<User> findById(Long id) {
        throw new UnsupportedOperationException("Not allowed to find user by id");
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not allowed to save user");
    }

    @Override
    public void delete(User user) {
        user.setDisabled(true);
        userRepository.save(user);
    }
}
