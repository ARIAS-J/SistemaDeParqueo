package com.NoHexRoger.Backend.Repository;

import com.NoHexRoger.Backend.Entity.Estancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstanciaRepository extends JpaRepository<Estancia, Integer> {
}
