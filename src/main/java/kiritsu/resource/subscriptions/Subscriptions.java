package kiritsu.resource.subscriptions;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_sub;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Positive
    @DecimalMax("9999.99")
    private float price;

    private enum category {
        gaming, streaming, learning, AI, phone, cloud
    };
    private enum priority {
        worth, not_worth
    };

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;


}
