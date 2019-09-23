package pl.bajda.szczesliwypesel.services;

import org.assertj.core.util.Lists;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private EmailService emailService;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, User.class.getName()));
    }

    public List<User> getUserByName(String name) {
        return Lists.newArrayList(userRepository.findByName(name));
    }

    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(id, User.class.getName());
        }
    }

    public User updateUser(Long id, User user){
        User foundUser = userRepository.findById(id)
                .orElseThrow(() ->new ObjectNotFoundException(id, User.class.getName()));

                foundUser.setName(user.getName());

                return userRepository.save(foundUser);
    }



}
