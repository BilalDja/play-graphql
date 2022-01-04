package dz.bdjaghout.playgraphql.repositories;

import dz.bdjaghout.playgraphql.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Bilal Djaghout on 1/4/2022
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {
}
