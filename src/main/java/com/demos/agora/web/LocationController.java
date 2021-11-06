package com.demos.agora.web;

import com.demos.agora.service.LocationService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.location.LocationReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/location")
    public CMRespDto<?> 근처주소검색(@RequestBody LocationReqDto locationReqDto) {
        System.out.println("근접주소검색");
        System.out.println(locationReqDto.getLongitude());
        System.out.println(locationReqDto.getLatitude());
        return new CMRespDto<>(1, locationService.근처주소검색(locationReqDto.getLongitude(), locationReqDto.getLatitude()));
    }

    @GetMapping("/location")
    public CMRespDto<?> 주소검색(String address) {
        System.out.println("주소검색");
        return new CMRespDto<>(1, locationService.주소검색(address));
    }

    /*
     * @GetMapping("/location") public CMRespDto<?> 근처주소검색(double longitude, double
     * latitude) { return new CMRespDto(1, locationService.근처주소검색(longitude,
     * latitude)); }
     */
}
