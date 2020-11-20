package com.javaengine.shader;

import java.util.HashMap;

public class ProgramInfo {
    private HashMap<String, Integer> attributes;

    public ProgramInfo() {
        attributes = new HashMap<>();
    }

    public void setAttribute(String key, Integer value) {
        attributes.put(key, value);
    }

    public Integer getAttribute(String name) {
        return attributes.get(name);
    }
}
