<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Buggy Car Rating UI Automation Framework</h3>

  <p align="center">
    This selenium based java automation project caters to UI automation of different flows for the website : https://buggy.justtestit.org/ 
   <br />
  </p>
</p>

<!-- ABOUT THE PROJECT -->
## About The Project
This is a java maven project: BuggyCarsRatingUiAutomation.

Test Approach document: https://github.com/PallviKhurana/BuggyCarsRatingUIAutomation/blob/master/Test%20Approach_BuggyCarRating.pdf

Structure:

 /src/
 
        main
             --> resources
           
           
        test
             --> java/WebUIAutomation

Under src folder we have two folders main and test.

Main folder has a resource folder inside it that contains chromedriver.exe. Chromedriver is downloaded from : https://chromedriver.chromium.org/downloads

**Note**: Make sure the chromedriver version should be same as version of Chrome installed in your PC.

Test folder contains WebUIAutomation Package that contains PageObjects like MainPage.java , MakePage.java etc.


### Built With
```
i) IDE : Intellij Windows Client to code the project.
ii) Used Selenium libraries for interacting with website.
iii) Used Page Object Model Pattern to structure code.
iv) Used TestNG annotations for writing tests.

```
### Installation
```
1. Clone the repo
   ```sh
   https://github.com/PallviKhurana/BuggyCarsRatingUIAutomation.git
   ```
2. Install IDE IntelliJ : https://www.jetbrains.com/idea/download/
     
3. Open the cloned repo in IntelliJ 
```sh
File > Open and choose the project from the location where it is downloaded
```
4. Configure JDK 
  ```sh
   File> Project Structure > Project SDK and choose version 16.0.2
```

![image](https://user-images.githubusercontent.com/15661497/135017449-689a27d0-82ed-4fb2-a0df-6e26fc27abe3.png)

5. Download dependencies
  ```sh
   Click on Maven> Generate Sources and Update folders
```
![image](https://user-images.githubusercontent.com/15661497/135017759-dd7f1409-3732-4f18-9b3d-b9515cb57fd9.png)

6. Build the project
 ```sh
   Click on Build> Build Project
```

<!-- USAGE EXAMPLES -->
## Usage

Run all the tests
 ```sh
   - Navigate to src/test/java/WebUIAutomation/Tests.java
   - Right Click on Tests and select "Run Tests"
   
```
![image](https://user-images.githubusercontent.com/15661497/135018403-e813e30f-66c0-43f3-b0ae-f5d955d2a3ef.png)

Run individual test
 ```sh
   - Navigate to src/test/java/WebUIAutomation/Tests.java
   - Open Tests.java
   - Click on the green symbol against the test name and click on the Run <TestName> option as shown below
   `````
![image](https://user-images.githubusercontent.com/15661497/135018882-218b4b16-0ad0-4ffb-b694-04caa5b364b8.png)
