package kiritsu.resource.subscriptions;

import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findSubscriptions(String userSub,
            String name, BigDecimal minPrice, BigDecimal maxPrice
            , Category category, Priority priority
    );

    Subscription findByUserSub(String userSub);
    Subscription findByUserSubAndId(String userSub, Long id);
}
