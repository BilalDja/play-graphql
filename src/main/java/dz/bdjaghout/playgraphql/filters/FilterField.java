package dz.bdjaghout.playgraphql.filters;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import java.util.function.Predicate;

/**
 * @author Bilal Djaghout on 1/4/2022 2:27 AM
 */

@Data
public class FilterField {
    private String operator;
    private String value;

    public Predicate generateCriteria(CriteriaBuilder builder, Path field) {
        try {
            int v = Integer.parseInt(value);
            switch (operator) {
                case "lt":
                    return (Predicate) builder.lt(field, v);
                case "le":
                    return (Predicate) builder.le(field, v);
                case "gt":
                    return (Predicate) builder.gt(field, v);
                case "ge":
                    return (Predicate) builder.ge(field, v);
                case "eq":
                    return (Predicate) builder.equal(field, v);
            }
        } catch (NumberFormatException e) {
            switch (operator) {
                case "endsWith":
                    return (Predicate) builder.like(field, "%" + value);
                case "startsWith":
                    return (Predicate) builder.like(field, value + "%");
                case "contains":
                    return (Predicate) builder.like(field, "%" + value + "%");
                case "eq":
                    return (Predicate) builder.like(field, value);
            }
        }
        return null;
    }
}
