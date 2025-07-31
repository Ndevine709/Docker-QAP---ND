package com.golfclub.members;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
    @Autowired
    private MembersRepository membersRepository;

    public List<Members> getAllMembers() {
        return (List<Members>) membersRepository.findAll();
    }

    public Members getMembersById(long id) {
        Optional<Members> optionalMembers = membersRepository.findById(id);
        return optionalMembers.orElse(null);
    }

    public List<Members> findByName(String name) {
        return membersRepository.findByName(name);
    }

    public List<Members> findByPhoneNumber(String phoneNumber) {
        return membersRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Members> findByMembershipStartDate(String membershipStartDate) {
        return membersRepository.findByMembershipStartDate(membershipStartDate);
    }

    public Members createMembers(Members newMembers) {
        return membersRepository.save(newMembers);
    }

    public void deleteMembers(long id) {
        membersRepository.deleteById(id);
    }
}
