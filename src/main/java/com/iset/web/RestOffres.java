package com.iset.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/Offres")
public class RestOffres {

    final OffreRepository offreRepository;

    RestOffres(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Offre getById(@PathVariable Long id) {
        return offreRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Offre saveOffre(@RequestBody Offre newOffre) {
        return offreRepository.save(newOffre);
    }

    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable Long id) {
        offreRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Offre updateOffre(@PathVariable Long id, @RequestBody Offre offre) {
        offre.setCode(id);
        return offreRepository.save(offre);
    }
}