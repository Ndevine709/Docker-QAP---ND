package com.golfclub.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MembersController {
    @Autowired
    private MembersService membersService;

    // Get all members
    @GetMapping("/members")
    public List<Members> getAllMembers() {
        return membersService.getAllMembers();
    }
    
    // Get members by ID
    @GetMapping("/members/{id}")
    public Members getMembersById(@PathVariable long id) {
        return membersService.getMembersById(id);
    }

    // Find a member by name
    @GetMapping("/members/name")
    public List<Members> findByName(@RequestParam String name) {
        return membersService.findByName(name);
    }

    // Find a member by their phone number
    @GetMapping("/members/phone")
    public List<Members> findByPhoneNumber(@RequestParam String phoneNumber) {
        return membersService.findByPhoneNumber(phoneNumber);
    }

    // Find a member by their membership start date
    @GetMapping("/members/start-date")
    public List<Members> findByMembershipStartDate(@RequestParam String membershipStartDate) {
        return membersService.findByMembershipStartDate(membershipStartDate);
    }

    // Create a new member
    @PostMapping("/members")
    public Members createMembers(@RequestBody Members members) {
        return membersService.createMembers(members);
    }

    // Delete members
    @DeleteMapping("/members/{id}")
    public void deleteMembers(@PathVariable long id) {
        membersService.deleteMembers(id);
    }
}
