package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.services;

import java.util.Optional;

import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.dto.FlorEntityDto;

public interface IFlorEntityService {
	
public Iterable<FlorEntityDto> findAll();
	
	public FlorEntityDto save(FlorEntityDto florentity);
	
	public FlorEntityDto update(FlorEntityDto florentity, int id);
	
	public void deleteById(int id);
	
	public FlorEntityDto findById(int id);

}
