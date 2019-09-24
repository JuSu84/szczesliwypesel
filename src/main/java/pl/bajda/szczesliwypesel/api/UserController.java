package pl.bajda.szczesliwypesel.api;

import org.springframework.web.bind.annotation.*;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping({"id"})
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/name{name}")
    public List<User> getUserByName(@PathVariable("name") String name){
        return userService.getUserByName(name.toLowerCase());
    }

    @DeleteMapping({"id"})
    public void deleteUserById(@PathVariable("id") Long id){
         userService.deleteUserById(id);
    }

    @PutMapping({"id"})
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }


}
