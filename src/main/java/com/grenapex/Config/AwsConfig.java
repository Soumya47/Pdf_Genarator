package com.grenapex.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class AwsConfig {

	/*
	 * @Value("${amazon.dynamodb.endpoint}") private String amazonDynamoDBEndpoint;
	 * 
	 * @Value("${amazon.aws.accesskey}") private String amazonAWSAccessKey;
	 * 
	 * @Value("${amazon.aws.secretkey}") private String amazonAWSSecretKey;
	 */

	@Bean
	public DynamoDBMapper dbMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDb());
	}

	private AmazonDynamoDB buildAmazonDynamoDb() {
		return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("dynamodb.ap-southeast-2.amazonaws.com", "ap-southeast-2")

		).withCredentials(new AWSStaticCredentialsProvider(
				new BasicAWSCredentials("AKIA3ITJYICDNB3ZQB74", "4X445BW4UGKcRLZ4snWZ4TT7ZLnqAXWGvzqXhjzd"))).build();
	}

}
