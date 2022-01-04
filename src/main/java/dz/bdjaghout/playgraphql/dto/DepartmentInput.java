package dz.bdjaghout.playgraphql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bilal Djaghout on 1/4/2022 1:33 AM
 */

@Data
@NoArgsConstructor
public class DepartmentInput {
    private String name;
    private Integer organizationId;
}
