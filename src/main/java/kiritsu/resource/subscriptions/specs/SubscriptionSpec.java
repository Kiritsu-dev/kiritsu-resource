package kiritsu.resource.subscriptions.specs;

import kiritsu.resource.subscriptions.Subscription;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class SubscriptionSpec {

    public static Specification<Subscription> filter(
            String userSub, String name,
            BigDecimal minPrice, BigDecimal maxPrice,
            Category category, Priority priority) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.equal(root.get("userSub"), userSub));

            if (name != null)
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            if (minPrice != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            if (maxPrice != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            if (category != null)
                predicates.add(cb.equal(root.get("category"), category));
            if (priority != null)
                predicates.add(cb.equal(root.get("priority"), priority));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}