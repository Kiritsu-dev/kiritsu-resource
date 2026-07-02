// kiritsu/resource/subscriptions/enums/CategoryConverter.java
package kiritsu.resource.subscriptions.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        return category == null ? null : category.name().toLowerCase();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        return value == null ? null : Category.valueOf(value.toUpperCase());
    }
}
