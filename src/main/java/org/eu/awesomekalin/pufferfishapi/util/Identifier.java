package org.eu.awesomekalin.pufferfishapi.util;

public class Identifier {
    public final String namespace;
    public final String path;

    public Identifier(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }
}
