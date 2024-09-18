package com.inttao.npi.backend.util.domain;


/**
 * Modela un elemento de atributo
 * La idea que tenga un <nombre, valor>
 */
public class AttributeElement {
    public AttributeElement() {
    }

    public AttributeElement(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    private String attribute;
    private String value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
