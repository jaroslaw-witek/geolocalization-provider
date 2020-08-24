package jw.spring.training.geolocalizationprovider.service;

import jw.spring.training.geolocalizationprovider.dto.GeoLocalizationDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
//import jw.spring.training.geolocalizationcommon.dto.GeoLocalizationDTO;

public interface GeoLocalizationService {
    List<GeoLocalizationDTO> getAllGeoLocalizations();
    List<GeoLocalizationDTO> getAllGeoLocalizations(Pageable paging);
    GeoLocalizationDTO addGeolocalization(GeoLocalizationDTO geoLocalizationDTO);
    List<GeoLocalizationDTO> getAllGeoLocalizationsByDeviceId(Long deviceId, Pageable paging);
}
