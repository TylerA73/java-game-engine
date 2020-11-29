package com.javaengine.camera;

import org.joml.Vector3f;
import org.joml.Matrix4f;

/**
 * Camera class
 */
public class Camera {
    // View
    private Vector3f up;
    private Vector3f center;
    private Vector3f position;

    // Projection
    private float fov; // Field of view
    private float aspectRatio;
    private float zNear;
    private float zFar;

    // MVP
    private Matrix4f projection;
    private Matrix4f view;
    private Matrix4f model;


    /**
     * Default constructor for camera class
     */
    public Camera() {
        this.up = new Vector3f(0.0f, 0.0f, 0.0f);
        this.center = new Vector3f(0.0f, 0.0f, 0.0f);
        this.position = new Vector3f(0.0f, 0.0f, 0.0f);
        this.fov = (float) Math.toRadians(45); // set default field of view of the camera to 45 degrees
        this.aspectRatio = (float) 4/3; // set default aspect ration of the camera to 4:3
        this.zNear = 0.1f;
        this.zFar = 100f;
    }

    /**
     * Constructor for the Camera class
     * @param up
     * @param center
     * @param position
     */
    public Camera(Vector3f up, Vector3f center, Vector3f position) {
        this(); // default constructor

        this.up = up;
        this.center = center;
        this.position = position;
    }

    /**
     * Constructor for the Camera class
     * @param fov
     * @param aspectRatio
     * @param zNear
     * @param zFar
     */
    public Camera(float fov, float aspectRatio, float zNear, float zFar) {
        this(); // default constructor

        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.zNear = zNear;
        this.zFar = zFar;
    }

    /**
     * Constructor for the Camera class
     * @param up
     * @param center
     * @param position
     * @param fov
     * @param aspectRatio
     * @param zNear
     * @param zFar
     */
    Camera(Vector3f up, Vector3f center, Vector3f position, float fov, float aspectRatio, float zNear, float zFar) {
        this.up = up;
        this.center = center;
        this.position = position;
        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.zNear = zNear;
        this.zFar = zFar;
    }

    /**
     * Calculates the Model View Projection of the Camera
     * @return Matrix4f
     */
    public Matrix4f getMVP() {
        return this.projection.mul(this.view.mul(this.model));
    }

    /**
     * Change the view of the camera
     * @param position
     * @param center
     * @param up
     * @return Matrix4f
     */
    public Matrix4f lookAt(Vector3f position, Vector3f center, Vector3f up) {
        this.position = position;
        this.center = center;
        this.up = up;
        view = new Matrix4f().lookAt(this.position, this.center, this.up);

        return getMVP();
    }

    /**
     * Change the perspective of the camera
     * @param fov
     * @param aspectRatio
     * @param zNear
     * @param zFar
     * @return Matrix4f
     */
    public Matrix4f perspective(float fov, float aspectRatio, float zNear, float zFar) {
        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.zNear = zNear;
        this.zFar = zFar;
        projection = new Matrix4f().perspective(this.fov, this.aspectRatio, this.zNear, this.zFar);

        return getMVP();
    }

    public Vector3f getUp() {
        return up;
    }

    public void setUp(Vector3f up) {
        this.up = up;
    }

    public Vector3f getCenter() {
        return center;
    }

    public void setCenter(Vector3f center) {
        this.center = center;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public float getFov() {
        return fov;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public float getzNear() {
        return zNear;
    }

    public void setzNear(float zNear) {
        this.zNear = zNear;
    }

    public float getzFar() {
        return zFar;
    }

    public void setzFar(float zFar) {
        this.zFar = zFar;
    }

    public Matrix4f getProjection() {
        return projection;
    }

    public void setProjection(Matrix4f projection) {
        this.projection = projection;
    }

    public Matrix4f getView() {
        return view;
    }

    public void setView(Matrix4f view) {
        this.view = view;
    }

    public Matrix4f getModel() {
        return model;
    }

    public void setModel(Matrix4f model) {
        this.model = model;
    }
}
