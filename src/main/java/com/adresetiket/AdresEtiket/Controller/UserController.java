package com.adresetiket.AdresEtiket.Controller;

import com.adresetiket.AdresEtiket.Entity.User;
import com.adresetiket.AdresEtiket.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        try{
            if (  user.UserName  == null || user.UserName.isEmpty() ) return "Kullanıcı Adını Girmelisiniz.";
            if (  user.Password  == null || user.Password.isEmpty() ) return "Şifre Girmelisiniz.";

            userService.createUser(user);
            return "Kayıt Başarılı";
        }catch(Exception ex){
            return ex.getMessage();
        }
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Integer userId, @RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }

    @GetMapping("/getlist")
    public List<User> getList(){
        return userService.getList();
    }

    @GetMapping("/getuser/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId){
        return userService.getUser(userId);
    }

    @PostMapping("/login")
    public boolean Login (@RequestBody User user) {

        User userSonuc = userService.getLoginUserName(user.UserName);
        if (userSonuc == null)
        {
            return false;

        }
        return  (userSonuc.Password.equals(user.Password));

    }
}