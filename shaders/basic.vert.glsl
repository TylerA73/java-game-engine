#version 450
layout (location = 0) in vec3 vertexPosition;
//layout (location = 1) in vec3 vertexNormal;

//uniform mat4 projectionMatrix;
//uniform mat4 viewMatrix;
//uniform mat4 modelMatrix;

out vec4 glPosition;

void main() {
    //glPosition = projectionMatrix * viewMatrix * modelMatrix * vec4(vertexPosition, 1.0);
    gl_Position = vec4(vertexPosition, 1.0);
}