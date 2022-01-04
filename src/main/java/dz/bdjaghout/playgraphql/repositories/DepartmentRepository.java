package dz.bdjaghout.playgraphql.repositories;

import dz.bdjaghout.playgraphql.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Bilal Djaghout on 1/4/2022
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
}
