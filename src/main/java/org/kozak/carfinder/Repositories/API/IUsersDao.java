package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUsersDao extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findUsersEntitiesByEmail(String email);
    UsersEntity findUsersEntitiesByAccountByAccountid(AccountEntity accountEntity);
}
