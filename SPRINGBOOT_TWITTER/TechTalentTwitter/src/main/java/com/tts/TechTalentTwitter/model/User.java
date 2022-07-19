package com.tts.TechTalentTwitter.model;

public class User{@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "user_follower", joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "follower_id"))
private List<User> followers;
}
    @ManyToMany(mappedBy="followers")
    private List<User> following;