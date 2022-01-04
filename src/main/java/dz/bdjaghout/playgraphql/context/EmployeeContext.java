package dz.bdjaghout.playgraphql.context;

import dz.bdjaghout.playgraphql.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Djaghout on 1/4/2022 2:21 AM
 */

@Data
@AllArgsConstructor
public class EmployeeContext {
    private List<Employee> employees = new ArrayList<>();
}
