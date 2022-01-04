package dz.bdjaghout.playgraphql.repositories;

import dz.bdjaghout.playgraphql.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Bilal Djaghout on 1/4/2022
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
