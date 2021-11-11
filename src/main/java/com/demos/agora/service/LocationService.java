
package com.demos.agora.service;

import com.demos.agora.model.location.Location;
import com.demos.agora.model.location.LocationRepository;
import com.jhlabs.map.proj.Projection;
import com.jhlabs.map.proj.ProjectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.Point2D;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private String[] proj4 = new String[] { "+proj=tmerc", "+lat_0=38", "+lon_0=127.5", "+k=0.9996", "+x_0=1000000",
            "+y_0=2000000", "+ellps=GRS80", "+units=m +no_defs" };
    private Projection proj = ProjectionFactory.fromPROJ4Specification(proj4);

    @Transactional(readOnly = true)
    public List<Location> 근처주소검색(double longitude, double latitude) {
        Point2D.Double WG84 = new Point2D.Double(longitude, latitude);
        Point2D.Double UTMK = proj.transform(WG84, new Point2D.Double());

        return locationRepository.근처주소검색(UTMK.getX(), UTMK.getY());
    }

    @Transactional(readOnly = true)
    public List<Location> 주소검색(String address) {
        return locationRepository.주소검색(address);
    }
}
