package ifs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ifs.repository.SourceRepository;

@org.springframework.stereotype.Service
public class SourceService {
	@Autowired
	private SourceRepository sourceRepository;

	public List<Map<String, Object>> getSourceTableNameService() {
		return sourceRepository.getSourceTableNameRepository();

	}

	public List<String> getSourceColumnNameService(String tablename) {
		return sourceRepository.getSourceColumnNameRepository(tablename);
	}

}
