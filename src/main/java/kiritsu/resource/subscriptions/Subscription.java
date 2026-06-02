package kiritsu.resource.subscriptions;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import kiritsu.resource.subscriptions.enums.Category;
import kiritsu.resource.subscriptions.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_sub")
    private String userSub;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Positive
    @DecimalMax("9999.99")
    private BigDecimal price;

    private Category category;
    private Priority priority;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;


}
