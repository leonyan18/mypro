package config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.IOException;

/**
 *@author yan
 *@date 2018/9/8 14:24
 *@descripition web配置
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {
    private ApplicationContext applicationContext;
    @Autowired
    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Bean
    /**
     * 配置jsp视图解析器
    */
    public ViewResolver viewResolver() {
        /*解析jsp*/
        InternalResourceViewResolver viewResolverjsp = new InternalResourceViewResolver();
        viewResolverjsp.setPrefix("/WEB-INF/views/");
        viewResolverjsp.setSuffix(".jsp");
        viewResolverjsp.setViewClass(//将视图解析为jstlview
                org.springframework.web.servlet.view.JstlView.class
        );
        /*解析tiles*/
        TilesViewResolver viewResolverTiles=new TilesViewResolver();
        /*解析thyleaf*/
        ThymeleafViewResolver viewResolverthyleaf = new ThymeleafViewResolver();
        viewResolverthyleaf.setTemplateEngine(templateEngine());
        /*选其一*/
        return viewResolverTiles;

    }
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);
        return templateResolver;
    }
    /**
     * 配置tiles视图解析器
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer=new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml"
        });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     *设置servlet3.0解析multipart请求StandardServletMultipartResolver
     * 非3.0 使用CommonsMultipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        /*CommonsMultipartResolver*/
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setUploadTempDir(
                new FileSystemResource("F:/uploads"));
        multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxInMemorySize(0);
        /*StandardServletMultipartResolver*/
        return new StandardServletMultipartResolver();
    }

    @Override
    /**
     * 配置静态资源的处理
    */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
