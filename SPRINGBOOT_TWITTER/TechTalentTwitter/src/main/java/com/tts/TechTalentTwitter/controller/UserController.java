package com.tts.TechTalentTwitter.controller;

public class UserController {
    @Controller
    public class UserController {

        @Autowired
        private UserService userService;

        @Autowired
        private TweetService tweetService;

        /

        @GetMapping(value = "/users/{username}")
        public String getUser(@PathVariable(value = "username") String username, Model model) {
        }

        public String getUser(@PathVariable(value = "username") String username, Model model) {
            User user = userService.findByUsername(username);
            List<Tweet> tweets = tweetService.findAllByUser(user);
            model.addAttribute("tweetList", tweets);
            model.addAttribute("user", user);
            return "user";


        }
        @GetMapping(value = "/users")
        public String getUsers(Model model) {
            List<User> users = userService.findAll();
            model.addAttribute("users", users);
            SetTweetCounts(users, model);
            return "users";
        }
        private void SetTweetCounts(List<User> users, Model model) {
            HashMap<String,Integer> tweetCounts = new HashMap<>();
            for (User user : users) {
                List<Tweet> tweets = tweetService.findAllByUser(user);
                tweetCounts.put(user.getUsername(), tweets.size());
            }
            model.addAttribute("tweetCounts", tweetCounts);
        }
        boolean isSelfPage = loggedInUser.getUsername().equals(username)

    }

    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable(value = "username") String username, Model model) {
        User loggedInUser = userService.getLoggedInUser();
        User user = userService.findByUsername(username);
        List<Tweet> tweets = tweetService.findAllByUser(user);
        List<User> following = loggedInUser.getFollowing();
        boolean isFollowing = false;
        for (User followedUser : following) {
            if (followedUser.getUsername().equals(username)) {
                isFollowing = true;
            }
        }

        User loggedInUser = userService.getLoggedInUser();
        List<User> following = loggedInUser.getFollowing();
        boolean isFollowing = false;
        for (User followedUser : following) {
            if (followedUser.getUsername().equals(username)) {
                isFollowing = true;
            }
        }
        model.addAttribute("following", isFollowing);
        model.addAttribute("following", isFollowing);
        model.addAttribute("tweetList", tweets);
        model.addAttribute("user", user);
        return "user";

        boolean isSelfPage = loggedInUser.getUsername().equals(username);
        model.addAttribute("isSelfPage", isSelfPage);
    }

}
