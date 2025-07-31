package com.golfclub.members;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import com.golfclub.tournaments.Tournaments;
import jakarta.persistence.*;

@Entity
public class Members {
    @Id
    @SequenceGenerator(name = "members_sequence", sequenceName = "members_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "members_sequence")

    private Long id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String membershipStartDate;
    private int membershipDuration;

    @ManyToMany (mappedBy = "members")
    private Set<Tournaments> tournaments;

    // Getters, setters & default constructor 
    public Members() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public int getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(int membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    public Set<Tournaments> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }

}
