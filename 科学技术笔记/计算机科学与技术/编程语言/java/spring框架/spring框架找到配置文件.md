at org.springframework.core.io.support.PathMatchingResourcePatternResolver.doRetrieveMatchingFiles(PathMatchingResourcePatternResolver.java:723)
at org.springframework.core.io.support.PathMatchingResourcePatternResolver.retrieveMatchingFiles(PathMatchingResourcePatternResolver.java:684)
at org.springframework.core.io.support.PathMatchingResourcePatternResolver.doFindMatchingFileSystemResources(PathMatchingResourcePatternResolver.java:639)
at org.springframework.core.io.support.PathMatchingResourcePatternResolver.doFindPathMatchingFileResources(PathMatchingResourcePatternResolver.java:622)
at org.springframework.web.context.support.ServletContextResourcePatternResolver.doFindPathMatchingFileResources(ServletContextResourcePatternResolver.java:92)
at org.springframework.core.io.support.PathMatchingResourcePatternResolver.findPathMatchingResources(PathMatchingResourcePatternResolver.java:426)
at org.springframework.core.io.support.PathMatchingResourcePatternResolver.getResources(PathMatchingResourcePatternResolver.java:274)
at org.springframework.context.support.AbstractApplicationContext.getResources(AbstractApplicationContext.java:1269)
at org.springframework.context.support.GenericApplicationContext.getResources(GenericApplicationContext.java:225)
at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:216)
at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:188)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromImportedResources(ConfigurationClassBeanDefinitionReader.java:346)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:142)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:116)
at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:333)
at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:243)
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:273)
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:98)
at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:678)
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:520)
- locked <0x25a4> (a java.lang.Object)
at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:118)
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:690)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:322)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:970)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:959)
at com.dp.arts.joiner.core.JoinerServer.main(JoinerServer.java:26)


at org.apache.xerces.parsers.DOMParser.parse(Unknown Source:-1)
at org.apache.xerces.jaxp.DocumentBuilderImpl.parse(Unknown Source:-1)
at org.springframework.beans.factory.xml.DefaultDocumentLoader.loadDocument(DefaultDocumentLoader.java:76)
at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.doLoadDocument(XmlBeanDefinitionReader.java:429)
at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.doLoadBeanDefinitions(XmlBeanDefinitionReader.java:391)
at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.loadBeanDefinitions(XmlBeanDefinitionReader.java:336)
at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.loadBeanDefinitions(XmlBeanDefinitionReader.java:304)
at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:181)
at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:217)
at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:188)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromImportedResources(ConfigurationClassBeanDefinitionReader.java:346)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:142)
at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:116)
at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:333)
at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:243)
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:273)
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:98)
at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:678)
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:520)
- locked <0x2625> (a java.lang.Object)
at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:118)
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:690)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:322)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:970)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:959)
at com.dp.arts.joiner.core.JoinerServer.main(JoinerServer.java:26)


at com.dp.arts.joiner.core.common.ZkService.<init>(ZkService.java:66)
at sun.reflect.NativeConstructorAccessorImpl.newInstance0(NativeConstructorAccessorImpl.java:-1)
at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:147)
at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:122)
at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:267)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1143)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1046)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:510)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
- locked <0x30cb> (a java.util.concurrent.ConcurrentHashMap)
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:351)
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:108)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1481)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1226)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:351)
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:108)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1481)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1226)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
at org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.autowireResource(CommonAnnotationBeanPostProcessor.java:512)
at org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.getResource(CommonAnnotationBeanPostProcessor.java:486)
at org.springframework.context.annotation.CommonAnnotationBeanPostProcessor$ResourceElement.getResourceToInject(CommonAnnotationBeanPostProcessor.java:615)
at org.springframework.beans.factory.annotation.InjectionMetadata$InjectedElement.inject(InjectionMetadata.java:169)
at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
at org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.postProcessPropertyValues(CommonAnnotationBeanPostProcessor.java:308)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543)
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772)
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839)
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538)
- locked <0x2625> (a java.lang.Object)
at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:118)
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:690)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:322)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:970)
at org.springframework.boot.SpringApplication.run(SpringApplication.java:959)
at com.dp.arts.joiner.core.JoinerServer.main(JoinerServer.java:26)


/data/.m2/repository/org/springframework/spring-beans/4.2.5.RELEASE/spring-beans-4.2.5.RELEASE-sources.jar!/org/springframework/beans/factory/support/DefaultListableBeanFactory.java

