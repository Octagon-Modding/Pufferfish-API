package org.eu.awesomekalin.pufferfishapi.util;

import net.minecraft.resources.ResourceLocation;

public class Identifier {
    public final String namespace;
    public final String path;

    public Identifier(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public ResourceLocation convertToMinecraftIdentifier() {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }
}
