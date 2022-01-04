package dz.bdjaghout.playgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bilal Djaghout on 1/4/2022 10:50 AM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInput {
    private String firstname;
    private String lastname;
    private String position;
    private Integer salary;
    private Integer age;
    private Integer departmentId;
    private Integer organizationId;
}
