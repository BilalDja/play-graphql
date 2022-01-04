package dz.bdjaghout.playgraphql.resolvers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import dz.bdjaghout.playgraphql.context.EmployeeContext;
import dz.bdjaghout.playgraphql.context.EmployeeContextBuilder;
import dz.bdjaghout.playgraphql.filters.EmployeeFilter;
import dz.bdjaghout.playgraphql.filters.FilterField;
import dz.bdjaghout.playgraphql.models.Employee;
import dz.bdjaghout.playgraphql.repositories.EmployeeRepository;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

/**
 * @author Bilal Djaghout on 1/4/2022 1:52 AM
 */

@DgsComponent
@RequiredArgsConstructor
public class EmployeeQueryResolver {
    private final EmployeeRepository repository;
    private final EmployeeContextBuilder contextBuilder;

    @DgsData(parentType = "QueryResolver", field = "employees") // (3)
    public List<Employee> findAll() {
        List<Employee> employees = repository.findAll();
        contextBuilder.withEmployees(employees).build(); // (4)
        return employees;
    }

    @DgsData(parentType = "QueryResolver", field = "employee")
    public Employee findById(@InputArgument("id") Integer id,
                             DataFetchingEnvironment dfe) {
        EmployeeContext employeeContext = DgsContext.getCustomContext(dfe); // (5)
        List<Employee> employees = employeeContext.getEmployees();
        Optional<Employee> employeeOpt = employees.stream()
                .filter(employee -> employee.getId().equals(id)).findFirst();
        return employeeOpt.orElseGet(() ->
                repository.findById(id)
                        .orElseThrow(DgsEntityNotFoundException::new));
    }

    @DgsData(parentType = "QueryResolver", field = "employeesWithFilter")
    public Iterable<Employee> findWithFilter(@InputArgument("filter") EmployeeFilter filter) { // (6)
        Specification<Employee> spec = null;
        if (filter.getSalary() != null)
            spec = bySalary(filter.getSalary());
        if (filter.getAge() != null)
            spec = (spec == null ? byAge(filter.getAge()) : spec.and(byAge(filter.getAge())));
        if (filter.getPosition() != null)
            spec = (spec == null ? byPosition(filter.getPosition()) :
                    spec.and(byPosition(filter.getPosition())));
        if (spec != null)
            return repository.findAll(spec);
        else
            return repository.findAll();
    }

    private Specification<Employee> bySalary(FilterField filterField) {
        return (root, query, builder) ->
                (Predicate) filterField.generateCriteria(builder, root.get("salary"));
    }

    private Specification<Employee> byAge(FilterField filterField) {
        return (root, query, builder) ->
                (Predicate) filterField.generateCriteria(builder, root.get("age"));
    }

    private Specification<Employee> byPosition(FilterField filterField) {
        return (root, query, builder) ->
                (Predicate) filterField.generateCriteria(builder, root.get("position"));
    }
}
