// kiritsu/resource/subscriptions/enums/PriorityConverter.java
package kiritsu.resource.subscriptions.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String> {

    @Override
    public String convertToDatabaseColumn(Priority priority) {
        return priority == null ? null : priority.name().toLowerCase();
    }

    @Override
    public Priority convertToEntityAttribute(String value) {
        return value == null ? null : Priority.valueOf(value.toUpperCase());
    }
}
