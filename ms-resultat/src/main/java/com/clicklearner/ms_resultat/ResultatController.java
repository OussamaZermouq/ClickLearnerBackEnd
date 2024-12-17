package com.clicklearner.ms_resultat;


import com.clicklearner.ms_resultat.Dto.GetResultatByStudentIdAndByDevoirIdDto;
import com.clicklearner.ms_resultat.Dto.ResponseDto;
import com.clicklearner.ms_resultat.model.Resultat;
import com.clicklearner.ms_resultat.service.implementations.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resultat")
public class ResultatController {
    @Autowired
    public ResultatService resultatService;

    @GetMapping("/{resultatId}")
    public ResponseEntity<?> getResultatById(@PathVariable int resultatId){
        Resultat resultat = resultatService.getResultatById(resultatId);
        if (resultat!=null){
            return ResponseEntity.ok().body(resultat);
        }
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Cant find Result with id "+resultatId));
    }
    @PostMapping("/addresultat")
    public ResponseEntity<ResponseDto> ajouterResultat(@RequestBody Resultat resultat){
        resultatService.ajouterResultat(resultat);
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "Result has been added"));

    }

    @GetMapping("/resultatbydevoirid/{devoirId}")
    public ResponseEntity<?> getResultatsByDevoirId(@PathVariable int devoirId){
        List<Resultat> resultats = resultatService.getResultatsByDevoirId(devoirId);
        if (resultats.isEmpty()){
            return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Cant find results for this devoirID"));

        }
        return ResponseEntity.ok().body(resultats);
    }

    @GetMapping("/resultatbystudentanddevoir")
    public ResponseEntity<?> getResultatByStudentIdAndByDevoirId(@RequestBody GetResultatByStudentIdAndByDevoirIdDto getResultatByStudentIdAndByDevoirIdDto){
        Resultat resultat = resultatService.getResultatByStudentIdAndByDevoirId(getResultatByStudentIdAndByDevoirIdDto.getDevoirId(), getResultatByStudentIdAndByDevoirIdDto.getStudentId());
        if (resultat!=null){
            return ResponseEntity.ok().body(resultat);

        }
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Cant find results for this devoirID and student Id"));

    }
}
