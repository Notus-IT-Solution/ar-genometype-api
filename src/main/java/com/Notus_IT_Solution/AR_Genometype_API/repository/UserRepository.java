package com.Notus_IT_Solution.AR_Genometype_API.repository;

import com.Notus_IT_Solution.AR_Genometype_API.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
