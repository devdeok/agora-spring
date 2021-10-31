package com.demos.agora.web;

import com.demos.agora.service.LocationService;
import com.demos.agora.web.dto.CMResDto;
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
    public CMResDto<?> 근처주소검색(@RequestBody LocationReqDto locationReqDto) {
        return new CMResDto<>(1, locationService.근처주소검색(locationReqDto.getLongitude(), locationReqDto.getLatitude()));
    }

    @GetMapping("/location")
    public CMResDto<?> 주소검색(String address) {
        return new CMResDto<>(1, locationService.주소검색(address));
    }

    /*
     * @GetMapping("/location") public CMRespDto<?> 근처주소검색(double longitude, double
     * latitude) { return new CMRespDto(1, locationService.근처주소검색(longitude,
     * latitude)); }
     */
}
