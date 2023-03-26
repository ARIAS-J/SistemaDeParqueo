package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/v1/comenzar-mes")
public class ComenzarMesController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void comenzarMes() {
        vehiculoService.comenzarMes();
    }
}
