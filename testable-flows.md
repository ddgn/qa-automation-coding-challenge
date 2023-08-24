(Add your list of flows here)
Testing both positive and negative scenarios is a fundamental practice in automation testing because it provides comprehensive coverage of a software application's behavior and ensures its robustness. Positive scenarios involve testing the expected, intended, and successful paths of user interactions with the software. By validating positive scenarios, automation tests confirm that the application functions as designed, meets user requirements, and delivers the intended user experience. This helps catch any regressions or unexpected changes that might occur during development or updates.

On the other hand, negative scenarios involve deliberately testing situations where the software is expected to handle errors, exceptions, and unexpected inputs gracefully. This type of testing uncovers vulnerabilities, boundary cases, and weak points in the software's error-handling mechanisms. It ensures that the application doesn't crash, hang, or expose sensitive information when encountering unexpected situations. By systematically subjecting the software to a wide range of negative scenarios, automation tests aid in identifying and addressing potential security issues and improving the overall reliability of the application.

In essence, combining both positive and negative scenarios in automation testing provides a holistic assessment of software functionality, helping to maintain high quality, user satisfaction, and robustness in the face of varying inputs and conditions.

Positive Scenarios
1. Enter the main screen, validate that all the elements on the screen are present based on the UI definiitions or templates.
2. Enter the main screen, input a valid github username and click on Go. The expected result would be the message of found # number of repos along with a list of hyperlinks that we can click that would redirect us to the specific repository, where we can validate the url composition.
3. Enter the main screen, input a valid github username that does not have any repository created, expecting the No repos message.

Negative Scenarios
1. Enter an unexisting github username and click on the Go button and validating the error messages of Github user not found and no repos.
2. Select the Go button without inputting anything inside the github username textbox expecting the error messages of Github user not found and no repos.
3. Enter a huge amount of characters inside the github username textbox and expecting no repos message along with github user not found error message.