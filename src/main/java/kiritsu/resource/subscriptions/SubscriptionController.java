package kiritsu.resource.subscriptions;
import com.nimbusds.jwt.JWT;
import jakarta.validation.Valid;
import kiritsu.resource.subscriptions.dtos.SubscriptionRequest;
import kiritsu.resource.subscriptions.dtos.SubscriptionResponse;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Priority priority
    ) {
        List<SubscriptionResponse> results = subscriptionService.findSubscriptions(jwt.getSubject(),name, minPrice, maxPrice, category, priority);

        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponse> postSubscription(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody SubscriptionRequest request
    ) {
        // check for duplication
        SubscriptionResponse response = subscriptionService.addSubscription(request, jwt.getSubject());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
