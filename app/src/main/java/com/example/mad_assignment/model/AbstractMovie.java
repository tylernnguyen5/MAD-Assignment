package com.example.mad_assignment.model;

public abstract class AbstractMovie implements Movie{
    private int id;
    private String title;
    private int year;
    private String filename;

    public AbstractMovie(int id, String title, int year, String filename) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.filename = filename;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return  '{' + "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", filename='" + filename + '\'' +
                '}';
    }
}
