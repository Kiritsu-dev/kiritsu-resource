package kiritsu.resource.subscriptions;

import com.nimbusds.jwt.JWT;
import jakarta.validation.Valid;
import kiritsu.resource.subscriptions.dtos.SubscriptionRequest;
import kiritsu.resource.subscriptions.dtos.SubscriptionResponse;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(
            SubscriptionRepository repo) {
        this.subscriptionRepository = repo;
    }

    public List<SubscriptionResponse> findSubscriptions(String userSub, String name, BigDecimal minPrice, BigDecimal maxPrice
            , Category category, Priority priority) {

        List<Subscription> subs = subscriptionRepository.findSubscriptions(userSub, name, minPrice, maxPrice, category, priority);

        List<SubscriptionResponse> responses = new ArrayList<SubscriptionResponse>();

        for (Subscription sub: subs) {
            responses.add(SubscriptionResponse.from(sub));
        }
        return responses;
    }


    public SubscriptionResponse addSubscription(SubscriptionRequest request, String userSub) {

        Subscription subscription = new Subscription();
        subscription.setUserSub(userSub);
        subscription.setName(request.getName());
        subscription.setCategory(request.getCategory());
        subscription.setPriority(request.getPriority());

        return SubscriptionResponse.from( subscriptionRepository.save(subscription));

    }
}
