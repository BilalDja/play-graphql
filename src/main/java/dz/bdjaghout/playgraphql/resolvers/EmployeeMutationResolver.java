package dz.bdjaghout.playgraphql.resolvers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import dz.bdjaghout.playgraphql.dto.EmployeeInput;
import dz.bdjaghout.playgraphql.models.Department;
import dz.bdjaghout.playgraphql.models.Employee;
import dz.bdjaghout.playgraphql.models.Organization;
import dz.bdjaghout.playgraphql.repositories.DepartmentRepository;
import dz.bdjaghout.playgraphql.repositories.EmployeeRepository;
import dz.bdjaghout.playgraphql.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityNotFoundException;

/**
 * @author Bilal Djaghout on 1/4/2022 10:43 AM
 */

@DgsComponent
@RequiredArgsConstructor
public class EmployeeMutationResolver {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    @DgsData(parentType = "MutationResolver", field = "newEmployee")
    public Employee createEmployee(EmployeeInput input) {
        Department department = departmentRepository.findById(input.getDepartmentId()).orElseThrow(EntityNotFoundException::new);
        Organization organization = organizationRepository.findById(input.getOrganizationId()).orElseThrow(EntityNotFoundException::new);
        Employee employee = modelMapper.map(input, Employee.class);
        employee.setDepartment(department);
        employee.setOrganization(organization);
        return employeeRepository.save(employee);
    }
}
