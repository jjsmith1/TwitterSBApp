package com.tts.TechTalentTwitter.service;
import com.tts.TechTalentTwitter.configuration.Role;
import com.tts.TechTalentTwitter.configuration.User;
import com.tts.TechTalentTwitter.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class UserService {
    package com.tts.TechTalentTwitter.service;

    @Service
    public class UserService {

        private UserRepository userRepository;
        private RoleRepository roleRepository;
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Autowired

        public UserService(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;


        }
        public User findByUsername(String username) {
            return userRepository.findByUsername(username);
        }

        public List<User> findAll(){
            return (List<User>) userRepository.findAll();
        }

        public void save(User user) {
            userRepository.save(user);  //slide: 30 Springboot Twitter
        }
        public User saveNewUser(User user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(1);
            Role userRole = roleRepository.findByRole("USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            return userRepository.save(user);
        }
    }
}


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    public User getLoggedInUser() {
        String loggedInUsername = SecurityContextHolder.
                getContext().getAuthentication().getName();

        return findByUsername(loggedInUsername);
    }