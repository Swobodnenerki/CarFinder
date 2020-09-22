package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.RolesEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRolesDao extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findRolesEntitiesByAccountByAccountid(AccountEntity account);
}
