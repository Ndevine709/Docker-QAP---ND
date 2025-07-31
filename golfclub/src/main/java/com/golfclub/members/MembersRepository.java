package com.golfclub.members;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends CrudRepository<Members, Long> {
    List<Members> findByName(String name);
    List<Members> findByPhoneNumber(String phone);
    List<Members> findByMembershipStartDate(String date);
} 
