package com.javaengine.primitives;

import com.javaengine.shader.ProgramInfo;

public class Cube extends Primitive {

    private float[] vertices = {
            0.0f, 0.0f, 0.0f,
            0.0f, 0.5f, 0.0f,
            0.5f, 0.5f, 0.0f,
            0.5f, 0.0f, 0.0f,

            0.0f, 0.0f, 0.5f,
            0.0f, 0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,
            0.5f, 0.0f, 0.5f,

            0.0f, 0.5f, 0.5f,
            0.0f, 0.5f, 0.0f,
            0.5f, 0.5f, 0.0f,
            0.5f, 0.5f, 0.5f,

            0.0f, 0.0f, 0.5f,
            0.5f, 0.0f, 0.5f,
            0.5f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f,

            0.5f, 0.0f, 0.5f,
            0.5f, 0.0f, 0.0f,
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, 0.0f,

            0.0f, 0.0f, 0.5f,
            0.0f, 0.0f, 0.0f,
            0.0f, 0.5f, 0.5f,
            0.0f, 0.5f, 0.0f
    };

    private float[] normals = {
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,

            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,

            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,

            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,

            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,

            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f
    };

    private int[] indices = {
            //front face
            2, 0, 1, 3, 0, 2,
            //backface
            5, 4, 6, 6, 4, 7,
            //top face
            10, 9, 8, 10, 8, 11,
            //bottom face
            13, 12, 14, 14, 12, 15,
            //
            18, 16, 17, 18, 17, 19,

            22, 21, 20, 23, 21, 22,
    };

    public Cube() {
        super.model = new Model();
        super.material = new Material();
        super.programInfo = new ProgramInfo();
    }

    public Cube(Material mat, Model model) {
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
