package org.kernel360.orury.board.post.util;

import javax.persistence.AttributeConverter;

public class isDeletedConverter implements AttributeConverter<isDeletedType, String>{
        @Override
        public String convertToDatabaseColumn(isDeletedType isDeletedType) {
            return isDeletedType.getType();
        }

        @Override
        public isDeletedType convertToEntityAttribute(String type) {
            return isDeletedType.ofType(type);
        }
}
