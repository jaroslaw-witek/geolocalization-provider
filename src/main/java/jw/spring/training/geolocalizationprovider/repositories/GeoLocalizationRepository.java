package jw.spring.training.geolocalizationprovider.repositories;

import jw.spring.training.geolocalizationprovider.entities.Geolocalization;
//import jw.spring.training.geolocalizationcommon.entities.Geolocalization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeoLocalizationRepository extends PagingAndSortingRepository<Geolocalization, Long> {
    Page<Geolocalization> findAllByDeviceid(Long deviceId, Pageable paging);
}
