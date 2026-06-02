package kiritsu.resource.subscriptions.dtos;

import kiritsu.resource.subscriptions.Subscription;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SubscriptionResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Priority priority;
    private LocalDateTime created_at;

    public SubscriptionResponse toResponse(Subscription subscription) {
        SubscriptionResponse response = new SubscriptionResponse();
        response.id = subscription.getId();
        response.name = subscription.getName();
        response.price = subscription.getPrice();
        response.category = subscription.getCategory();
        response.priority = subscription.getPriority();
        response.created_at = subscription.getCreated_at();

        return response;
    }
}
