package com.tts.TechTalentTwitter.model;

package com.tts.TechTalentTwitter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //lets compiler know the thing created is data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity  //create a thing
public class Tag {
    @Id   //primary key (long ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long id;

    private String phrase;

    @ManyToMany(mappedBy = "tags")
    private List<Tweet> tweets;

    // If Lombok doesn't work for you then use:
    // public Long getId() {
    // return id;
    // }

    // public String getPhrase() {
    // return phrase;
    // }

    // public void setPhrase(String phrase) {
    // this.phrase = phrase;
    // }

    // public List<Tweet> getTweets() {
    // return tweets;
    // }

    // public void setTweets(List<Tweet> tweets) {
    // this.tweets = tweets;
    // }

    // @Override
    // public String toString() {
    // return "Tag [id=" + id + ", phrase=" + phrase + ", tweets=" + tweets + "]";
    // }

}
