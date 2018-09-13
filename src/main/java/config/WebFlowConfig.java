package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

/**
 * @author yan
 * @date 2018/9/12 18:30
 * @descripition
 */
@Configuration
@ComponentScan
public class WebFlowConfig extends AbstractFlowConfiguration {
    /**
     * 流程注册表
     */
    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder()
                .setBasePath("/WEB-INF/flows")
                .addFlowLocationPattern("*-flow.xml")
                .build();
    }

    /**
     * 流程处理器
     */
    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
                .addFlowExecutionListener(new SecurityFlowExecutionListener(), "*") .build();
    }

    /**
     * 帮助DispatcherServlet将流程请求发送给Spring Web Flow
     */
    @Bean
    public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowRegistry) {
        FlowHandlerMapping flowHandlerMapping =
                new FlowHandlerMapping();
        flowHandlerMapping.setFlowRegistry(flowRegistry);
        flowHandlerMapping.setOrder(0);
        return flowHandlerMapping;
    }

    /**
     * 帮助DispatcherServlet将流程请求定向到Spring Web Flow
     */
    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
        FlowHandlerAdapter flowHandlerAdapter =
                new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor);
        return flowHandlerAdapter;
    }
}
