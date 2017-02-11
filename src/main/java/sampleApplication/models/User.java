package sampleApplication.models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <h1>User Entity!</h1>
 *
 * @author Arpit Khatri
 * @since 2017-02-10
 */

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private Long userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "EMAIL")
    private String email;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "USER_PHONEDETAILS",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PHONE_ID")})
    private Set<PhoneDetails> phoneDtls = new HashSet<PhoneDetails>();

    public User() {
    }
    public User(long id) {
        this.userId = id;
    }
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<PhoneDetails> getPhoneDtls() {
        return phoneDtls;
    }

    public void setMeetings(Set<PhoneDetails> phoneDtls) {
        this.phoneDtls = phoneDtls;
    }

    @Override
    public boolean equals(Object usr) {
        if (usr instanceof User) {
            User user = (User) usr;

            if (this.userName.equals(user.getUserName())
                    && this.email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.userName.hashCode() + this.email.hashCode();
    }

}