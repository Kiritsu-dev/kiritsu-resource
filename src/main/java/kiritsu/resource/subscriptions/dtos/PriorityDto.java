package kiritsu.resource.subscriptions.dtos;

import jakarta.validation.constraints.NotNull;
import kiritsu.resource.subscriptions.enums.Priority;
import lombok.Data;

@Data
public class PriorityDto {
    @NotNull
    private Long id;
    @NotNull
    private Priority priority;
}
