package br.com.projects.udemy.java.searalization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJacksonToHttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public YamlJacksonToHttpMessageConverter() {
		super(new YAMLMapper(),MediaType.parseMediaType("application/x-yaml"));
	}	
}
