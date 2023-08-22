package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.dto.FlorEntityDto;
import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.services.IFlorEntityService;

@RestController
@Controller
//@Slf4j
@RequestMapping("/flor")
public class FlorEntityController {
	
	@Autowired
	private IFlorEntityService iFlorEntityService;
	
	@PostMapping("/add")
	public ResponseEntity<?> create (@RequestBody FlorEntityDto flor){
			
		return ResponseEntity.status(HttpStatus.CREATED).body(iFlorEntityService.save(flor));
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") int id) {

	    Optional<FlorEntityDto> optionalFlor = Optional.ofNullable(iFlorEntityService.findById(id));

	    if (!optionalFlor.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    FlorEntityDto flor = optionalFlor.get();
	    return ResponseEntity.ok(flor);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody FlorEntityDto florDetalle, @PathVariable(value = "id") int id) {

		 Optional<FlorEntityDto> optionalFlor = Optional.ofNullable(iFlorEntityService.findById(id));

	    if (!optionalFlor.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    FlorEntityDto flor = optionalFlor.get();
	    flor.setNombre(florDetalle.getNombre());
	    flor.setPais(florDetalle.getPais());

	    return ResponseEntity.status(HttpStatus.OK).body(iFlorEntityService.save(flor));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") int id){
		
		 Optional<FlorEntityDto> optionalFlor = Optional.ofNullable(iFlorEntityService.findById(id));

		    if (!optionalFlor.isPresent()) {
		        return ResponseEntity.notFound().build();
		    }
		
		iFlorEntityService.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/getAll")
	public List<FlorEntityDto> readAll(){
		
		return (List<FlorEntityDto>) iFlorEntityService.findAll();
	
		
	}


}
