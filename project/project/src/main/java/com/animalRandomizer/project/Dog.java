package com.animalRandomizer.project;

public class Dog {
    public int id;
    private String imageUrl;
    private String imageName;
    private String info;
    private int counter;


    public Dog(int id, String imageUrl, String imageName, String info, int counter) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
        this.info = info;
        this.counter = counter;
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getimageName() {

        return imageName;
    }

    public void setimageName(String imageName) {

        this.imageName = imageName;
    }

    public String getInfo() {

        return info;
    }

    public void setInfo(String info) {

        this.info = info;
    }

    public int getCounter() {

        return counter;
    };

    public void setCounter(int counter) {

        this.counter=counter;
    }

    @Override
    public String toString() {
        return "Dog{" +
                ", imageUrl='" + imageUrl + '\'' +
                ", id=" + id +
                ", pictureName='" + imageName + '\'' +
                ", info='" + info + '\'' +
                ", counter=" + counter +
                '}';
    }
}
