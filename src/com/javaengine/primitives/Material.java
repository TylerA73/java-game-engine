package com.javaengine.primitives;

import org.joml.Vector3f;

public class Material {
    private Vector3f ambientValue;
    private Vector3f diffuseValue;
    private Vector3f specularValue;
    private Float nValue;
    private Integer shaderType;

    public Material() {
        ambientValue = new Vector3f(0.5f, 0.5f, 0.5f);
        diffuseValue = new Vector3f(0.5f, 0.5f, 0.5f);
        specularValue = new Vector3f(0.5f, 0.5f, 0.5f);
        nValue = 1.0f;
        shaderType = 1;
    }

    public Material(Vector3f ambient, Vector3f diffuse, Vector3f specular, Float n, Integer shadType) {
        ambientValue = ambient;
        diffuseValue = diffuse;
        specularValue = specular;
        nValue = n;
        shaderType = shadType;
    }

    public Integer getShaderType() {
        return shaderType;
    }

    public Float getnValue() {
        return nValue;
    }

    public Vector3f getAmbientValue() {
        return ambientValue;
    }

    public Vector3f getDiffuseValue() {
        return diffuseValue;
    }

    public Vector3f getSpecularValue() {
        return specularValue;
    }
}
