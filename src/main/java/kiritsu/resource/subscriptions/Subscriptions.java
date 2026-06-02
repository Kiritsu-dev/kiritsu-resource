package kiritsu.resource.subscriptions;

import jakarta.persistence.*;
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

    private String name;

    private float price;

    private enum category {
        gaming, streaming, learning, AI, phone, cloud
    };

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;


}
