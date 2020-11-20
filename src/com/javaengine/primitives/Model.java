package com.javaengine.primitives;

import org.joml.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private Vector3f position;
    private Vector3f scale;
    private Matrix4f rotation;
    private float[] vertices;
    private float[] normals;
    private int[] indices;

    public Model() {
        position = new Vector3f(0.0f, 0.0f, 0.0f);
        scale = new Vector3f(0.0f, 0.0f, 0.0f);
        rotation = new Matrix4f();
    }

    public Model(Vector3f pos, Vector3f scaleVal, Matrix4f rot) {
        position = pos;
        scale = scaleVal;
        rotation = rot;
    }

    public void setVertices(float[] verts) {
        vertices = verts;
    }

    public float[] getVertices() {
        return vertices;
    }

    public void setNormals(float[] norms) {
        normals = norms;
    }

    public float[] getNormals() {
        return normals;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] ind) {
        indices = ind;
    }
}
