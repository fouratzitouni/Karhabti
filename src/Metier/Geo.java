package Metier;

public class Geo
{
    String mat, lat,lon;

    public Geo(String mat, String lat, String lon) {
        this.mat = mat;
        this.lat = lat;
        this.lon = lon;
    }

    public String getMat() {
        return mat;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
    
    
}