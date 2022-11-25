## Task 2.1: Dependency inversion principle and the ports & adapters pattern

### Fix the arch unit test

The class stereotype to add is the _use case_ or to be more specific a _incoming use case_.

```java
void http_input_adapter_check() {
     ArchRule rule = classes()
     .that().haveSimpleName(CONTROLLER_UNDER_TEST)
     .should().resideInAnyPackage(ADAPTER, ADAPTER_IN)
     .andShould().onlyDependOnClassesThat()
     .resideInAnyPackage(
             DOMAIN,
            DOMAIN_MODEL,
            //which stereotype is allowed to be accessed by the controller?
            USECASE, //neccessary when package structure variant rings as layers is applied
            USECASE_IN, // //neccessary when package structure variant architecture expressive domain and architectural expressive is applied
            //ignore this list elements below
            ORG,
            JAVA_LANG,
            ADAPTER,
            ADAPTER_IN
        );
     
     rule.check(classes);
}
```