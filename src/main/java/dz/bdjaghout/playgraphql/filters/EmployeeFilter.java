package dz.bdjaghout.playgraphql.filters;

import lombok.Data;

/**
 * @author Bilal Djaghout on 1/4/2022 2:26 AM
 */

@Data
public class EmployeeFilter {
    private FilterField salary;
    private FilterField age;
    private FilterField position;
}
