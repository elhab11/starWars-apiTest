package java;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.asynchttpclient.Response;
import org.junit.Test;

public class TestBase {

	public RequestSpecification httprequest;

	public TestBase() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

			// Rest Assured config
			RestAssured.baseURI = props.getProperty("api.uri");
			httprequest = RestAssured.given();
			io.restassured.response.Response resp = httprequest.get("people");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
