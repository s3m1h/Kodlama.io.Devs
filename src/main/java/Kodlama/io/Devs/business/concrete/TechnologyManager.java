package Kodlama.io.Devs.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyDao;
import Kodlama.io.Devs.entities.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService{
	private TechnologyDao technologyDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyDao.findAll();
		List<GetAllTechnologyResponse> getAllTechnologys = 
				technologies.stream().map(t->this.modelMapperService.forResponse().map(t, GetAllTechnologyResponse.class)).collect(Collectors.toList());
		return getAllTechnologys;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Technology technology = this.modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
		this.technologyDao.save(technology);
	}
	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = this.modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);
		this.technologyDao.save(technology);
		
	}

	@Override
	public void delete(int id) {
		this.technologyDao.deleteById(id);
	}
	@Override
	public GetByIdTechnologyResponse getById(int id) {

		Technology technology = this.technologyDao.findById(id).orElseThrow();
		GetByIdTechnologyResponse getById = this.modelMapperService.forResponse().map(technology, GetByIdTechnologyResponse.class);
		return getById;
	}

}
