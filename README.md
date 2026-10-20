1. Simplicity: each component should have one clear role instead of multitasking. A 600-line MainActivity that handles server requests, JSON parsing, SharedPreferences, form validation, and UI updates violates this principle because it combines too many responsibilitie

Testability: code must be testable before unit tests can be applied. If all the logic is inside MainActivity, testing individual operations becomes more difficult because they are mixed with UI responsibilities.

Low-cost maintenance: proper architecture makes adding and removing features easier and helps developers keep track of important logic.

For this example, moving the server and data-access logic out of MainActivity is a reasonable application of its principle of separating responsibilities.

2. Plan:

1.  Examine the existing application's structure and responsibilities
2.  Understand the available architectural patterns
3.  Identify the project's specific requirements
4.  Select and apply a suitable pattern to the relevant components
5.  Evaluate whether the chosen structure improves organization, testability, and maintenance

answer: Because no single pattern suits every project and that different modules in one project can have different structures
