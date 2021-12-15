package kg.geektech.android3.data.model;

import com.google.gson.annotations.SerializedName;

public class Film {
    String id;
    String title;
    String description;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("release_date")
    String releaseDate;
    String image;

    public String getImage() {
        return image;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

}
