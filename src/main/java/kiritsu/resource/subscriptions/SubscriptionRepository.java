package kiritsu.resource.subscriptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, JpaSpecificationExecutor<Subscription> {

    Subscription findByUserSub(String userSub);
    Subscription findByUserSubAndId(String userSub, Long id);


}