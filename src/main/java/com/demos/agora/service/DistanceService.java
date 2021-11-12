
package com.demos.agora.service;

public class DistanceService {
    // 사용되는 위도와 경도는 WGS84 type
    private static double distance(double lat1, double long1, double lat2, double long2){
        double theta = long1 - long2;
        double dist = Math.sin(deg2rad(lat1))*Math.sin(deg2rad(lat2)) +
                Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        dist = dist * 1.609344; // 최종
        dist = Math.round(dist * 10)/10.0; // 소수점 첫째자리까지만 나타냄

        return dist;
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}

