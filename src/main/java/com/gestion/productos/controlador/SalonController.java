package com.gestion.productos.controlador;

import com.gestion.productos.entidades.Salon;
import com.gestion.productos.servicio.SalonServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class SalonController {

    @Autowired
    SalonServicio salonServicio;


}
