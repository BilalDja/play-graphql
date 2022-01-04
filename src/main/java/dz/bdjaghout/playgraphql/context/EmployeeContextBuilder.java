package dz.bdjaghout.playgraphql.context;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import dz.bdjaghout.playgraphql.models.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bilal Djaghout on 1/4/2022 2:20 AM
 */

@Component
public class EmployeeContextBuilder implements DgsCustomContextBuilder<EmployeeContext> {
    private List<Employee> employees;

    public EmployeeContextBuilder withEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }


    @Override
    public EmployeeContext build() {
        return new EmployeeContext(employees);
    }
}
