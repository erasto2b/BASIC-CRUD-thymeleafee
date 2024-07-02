package com.gestion.productos.controlador;

import com.gestion.productos.entidades.Evento;
import com.gestion.productos.entidades.Salon;
import com.gestion.productos.servicio.EventoServicio;
import com.gestion.productos.servicio.SalonServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventoControlador {

    @Autowired
    private EventoServicio eventoServicio;

    @Autowired
    private SalonServicio salonServicio;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave){

        List<Evento> listarEventos = eventoServicio.listAll(palabraClave);

        modelo.addAttribute("palabraClave", palabraClave);
        modelo.addAttribute("listarEventos", listarEventos);

        return "index" ;
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo){

        List<Salon> salones = salonServicio.salonList();

        Evento evento = new Evento();
        modelo.addAttribute("evento" , evento);
        modelo.addAttribute("salones", salones);

        return "eventos/nuevo_evento";

    }

    @RequestMapping(value ="guardar" ,method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Evento producto){
        eventoServicio.save(producto);
        return "redirect:/" ;
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id){

        ModelAndView modelo = new ModelAndView("eventos/editar_evento");
        Evento evento = eventoServicio.get(id);
        List<Salon> salones = salonServicio.salonList();


        modelo.addObject("salones", salones);
        modelo.addObject("evento",evento);
        return modelo ;
    }

    @RequestMapping("/eliminar/{id}")
    public String EliminarProducto(@PathVariable(name = "id") Long id){

        eventoServicio.delete(id);
        return "redirect:/" ;
    }
}