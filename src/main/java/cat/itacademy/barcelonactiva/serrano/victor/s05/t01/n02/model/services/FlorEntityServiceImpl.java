package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.excepciones.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.dto.FlorEntityDto;
import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.repository.FlorEntityRepository;


@Service
public class FlorEntityServiceImpl implements IFlorEntityService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FlorEntityRepository florentityRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<FlorEntityDto> findAll() {
		
		List<FlorEntity> flores = florentityRepository.findAll();
		
		return flores.stream().map(flor -> mapearDTO(flor)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public FlorEntityDto save(FlorEntityDto florentityDto) {
		FlorEntity flor = mapearEntidad(florentityDto);
		
		FlorEntity nuevaFlor = florentityRepository.save(flor);
		
		FlorEntityDto flordto = mapearDTO(nuevaFlor);
		
		return flordto;
	}

	@Override
	@Transactional
	public FlorEntityDto update(FlorEntityDto florentityDto, int id) {
		FlorEntity flor = florentityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FlorEntity", "id", id));

		flor.setNombre(florentityDto.getNombre());
		flor.setPais(florentityDto.getPais());

		FlorEntity florActualizada = florentityRepository.save(flor);
		
		FlorEntity buscarFlorActualizada=florentityRepository.findById(florActualizada.getId())
				.orElseThrow(() -> new ResourceNotFoundException("FlorEntity", "id", id));

		return mapearDTO(buscarFlorActualizada);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		FlorEntity flor = florentityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FlorEntity", "id", id));
		
		florentityRepository.delete(flor);
		
	}

	@Override
	@Transactional(readOnly=true)
	public FlorEntityDto findById(int id) {
		FlorEntity flor = florentityRepository.findById(id)
		    		.orElseThrow(() -> new ResourceNotFoundException("FlorEntity", "id", id));
		    
		    return mapearDTO(flor);
	}
	
	private FlorEntityDto mapearDTO(FlorEntity flor) {
	
		FlorEntityDto flordto= modelMapper.map(flor, FlorEntityDto.class);
		if (flor.getPais().getContinente().getNombre().equals("Europa")) 
			flordto.setTipoFlor("UE");
		else 
			flordto.setTipoFlor("Fuera UE");
		
		return flordto;
	}
	
	private FlorEntity mapearEntidad(FlorEntityDto flordto) {
		FlorEntity flor= modelMapper.map(flordto, FlorEntity.class);
		
		return flor;
	}
	

}
