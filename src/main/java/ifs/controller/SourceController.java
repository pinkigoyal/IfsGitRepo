package ifs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.PathVariable;

import ifs.service.SourceService;

@Controller
public class SourceController {
	@Autowired
	private SourceService sourceService;

	@RequestMapping(value = "/getSourceTableName", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> getSoucreTableNameController() {
		List<Map<String, Object>> list = sourceService
				.getSourceTableNameService();
		return new ResponseEntity<List<Map<String, Object>>>(list,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getSourceColumnName/{tablename}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSourceTableColumnNameController(
			@PathVariable("tablename") String tablename) {
		List<String> map = sourceService.getSourceColumnNameService(tablename);
		return new ResponseEntity<List<String>>(map, HttpStatus.OK);

	}

}