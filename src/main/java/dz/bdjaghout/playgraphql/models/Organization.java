package dz.bdjaghout.playgraphql.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Bilal Djaghout on 1/3/2022 10:04 PM
 */

@Data
@Entity
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "organization")
    private Set<Department> departments;
    @OneToMany(mappedBy = "organization")
    private Set<Employee> employees;
}
