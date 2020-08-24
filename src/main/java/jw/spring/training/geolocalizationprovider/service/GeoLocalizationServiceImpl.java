package jw.spring.training.geolocalizationprovider.service;

import jw.spring.training.geolocalizationprovider.dto.GeoLocalizationDTO;
import jw.spring.training.geolocalizationprovider.entities.Geolocalization;
import jw.spring.training.geolocalizationprovider.repositories.GeoLocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;
//import jw.spring.training.geolocalizationcommon.dto.GeoLocalizationDTO;
//import jw.spring.training.geolocalizationcommon.entities.Geolocalization;

@Service
public class GeoLocalizationServiceImpl implements GeoLocalizationService{

    private final GeoLocalizationRepository geoLocalizationRepository;

    @Autowired
    public GeoLocalizationServiceImpl(GeoLocalizationRepository geoLocalizationRepository){
        this.geoLocalizationRepository = geoLocalizationRepository;
    }

    public List<GeoLocalizationDTO> getAllGeoLocalizations(Pageable paging){

        Page<Geolocalization> pagedResult = geoLocalizationRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent().stream().map(geolocalization -> new GeoLocalizationDTO(geolocalization)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<GeoLocalizationDTO> getAllGeoLocalizationsByDeviceId(Long deviceId, Pageable paging){

        Page<Geolocalization> pagedResult = geoLocalizationRepository.findAllByDeviceid(deviceId, paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent().stream().map(geolocalization -> new GeoLocalizationDTO(geolocalization)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<GeoLocalizationDTO> getAllGeoLocalizations(){
        Iterable<Geolocalization> geolocalizations = this.geoLocalizationRepository.findAll();
        List<GeoLocalizationDTO> dtosList = new ArrayList<>();
        geolocalizations.forEach(geolocalization -> dtosList.add(new GeoLocalizationDTO(geolocalization)));
        return dtosList;
    }

    public GeoLocalizationDTO addGeolocalization(GeoLocalizationDTO geoLocalizationDTO){
        Geolocalization geolocalization = new Geolocalization();
        geolocalization.setDeviceid(geoLocalizationDTO.getDeviceId());
        geolocalization.setLatitude(geoLocalizationDTO.getLatitude());
        geolocalization.setLongitude(geoLocalizationDTO.getLongitude());
        geolocalization.setLogdate(new Date());

        return new GeoLocalizationDTO(geoLocalizationRepository.save(geolocalization));
    }
}
