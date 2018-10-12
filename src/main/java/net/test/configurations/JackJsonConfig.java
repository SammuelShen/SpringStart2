package net.test.configurations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class JackJsonConfig {

    static ObjectMapper objectMapper;

    public ObjectMapper getObjectMapper(){
        return JackJsonConfig.createObjectMapper();
    }

    public static ObjectMapper createObjectMapper(){
        if(objectMapper==null){
            synchronized (JackJsonConfig.class){
                if(objectMapper==null){
                    JavaTimeModule javaTimeModule = new JavaTimeModule();
                    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
//                    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
//                    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//                    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//                    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
//                    javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer());
//                    javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer());
//                    javaTimeModule.addSerializer(Timestamp.class, new TimestampSerializer());
//                    javaTimeModule.addDeserializer(Timestamp.class, new TimestampDeserializer());

                    objectMapper= Jackson2ObjectMapperBuilder.json()
                            .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                            .failOnUnknownProperties(false)
                            .modules(javaTimeModule)
                            .build();
                }
            }
        }
        return objectMapper;
    }

    @Bean
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(getObjectMapper());
        converters.add(jsonConverter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

}