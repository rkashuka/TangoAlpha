package edu.purdue.rkashuka.tangoalpha;

/**
 * Created by Rohan on 11/13/16.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



public class MultimediaInfo {
    private String format = null;
    private long duration = -1L;
    private AudioInfo audio = null;
    private VideoInfo video = null;

    public MultimediaInfo() {
    }

    public String getFormat() {
        return this.format;
    }

    void setFormat(String format) {
        this.format = format;
    }

    public long getDuration() {
        return this.duration;
    }

    void setDuration(long duration) {
        this.duration = duration;
    }

    public AudioInfo getAudio() {
        return this.audio;
    }

    void setAudio(AudioInfo audio) {
        this.audio = audio;
    }

    public VideoInfo getVideo() {
        return this.video;
    }

    void setVideo(VideoInfo video) {
        this.video = video;
    }

    public String toString() {
        return this.getClass().getName() + " (format=" + this.format + ", duration=" + this.duration + ", video=" + this.video + ", audio=" + this.audio + ")";
    }
}
