package com.golfclub.tournaments;

import java.util.Set;

import com.golfclub.members.Members;

import jakarta.persistence.*;

@Entity
public class Tournaments {
    @Id
    @SequenceGenerator(name = "tournaments_sequence", sequenceName = "tournaments_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tournaments_sequence")
    
    private Long id;
    private String startDate;
    private String endDate;
    private String location;
    private double entryFee;
    private double cashPrize;

    @ManyToMany
    @JoinTable (
        name = "tournament_members",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Members> members;

    public Tournaments() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public Set<Members> getMembers() {
        return members;
    }

    public void setMembers(Set<Members> members) {
        this.members = members;
    }
}
