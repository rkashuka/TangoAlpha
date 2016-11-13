package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;


import java.io.Serializable;

public class VideoSize implements Serializable {
    private static final long serialVersionUID = 1L;
    private int width;
    private int height;

    public VideoSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return this.getClass().getName() + " (width=" + this.width + ", height=" + this.height + ")";
    }
}
