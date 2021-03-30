package com.liana.tpma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.liana.tpma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
