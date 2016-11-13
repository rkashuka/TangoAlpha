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

public class EncodingAttributes implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format = null;
    private Float offset = null;
    private Float duration = null;
    private edu.purdue.rkashuka.tangoalpha.AudioAttributes audioAttributes = null;
    private VideoAttributes videoAttributes = null;

    public EncodingAttributes() {
    }

    String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    Float getOffset() {
        return this.offset;
    }

    public void setOffset(Float offset) {
        this.offset = offset;
    }

    Float getDuration() {
        return this.duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    edu.purdue.rkashuka.tangoalpha.AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public void setAudioAttributes(edu.purdue.rkashuka.tangoalpha.AudioAttributes audioAttributes) {
        this.audioAttributes = audioAttributes;
    }

    VideoAttributes getVideoAttributes() {
        return this.videoAttributes;
    }

    public void setVideoAttributes(VideoAttributes videoAttributes) {
        this.videoAttributes = videoAttributes;
    }

    public String toString() {
        return this.getClass().getName() + "(format=" + this.format + ", offset=" + this.offset + ", duration=" + this.duration + ", audioAttributes=" + this.audioAttributes + ", videoAttributes=" + this.videoAttributes + ")";
    }
}

