package com.liana.tpma.dao;

import org.springframework.data.repository.CrudRepository;

import com.liana.tpma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
