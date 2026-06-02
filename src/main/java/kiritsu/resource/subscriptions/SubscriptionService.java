package kiritsu.resource.subscriptions;

import com.nimbusds.jwt.JWT;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(
            SubscriptionRepository repo) {
        this.subscriptionRepository = repo;
    }

    public List<Subscription> findSubscriptions(String userSub, String name, BigDecimal minPrice, BigDecimal maxPrice
            , Category category, Priority priority) {

        return subscriptionRepository.findSubscriptions(userSub, name, minPrice, maxPrice, category, priority);
    }
}
