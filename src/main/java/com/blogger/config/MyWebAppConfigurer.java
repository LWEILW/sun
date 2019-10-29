package com.blogger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

///**
// * 解决跨域问题springboot所需配置
// */
//@Configuration
//public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
//    protected final static Logger logger = LoggerFactory.getLogger(MyWebAppConfigurer.class);
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                //设置是否允许跨域传cookie
//                .allowCredentials(true)
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                //设置缓存时间，减少重复响应
//                .maxAge(3600)
//                .allowedHeaders("set-cookie")
//                .allowedHeaders("access-control-allow-headers")
//                .allowedHeaders("access-control-allow-methods")
//                .allowedHeaders("access-control-allow-origin")
//                .allowedHeaders("access-control-max-age")
//                .allowedHeaders("X-Frame-Options");
//
//        logger.info("*********************************跨域过滤器-MyWebAppConfigurer**************************");
//    }
//}


/**
 * 解决跨域问题springboot所需配置
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    //解决跨域
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration conf = new CorsConfiguration();
        conf.addAllowedHeader("*");
        conf.addAllowedMethod("*");
        conf.addAllowedOrigin("*");
        conf.setAllowCredentials(true);
        conf.setMaxAge(3600L);
        conf.addExposedHeader("set-cookie");
        conf.addExposedHeader("access-control-allow-headers");
        conf.addExposedHeader("access-control-allow-methods");
        conf.addExposedHeader("access-control-allow-origin");
        conf.addExposedHeader("access-control-max-age");
        conf.addExposedHeader("X-Frame-Options");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }
}