this.beanDefinitionNames = {ArrayList@12508}  size = 160
 0 = "org.springframework.context.annotation.internalConfigurationAnnotationProcessor"
 1 = "org.springframework.context.annotation.internalAutowiredAnnotationProcessor"
 2 = "org.springframework.context.annotation.internalRequiredAnnotationProcessor"
 3 = "org.springframework.context.annotation.internalCommonAnnotationProcessor"
 4 = "org.springframework.context.event.internalEventListenerProcessor"
 5 = "org.springframework.context.event.internalEventListenerFactory"
 6 = "joinerServer"
 7 = "org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor"
 8 = "org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor"
 9 = "scheduler"
 10 = "adminController"
 11 = "org.springframework.scheduling.annotation.SchedulingConfiguration"
 12 = "org.springframework.context.annotation.internalScheduledAnnotationProcessor"
 13 = "fullDwRefreshJoinTaskJob"
 14 = "incJoinTaskJob"
 15 = "localFullJoinTaskJob"
 16 = "fullDwRefreshJoinJob"
 17 = "dwFullRefreshJoinTrigger"
 18 = "incJoinJob"
 19 = "incJoinTrigger"
 20 = "localFullJoinJob"
 21 = "localFullJoinTrigger"
 22 = "org.springframework.scheduling.quartz.SchedulerFactoryBean#0"
 23 = "com.dianping.pigeon.client.spring.internalPigeonAnnotationProcessor"
 24 = "com.dp.ir.common.conf.XmlPropertyPlaceholderConfigurer#0"
 25 = "placeholder"
 26 = "sysconfig"
 27 = "env"
 28 = "com.dp.arts.joiner.core.JoinerServer#0"
 29 = "joinSqlMapper"
 30 = "joinJdbcTemplate"
 31 = "artsDbDao"
 32 = "artsDB"
 33 = "joinTaskExecutor"
 34 = "dataJoinerFactory"
 35 = "dataSourceFactory"
 36 = "databaseFactory"
 37 = "fullJoinTaskExecutor"
 38 = "incJoinTaskExecutor"
 39 = "realTimeJoinTaskExecutor"
 40 = "joinConfigFactory"
 41 = "xmlObjectParser"
 42 = "enableApps"
 43 = "mongoUtil"
 44 = "applicationStartListener"
 45 = "zkService"
 46 = "categoryTreeManager"
 47 = "regionTreeManager"
 48 = "hbaseConfiguration"
 49 = "hbaseTemplate"
 50 = "htableFactory"
 51 = "org.springframework.boot.autoconfigure.AutoConfigurationPackages"
 52 = "org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration"
 53 = "org.springframework.boot.autoconfigure.condition.BeanTypeRegistry"
 54 = "propertySourcesPlaceholderConfigurer"
 55 = "org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration$JettyWebSocketConfiguration"
 56 = "websocketContainerCustomizer"
 57 = "org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration"
 58 = "org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$EmbeddedJetty"
 59 = "jettyEmbeddedServletContainerFactory"
 60 = "org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration"
 61 = "embeddedServletContainerCustomizerBeanPostProcessor"
 62 = "org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration$DispatcherServletConfiguration"
 63 = "dispatcherServlet"
 64 = "dispatcherServletRegistration"
 65 = "org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration"
 66 = "org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration"
 67 = "error"
 68 = "beanNameViewResolver"
 69 = "org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration"
 70 = "errorAttributes"
 71 = "basicErrorController"
 72 = "preserveErrorControllerTargetClassPostProcessor"
 73 = "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
 74 = "requestMappingHandlerAdapter"
 75 = "requestMappingHandlerMapping"
 76 = "mvcContentNegotiationManager"
 77 = "viewControllerHandlerMapping"
 78 = "beanNameHandlerMapping"
 79 = "resourceHandlerMapping"
 80 = "mvcResourceUrlProvider"
 81 = "defaultServletHandlerMapping"
 82 = "mvcConversionService"
 83 = "mvcValidator"
 84 = "mvcPathMatcher"
 85 = "mvcUrlPathHelper"
 86 = "mvcUriComponentsContributor"
 87 = "httpRequestHandlerAdapter"
 88 = "simpleControllerHandlerAdapter"
 89 = "handlerExceptionResolver"
 90 = "mvcViewResolver"
 91 = "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter$FaviconConfiguration"
 92 = "faviconHandlerMapping"
 93 = "faviconRequestHandler"
 94 = "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter"
 95 = "defaultViewResolver"
 96 = "requestContextListener"
 97 = "viewResolver"
 98 = "spring.mvc.CONFIGURATION_PROPERTIES"
 99 = "spring.resources.CONFIGURATION_PROPERTIES"