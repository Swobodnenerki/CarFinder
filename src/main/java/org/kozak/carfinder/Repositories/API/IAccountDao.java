package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountDao extends JpaRepository<AccountEntity, Integer>{
    AccountEntity findAccountEntitiesByLogin(String login);
}
