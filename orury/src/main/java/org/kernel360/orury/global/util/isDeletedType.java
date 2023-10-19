package org.kernel360.orury.global.util;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum isDeletedType {
    TRUE(true, "1"), LIKE(false, "0");

    private boolean code;
    private String type;

    private isDeletedType(boolean code, String type) {
        this.code = code;
        this.type = type;
    }

    public static isDeletedType ofCode(boolean code) {
        return Arrays.stream(isDeletedType.values())
                .filter(e -> e.getCode() == code)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public static isDeletedType ofType(String type) {
        return Arrays.stream(isDeletedType.values())
                .filter(e -> e.getType().equals(type))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public boolean getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }
}
