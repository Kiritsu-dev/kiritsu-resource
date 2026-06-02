package kiritsu.resource.subscriptions.dtos;

import jakarta.validation.constraints.*;
import kiritsu.resource.subscriptions.Subscription;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.objenesis.SpringObjenesis;

import java.math.BigDecimal;

@Data
public class SubscriptionRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Positive
    @DecimalMax("9999.99")
    private BigDecimal price;

    private Category category;
    private Priority priority;

    public Subscription toSubscription(SubscriptionRequest request) {
        Subscription subscription = new Subscription();
        subscription.setName(this.name);
        subscription.setPrice(this.price);
        subscription.setCategory(this.category);
        subscription.setPriority(this.priority);

        return subscription;
    }

}
