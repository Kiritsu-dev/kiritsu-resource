package kiritsu.resource.subscriptions;

import com.nimbusds.jwt.JWT;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService service) {
        this.subscriptionService = service;
    }

    @GetMapping()
    public ResponseEntity<List<Subscription>> getSubscriptions(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Priority priority
    ) {
        List<Subscription> results = subscriptionService.findSubscriptions(jwt.getSubject(),name, minPrice, maxPrice, category, priority);

        return ResponseEntity.ok(results);
    }

}
