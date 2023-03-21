package com.NoHexRoger.Backend.Service;

import com.NoHexRoger.Backend.Entity.Estancia;
import com.NoHexRoger.Backend.Repository.EstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanciaService {
    @Autowired
    EstanciaRepository estanciaRepository;

    public List<Estancia> getEstancias(){
        return estanciaRepository.findAll();
    }

    public Estancia getEstanciaById(Integer id){
        return estanciaRepository.findById(id).orElse(null);
    }

    public Estancia createEstancia(Estancia estancia){
        Estancia newEstancia = estanciaRepository.save(estancia);
        return newEstancia;
    }
}
