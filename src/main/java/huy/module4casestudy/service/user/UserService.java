//package huy.module4casestudy.service.user;
//
//import huy.module4casestudy.configuration.DTO.UserPrinciple;
//import huy.module4casestudy.model.User;
//import huy.module4casestudy.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService implements IUserService, UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.findByUsername(username);
//        return UserPrinciple.build(user);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public User findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public User save(User user) {
//        return null;
//    }
//
//    @Override
//    public void delete(User user) {
//
//    }
//}
