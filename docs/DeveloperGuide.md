# Developer Guide
 

* Table of Contents
{:toc}

## Setting up

<br>

### Prerequisites
 * Java 11 (can be download from here)
 * Intellij IDE
    
### Setting up:    
* Download the latest tracKCAL jar file (here)
* Copy jar file into an empty folder in a convenient location (eg. Desktop)
* Open terminal and navigate directory to the folder containing jar file 
* Enter the following command line to run program: ```java -jar tracKCAL.jar```   
* Look through the user guide for a full detailed explanation on the functionality of tracKCAL
    
## Design 

### Architecture

### Logic component

![Logic Component](diagrams/LogicComponent.png)

In the logic component, 

* Trakcal uses the parser class to filter based on command words by user.
* Description that comes after is further parsed down by the Parser.
* Respective Command object is created and is executed by Trackcal.
* Respective execution methods can be further associated with `UI`, `Storage` and `Model` components.

### Storage component

### Model component

## Implementation

### Add activity feature

The Sequence Diagram below shows how the components interact with each other for the scenario where the user issues the command `add f/ food c/ 170 d/ 2020-10-22`.

![Add Activity](diagrams/AddFoodFeature.jpg)

*Figure 5. Component interactions for add food command*

The sections below describe more features available.

### Advance List feature

### 3.4 Edit activity in list feature

#### 3.4.1 Current Implementation

The editing mechanism is used by EditFoodCommand and EditExerciseCommand to amend the current list of activities.

The following sequence diagram shows how a particular activity is edited after a edit command is entered:

![Edit Activity](diagrams/EditActivityFeature.jpg)

*Figure 9. Sequence diagram of edit feature*

#### 3.4.2 Design Considerations

Aspect: How to edit activity

>Alternative 1 (current choice): Same command able to edit both activities, food and exercise in list.
>* Pros: Able to guarantee that no abnormal behaviour will happen.
>* Cons: Have to ensure that the different type of editing is implemented correctly.

>Alternative 2: Have separate commands for editing the different activity type.
>* Pros: Clear distinction of the classes.
>* Cons: Increase in number of lines. Separate methods with similar logic will be created.

### 3.5 Chaining feature

#### 3.5.1 Current Implementation

The chaining mechanism can be used by the various commands available The following are the types of command that can be chained:
>list
>add
>edit

The following sequence diagram shows how the chaining works after command is entered:

![ChainCommandFeature](diagrams/ChainCommandFeature.jpg)

*Figure 10. Sequence diagram of chaining feature*

#### 3.5.2 Design Considerations

Aspect: Which commands to chain

>Alternative 1 (current choice): Allow only certain commands to be chained.
>* Pros: Able to guarantee that no abnormal behaviour will happen.
>* Cons: User must know which commands can be chained.

>Alternative 2: Allow all commands to be chained
>* Pros: Easy to implement.
>* Cons: May give abnormal behaviour.

### Graph feature


## Appendix: Requirements

### Product scope

#### Target user profile


{Describe the target user profile}
* Tech savvy university students that have knowledge on the exercise and calories or know where to get the information before inputting it in the application.
    - Can type fast
    - Prefers desktop applications
    - Prefers typing to mouse interactions
    - Conscious about daily calorie intake
    - Conscious about weight
    - Is reasonably comfortable using CLI applications

<br>

#### Value proposition

{Describe the value proposition: what problem does it solve?}
* Functionality
    - Provides greater flexibility of use.
    - Can be used to do things that are difficult or impossible to do with a GUI.
* Speed
    - GUI required additional system resource to load the graphical part, thus slower than CLI
    - Less memory usage
* Scripting & automation
    - Have greater control over system functions
    - Commands can be given via a line command and then code does the work whereas in GUI, more than one action have to be repeated to perform a command

<br>

### User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v1.0|user|add food consumed/exercise done|keep track of my daily activities|
|v1.0|user|list out the activities done for the day|track it and amend it if any errors occur|
|v1.0|user|delete entries entered|remove erroneous entries|
|v1.0|forgetful user|find activities via keyword|pull out the entries that I want|
|v1.0|beginner in working out|track the calories intake|feel assured that my workout is on the right track|
|v1.0|student who is a health enthusiast|keep track of my daily intake of calories|better manage my health|
|v2.0|gym user|upload the amount of calories consumed or lost|track the surplus or deficit of calories|
|v2.0|overweight student|calculate the estimated amount of calories lost|facilitate my weight loss regime|
|v2.0|underweight student|calculate the estimated amount of calories gained|facilitate my weight gain regime|
|v2.0|weight conscious person|track the amount of calories gained or lost|maintain my weight|
|v2.0|careless student|go back and edit entries entered earlier|correct the errors I have made|
|v2.0|frequent user|have pre-set repetitive actions entered by me|save time when inputting data|

<br>

### Use Cases

Use case: Delete activity

MSS:
>1. User requests to list the activities of a specific date.
>2. Duke shows a list of activities for that day.
>3. User requests to delete a specific activity in the list.
>4. Duke deletes the activity.
>5. Use case ends.

Extensions:
>2a. The list is empty.
>2a1. Use case ends.
>3a. The given index is invalid.
>3a1. Duke shows an error message.
Use case resumes at step 2.

<br>

### Non-Functional Requirements

{Give non-functional requirements}

1. Should work on any mainstream OS as long as it has Java 11 or above installed.
2. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

<br>

### Glossary

* *glossary item* - Definition
* *GUI* - Graphics User Interface
* *CLI* - Command Line Interface
* *OS* - Operating System
* *mainstream OS* - Windows, Linus, MacOS, OS-X, Unix
* *API* - Application Programming Interface
* *MSS* - Main Success Scenario

<br>

### Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

>These instructions only provide a starting point for testers to work on; testers are expected to do more exploratory testing.

*To be implemented soon*
