package com.javaengine.primitives;

import com.javaengine.shader.ProgramInfo;
import com.javaengine.shader.ShaderProgram;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import static org.lwjgl.opengl.GL45C.*;

public class Primitive {
    protected ShaderProgram sProgram;
    protected Model model;
    protected Material material;
    protected ProgramInfo programInfo;
    protected int positionBuffer;
    protected int normalBuffer;
    protected int indexBuffer;
    protected int vao;

    public ShaderProgram getsProgram() {
        return sProgram;
    }

    public int getVao() {
        return vao;
    }

    public int getPositionBuffer() {
        return positionBuffer;
    }

    public Model getModel() {
        return model;
    }

    public void init() {
        this.vao = glGenBuffers();
        glBindVertexArray(vao);
        this.positionBuffer = initPositionAttribute();
//        this.normalBuffer = initNormalAttribute();
//        this.indexBuffer = initIndexBuffer();
        loadShaderProgram();
    }

    private void loadShaderProgram() {
        Integer shaderType = material.getShaderType();
        sProgram = new ShaderProgram();
        try {
            if (shaderType == 1) {
                sProgram.createFragmentShader(sProgram.readShaderFile("./shaders/basic.frag.glsl"));
                sProgram.createVertexShader(sProgram.readShaderFile("./shaders/basic.vert.glsl"));
                sProgram.link();
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public int initIndexBuffer() {
        int indexBuffer = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer);
        int[] indices = model.getIndices();
        IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
        buffer.put(indices);
        buffer.flip();

        glBufferData(
                GL_ELEMENT_ARRAY_BUFFER,
                indices,
                GL_STATIC_DRAW
        );

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

        return indexBuffer;
    }

    public int initPositionAttribute() {
        this.programInfo.setAttribute("vertexPosition", 0);
        int positionBuffer = glGenBuffers();

        glBindBuffer(GL_ARRAY_BUFFER, positionBuffer);
        glBufferData(
                GL_ARRAY_BUFFER,
                model.getVertices(),
                GL_STATIC_DRAW
        );


        glVertexAttribPointer(
                0,
                3,
                GL_FLOAT,
                false,
                0,
                0
        );

//        glBindBuffer(GL_ARRAY_BUFFER, 0);

        return positionBuffer;
    }

    public int initNormalAttribute() {
        programInfo.setAttribute("vertexNormal", 1);
        int normalBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, normalBuffer);
        glBufferData(
                GL_ARRAY_BUFFER,
                model.getVertices(),
                GL_STATIC_DRAW
        );


        glVertexAttribPointer(
                programInfo.getAttribute("vertexNormal"),
                3,
                GL_FLOAT,
                false,
                0,
                0
        );

        glEnableVertexAttribArray(programInfo.getAttribute("vertexNormal"));

        return normalBuffer;
    }

}
