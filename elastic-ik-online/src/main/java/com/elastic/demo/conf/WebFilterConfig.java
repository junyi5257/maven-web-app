package com.elastic.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

/**
 *
 * @author goujy
 * @date 6/5/18
 */
@Configuration
public class WebFilterConfig {
    @Bean
    public Filter shallowETagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }


}
