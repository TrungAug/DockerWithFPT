package ntt.aug.docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import ntt.aug.docker.entity.ToDoItem;
import ntt.aug.docker.repository.ToDoRepository;


@Controller
public class ToDoController {
	@Autowired
	private ToDoRepository repository;

	@GetMapping
	public String show(@ModelAttribute("toDoItem") ToDoItem item) {
		return "list";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("toDoItem") ToDoItem item, BindingResult result) {
		if (result.hasErrors()) {
			return "list";
		}
		repository.save(item);
		return "redirect:/";
	}

	@GetMapping("page")
	public String page(Model model,@RequestParam("page") Optional<Integer> pageNo) {
		model.addAttribute("list", repository.findAll(PageRequest.of(pageNo.orElse(0), 3)));
		//findAll trả về một đối tượng Page không phải List
		return "page";
	}
	
	@ModelAttribute("list")
	public List<ToDoItem> getAll(@RequestParam("sortAsc") Optional<Boolean> sortAsc ) {
		if(sortAsc.isPresent()) {
			return repository.findAll(
					Sort.by(sortAsc.get()? Direction.ASC : Direction.DESC,"important")
					);
		}else {
			return repository.findAll();
		}		
	}
}
