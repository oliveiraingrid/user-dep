package com.devsuperior.userdept.repositories;

import com.devsuperior.userdept.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

}
