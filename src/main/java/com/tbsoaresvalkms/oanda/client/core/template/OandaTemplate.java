package com.tbsoaresvalkms.oanda.client.core.template;

import com.tbsoaresvalkms.oanda.client.core.configuration.ServiceConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.springframework.http.HttpMethod.*;

@Component
public class OandaTemplate extends RestTemplate {

    private HttpHeaders headers;
    private ServiceConfiguration configuration;

    public OandaTemplate(ServiceConfiguration configuration) {
        this.headers = new HttpHeaders();
        this.configuration = configuration;

        setRequestFactory(new HttpComponentsAsyncClientHttpRequestFactory());
        initializeHeader();
    }

    public void addParameterHeader(String key, String value) {
        headers.add(key, value);
    }

    public <T> ResponseEntity<T> get(String serviceUrl, Class<T> clazz) {
        return exchange(url(serviceUrl), GET, entity(), clazz);
    }

    public <T> ResponseEntity<T> delete(String serviceUrl, Class<T> clazz) {
        return exchange(url(serviceUrl), DELETE, entity(), clazz);
    }

    public <T, K> ResponseEntity<T> get(String serviceUrl, K queryString, Class<T> clazz) {
        return exchange(url(serviceUrl, queryString), GET, entity(), clazz);
    }

    public <T, K> ResponseEntity<T> post(String serviceUrl, K body, Class<T> clazz) {
        return exchange(url(serviceUrl), POST, entity(body), clazz);
    }

    public <T, K> ResponseEntity<T> put(String serviceUrl, K body, Class<T> clazz) {
        return exchange(url(serviceUrl), PUT, entity(body), clazz);
    }

    public <T, K> ResponseEntity<T> patch(String serviceUrl, K body, Class<T> clazz) {
        return exchange(url(serviceUrl), PATCH, entity(body), clazz);
    }

    private void initializeHeader() {
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + configuration.getToken());
    }

    private HttpEntity<Object> entity() {
        return new HttpEntity<>(this.headers);
    }

    private <K> HttpEntity<K> entity(K body) {
        return new HttpEntity<K>(body, this.headers);
    }

    private String url(String url) {
        return this.configuration.getUrl().concat(url);
    }

    private <K> String url(String url, K queryString) {
        try {
            Class<?> aClass = queryString.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            List<Field> fields = Arrays.asList(declaredFields);
            Map<String, String> mapToConvert = new HashMap<>();

            for (Field f : fields) {
                f.setAccessible(true);
                if (f.get(queryString) == null) continue;
                mapToConvert.put(f.getName(), f.get(queryString).toString());
            }


            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            for (Map.Entry<String, String> entry : mapToConvert.entrySet()) {
                params.add(entry.getKey(), entry.getValue());
            }

            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .path(url)
                    .queryParams(params)
                    .build();

            return this.configuration.getUrl().concat(uriComponents.toUriString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
