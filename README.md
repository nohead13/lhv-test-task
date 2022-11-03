Selenide test examples: leasing calculator
================================

This project using page: [LHV leasing calculator](https://www.lhv.ee/en/leasing).

**You can check out and run it locally with a few minutes.**

### Run with Gradle

Type from command line to run tests on your machine:

```
./gradlew test
# or
./gradlew test -Dselenide.headless=true
```

### Covered by test functionality
 - Here will add description of reason of selected list
 - How many tests needed
 - Which one should be automated
 - Which points should be checked
 - Link to manual tests
#### Manually:
- [a link to manual test cases](manual_test_cases.md)
#### Automated:
- Check click on apply here button and redirect to leasing application page
- Check legal customer with selected operational lease and final monthly instalment
- Check private customer with monthly instalment	
- Check fields size of inputs and using dots and comma in double numbers	
- Check leasing period less than 6 month		
- Check payment schedule list on new page	
- Check operational lease with price includes VAT and not	
- Check warning message for small income

### What could be found in this build
- Allure Report
- GitHub actions
- Gradle, Kotlin-based DSL
- Selenide 6.8.1
- Page objects
- JUnit 5
