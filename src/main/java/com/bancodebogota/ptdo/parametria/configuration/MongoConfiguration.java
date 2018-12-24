package com.bancodebogota.ptdo.parametria.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = "com.bdg.dashboard.repository")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.bdg.dashboard.controller")
public class MongoConfiguration  extends AbstractMongoConfiguration {

	private final Logger log = LoggerFactory.getLogger(MongoConfiguration.class);

	@Value("${spring.data.mongodb.uri}")
	private String mongoURI;

	@Value("${spring.data.mongodb.database}")
	private String database;
	
	/*@Autowired
	private Environment env;*/

	@Override
	public MongoClient mongoClient() {
		log.info("Conectando a Mongo URI host:" + mongoURI);
		MongoClientURI uri = new MongoClientURI(mongoURI);
		return new MongoClient(uri);
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

	@Override
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
		return mongoTemplate;
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.bdg.dashboard.model";
	}
	
}
