package sampleApplication.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <h1>Phone Details Entity!</h1>
 *
 * @author Arpit Khatri
 * @since 2017-02-10
 */

@Entity
@Table(name = "PHONEDETAILS")
public class PhoneDetails {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue
    private Long phoneId;
    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToMany(mappedBy = "phoneDtls")
    private Set<User> users = new HashSet<User>();

    public PhoneDetails(Long phoneId, int phoneNumber, String description) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
