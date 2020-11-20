package com.javaengine.primitives;

import com.javaengine.shader.ProgramInfo;
import com.javaengine.shader.ShaderProgram;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Primitive {

    private float[] vertices = {
            0.0f, 0.5f, 0.5f,
            0.0f, 0.5f, 0.0f,
            0.5f, 0.5f, 0.0f,
            0.5f, 0.5f, 0.5f
    };

    private float[] normals = {
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f
    };

    private int[] indices = {
            0, 2, 1, 2, 0, 3
    };

    public Plane() {
        super.model = new Model();
        super.material = new Material();
        super.programInfo = new ProgramInfo();
    }

    public Plane(Material mat, Model model) {
        super.model = model;
        super.material = mat;
        super.programInfo = new ProgramInfo();
    }

    @Override
    public void init() {
        super.model.setVertices(vertices);
        super.model.setNormals(normals);
        super.model.setIndices(indices);
        super.init();
    }

    @Override
    public int initPositionAttribute() {
        return super.initPositionAttribute();
    }

    @Override
    public int initNormalAttribute() {
        return super.initNormalAttribute();
    }

    @Override
    public int initIndexBuffer() {
        return super.initIndexBuffer();
    }
}
