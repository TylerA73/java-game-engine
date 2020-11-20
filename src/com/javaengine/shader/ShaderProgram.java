package com.javaengine.shader;

import org.lwjgl.opengl.GL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL45C.*;

public class ShaderProgram {
    private final int programId;
    private int vertexShaderId;
    private int fragmentShaderId;
    private String fragShaderSource;
    private String vertShaderSource;

    public String getFragShaderSource() {
        return fragShaderSource;
    }

    public String getVertShaderSource() {
        return vertShaderSource;
    }

    public ShaderProgram() {
        programId = glCreateProgram();
    }

    public String readShaderFile(String path) throws IOException {
        String shaderCode = null;

        try {
            FileReader fr = new FileReader(path);

            char[] dest = new char[1024];
            int status = fr.read(dest);

            if (status == -1) {
                throw new RuntimeException("Could not load vertex shader");
            }
            shaderCode = new String(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return shaderCode;
    }

    public void bind() {
        glUseProgram(programId);
    }

    public void unbind() {
        glUseProgram(0);
    }

    public void cleanup() {
        unbind();

        if (programId != 0) {
            glDeleteProgram(programId);
        }
    }

    public void createVertexShader(String shaderCode) throws Exception {
        vertShaderSource = shaderCode;
        vertexShaderId = createShader(shaderCode, GL_VERTEX_SHADER);
    }

    public void createFragmentShader(String shaderCode) throws Exception {
        fragShaderSource = shaderCode;
        fragmentShaderId = createShader(shaderCode, GL_FRAGMENT_SHADER);
    }

    protected int createShader(String shaderCode, int shaderType) throws Exception {
        int shaderId = glCreateShader(shaderType);
        if (shaderId == 0) {
            throw new Exception("Error creating shader. Type: " + shaderType);
        }

        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);

        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
            throw new Exception("Error compiling Shader code: " + glGetShaderInfoLog(shaderId, 1024));
        }

        glAttachShader(programId, shaderId);

        return shaderId;
    }

    public void link() throws Exception {
        glLinkProgram(programId);
        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(programId, 1024));
        }

        if (vertexShaderId != 0) {
            glDetachShader(programId, vertexShaderId);
        }
        if (fragmentShaderId != 0) {
            glDetachShader(programId, fragmentShaderId);
        }

        glValidateProgram(programId);
        if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(programId, 1024));
        }
    }
}
