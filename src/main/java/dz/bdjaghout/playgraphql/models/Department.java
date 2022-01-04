package dz.bdjaghout.playgraphql.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Bilal Djaghout on 1/4/2022 1:28 AM
 */

@Data
@Entity
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
}
