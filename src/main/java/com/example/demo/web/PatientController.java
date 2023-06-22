package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Patient;
import com.example.demo.repository.PatientRepository;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name="keyword",defaultValue="") String kw) {
		Page<Patient> pagePatients = null;
		if(StringUtils.isNotBlank(kw)) {
			pagePatients = patientRepository.trouverParMotClef(kw,PageRequest.of(page, size));
		}else {
			pagePatients = patientRepository.findAll(PageRequest.of(page, size));
		}
		
		model.addAttribute("listPatients", pagePatients.getContent());
		model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",kw);
		return "patients"; 
	}
	
	@GetMapping("/delete")
	public String delete(Long id, String keyword, int page) {
		patientRepository.deleteById(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@GetMapping("/formPatients")
	public String formPatient(Model model) {
		model.addAttribute("patient",new Patient());
		return "formPatients";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid Patient patient,BindingResult bindinresult ) {
		if(bindinresult.hasErrors()) {
			return "formPatients";
		}
		//si l'id existe déjà c'est une mise à jour qui est réalisée
		patientRepository.save(patient);
		return "redirect:/index?keyword="+patient.getNom();
	}
	
	@GetMapping("/editPatient")
	public String editPatient(Model model,@RequestParam(name="id")Long id) {
		Patient patient = patientRepository.findById(id).get();
		model.addAttribute("patient",patient);
		return "editPatient";
	}
}
