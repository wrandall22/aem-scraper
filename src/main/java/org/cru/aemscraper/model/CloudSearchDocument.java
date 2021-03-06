package org.cru.aemscraper.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonPropertyOrder({
    "type",
    "id",
    "fields"
})
public abstract class CloudSearchDocument {
    public enum Type {
        ADD, DELETE;

        public static Type fromCode(final String code) {
            String upperCase = code.toUpperCase();
            switch (upperCase) {
                case "ADD":
                    return ADD;
                case "DELETE":
                    return DELETE;
                default:
                    throw new IllegalArgumentException("Invalid code: " + code);
            }
        }
    }

    private String id;
    private Map<String, Object> fields;

    public abstract String getType();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(final Map<String, Object> fields) {
        this.fields = fields;
    }
}
