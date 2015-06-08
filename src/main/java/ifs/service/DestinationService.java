package ifs.service;

import ifs.repository.DestinationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class DestinationService {
	@Autowired
	private DestinationRepository destinationRepository;

	public List<Map<String, Object>> getDestinationTableNameService() {

		return destinationRepository.getDestinationTableNameRepository();
	}

	public List<String> getDestinationColumnNameService(String tablename) {

		return destinationRepository
				.getDestinationColumnNameRepository(tablename);
	}

}
