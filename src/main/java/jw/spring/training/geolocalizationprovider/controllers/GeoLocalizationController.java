package jw.spring.training.geolocalizationprovider.controllers;

import jw.spring.training.geolocalizationprovider.dto.GeoLocalizationDTO;
import jw.spring.training.geolocalizationprovider.service.GeoLocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
//import jw.spring.training.geolocalizationcommon.dto.GeoLocalizationDTO;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/geo-localizations")
public class GeoLocalizationController {

    private final GeoLocalizationService geoLocalizationService;

    @Autowired
    public GeoLocalizationController(GeoLocalizationService geoLocalizationService) {
        this.geoLocalizationService = geoLocalizationService;
    }

    @GetMapping
    public ResponseEntity<List<GeoLocalizationDTO>> getGeoLocalizations(Pageable pageable) {
        return new ResponseEntity<List<GeoLocalizationDTO>>(geoLocalizationService.getAllGeoLocalizations(pageable),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{deviceid}")
    public ResponseEntity<List<GeoLocalizationDTO>> getGeoLocalizationsByDeviceId(@PathVariable Long deviceid, Pageable pageable) {
        List<GeoLocalizationDTO> geolocalizations = geoLocalizationService.getAllGeoLocalizationsByDeviceId(deviceid, pageable);
        if(! CollectionUtils.isEmpty(geolocalizations)){
            return new ResponseEntity<List<GeoLocalizationDTO>>(geolocalizations,
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<GeoLocalizationDTO> postGeoLocalizations(@Validated @RequestBody GeoLocalizationDTO geoLocalizationDTO) {
        return new ResponseEntity<GeoLocalizationDTO>(geoLocalizationService.addGeolocalization(geoLocalizationDTO), HttpStatus.CREATED);
    }
}
