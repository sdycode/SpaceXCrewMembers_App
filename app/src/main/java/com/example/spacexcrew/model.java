package com.example.spacexcrew;

import java.util.ArrayList;
import java.util.List;

public class model {
    public String name;
    public String agency;
    public String image;
    public String wikipedia;
    public ArrayList<String> launches;
    public String status;
    public String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public ArrayList<String> getLaunches() {
        return launches;
    }

    public void setLaunches(ArrayList<String> launches) {
        this.launches = launches;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
/*
    "name": "Robert Behnken",
        "agency": "NASA",
        "image": "https://imgur.com/0smMgMH.png",
        "wikipedia": "https://en.wikipedia.org/wiki/Robert_L._Behnken",
        "launches": [
            "5eb87d46ffd86e000604b388"
        ],
        "status": "active",
        "id": "5ebf1a6e23a9a60006e03a7a"
    */

}
