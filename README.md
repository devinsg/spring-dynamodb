# spring cloud config access to dynamodb
- AWS dynamodb: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html
- Nosql workbench: https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/workbench.html
- Github: https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code
- AccessKey: AKIAYMJ5UL2BC5LHIAEO
- SecretLey: jXbMgBAe56NZwnY/RUxTQHRuZSDPWm/7FhS3sYe4t

# youtube video
- https://www.youtube.com/watch?v=E0-P978Yqdw&ab_channel=JavaTechie
- https://www.youtube.com/watch?v=amlQdiJIGpg&ab_channel=TapasJoshi

# Spring Framework: some popular annotations
- @Required, @Autowired, @Configuration, @ComponentScan, @Bean, @Component, @Controller, @Service, @Repository

# Spring Framework basic difference between: @Component, @Service, @Repository
- https://www.baeldung.com/spring-component-repository-service
- an application has distinct layer like data access, presentation, service, business...

- Each layer have various beans, to detect these beans automatically, Spring use class path scanning annotation:
- @Component is a generic stereotype for any Spring-managed component
- @Service annotates classes at the service layer
- @Repository annotates classes at the persistence layer, which will act as a database repository

- The major difference between these stereotypes is that they are used for different classifications:
- @Component: use @Component across the application to mark the beans as Spring's managed components. 
Spring will only pick up and register beans with @Component, and doesn't look for @Service and @Repository in general.
- @Repository: to catch persistence-specific exceptions and re-throw them as one of Spring’s unified unchecked exceptions.
- @Service: to mark beans with @Service to indicate that they're holding the business logic. 