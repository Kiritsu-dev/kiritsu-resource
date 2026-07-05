package kiritsu.resource.subscriptions.dtos;

import jakarta.validation.constraints.NotNull;
import kiritsu.resource.subscriptions.enums.Priority;
import lombok.Data;

@Data
public class PriorityDto {
    @NotNull
    private Long id;
    private Priority priority; // nullable — null means re-judge (move back to pending)
}
