package com.webspring.web.controller;

import java.util.List;

import com.webspring.web.contactModel.contact;
import com.webspring.web.repository.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class contactcontroller {

    @Autowired
    private  repository repository;
  
     @GetMapping({"/",""})
     public String verPaginaInicio(Model model){
         List<contact> contactos=repository.findAll();
         model.addAttribute("contactos", contactos);
         return "index";
     }
     @GetMapping("/new")
     public String RegistroContact(Model model){
         model.addAttribute("contact",new contact());
         return "new";
     }
     @PostMapping("/new")
	public String guardarContacto(@Validated contact contacto,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("contact", contacto);
			return "new";
		}
		
		repository.save(contacto);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
		return "redirect:/";
	}

    @GetMapping("/{id}/new")
	public String EditarContacto(@PathVariable Integer id,Model model) {
		contact contacto = repository.getById(id);
		model.addAttribute("contact", contacto);
        return "new";
	}
	
	@PostMapping("/{id}/new")
	public String actualizarContacto(@PathVariable Integer id,@Validated contact contacto,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		contact contactoDB = repository.getById(id);
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contacto);
			return "new";
		}
		
		contactoDB.setNombre(contacto.getNombre());
        contactoDB.setApellido(contacto.getApellido());
        contactoDB.setTelefono(contacto.getTelefono());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setPassword(contacto.getPassword());

		
		
		repository.save(contactoDB);
		redirect.addFlashAttribute("msgExito", "El contacto ha sido actualizado correctamente");
		return "redirect:/";
	}
	@PostMapping("/{id}/eliminar")
	public String eliminarContacto(@PathVariable Integer id,RedirectAttributes redirect) {
		contact contacto = repository.getById(id);
		repository.delete(contacto);
		redirect.addFlashAttribute("msgExito", "Se elimino de manera correctamente");
		return "redirect:/";
	}
	

}
  