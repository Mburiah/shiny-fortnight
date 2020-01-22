package models;

import java.util.Objects;

public class News {
    private String title;
    private String details;
    private int id;

    public News(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getDetails(), news.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDetails(), getId());
    }

}
