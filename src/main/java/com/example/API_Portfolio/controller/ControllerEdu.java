package com.example.API_Portfolio.controller;

import com.example.API_Portfolio.model.Estudio;
import com.example.API_Portfolio.service.IEduService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliodeleonibus.web.app/",maxAge = 3600)
@RequestMapping({"/bq1w7g1ex7509pfg59vk/estudio"})
public class ControllerEdu {
    
    @Autowired
    private IEduService service;
    
    @GetMapping
    @ResponseBody
    public List<Estudio>listar(){
        return service.listar();
    }
    @PostMapping
    public void agregar(@RequestBody Estudio e){
         service.add(e);
    }
    @GetMapping(path = {"/{id}"})
    public Estudio listarId(@PathVariable("id")Long id){
        return service.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Estudio editar(@RequestBody Estudio e,@PathVariable("id") Long id){
        e.setId(id);
        return service.edit(e);
    }
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id") Long  id){
        service.delete(id);
    }
    
    
}
