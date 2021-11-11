
package com.demos.agora.model.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,String> {

    @Query(value = "SELECT * " +
                    "FROM Location " +
                    "WHERE entX>=?1-1800 " +
                            "AND entX<=?1+2000 " +
                            "AND entY>=?2-1800 " +
                            "AND entY<=?2+1800 " +
                    "order by entX  ASC", nativeQuery = true)
    List<Location> 근처주소검색(double entX, double entY);

    @Query(value = "SELECT * " +
                    "FROM Location " +
                    "where ghhjd Like %?1% " +
                            "OR sggm like %?1% " +
                            "OR sggm like %?1%",nativeQuery = true)
    List<Location> 주소검색(String address);
}
