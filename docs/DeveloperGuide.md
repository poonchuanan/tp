# Developer Guide
 

* Table of Contents
{:toc}

## Setting up

### Prerequisites
 * Java 11 (can be download from here)
 * Intellij IDE
    
### Setting up:    
* Download the latest tracKCAL jar file (here)
* Copy jar file into an empty folder in a convenient location (eg. Desktop)
* Open terminal and navigate directory to the folder containing jar file 
* Enter the following command line to run program: ```java -jar trakCAL.jar```   
* Look through the user guide for a full detailed explanation on the functionality of trakCAL
    
## Design 

### Architecture

The Architecture Diagram shown above explains the high-level design of trakCAL.

trakCAL is made up of mainly 6 components.

`trakCAL`:

`Ui`: Displays any message that the user can see and interact with

`Logic`: Interprets what the user input

`Command`: Executes specific command according to interpretation by `Logic`

`Storage`: Saves required data into the hard disk or retrieves data

`Model`: Visualize data into graph

### Logic component

![Logic Component](diagrams/LogicComponent.png)

In the logic component, 

* trakCAL uses the parser class to filter based on command words by user.
* Description that comes after is further parsed down by the Parser.
* Respective Command object is created and is executed by trakCAL.
* Respective execution methods can be further associated with `UI`, `Storage` and `Model` components.

### Storage component

### Model component
![Model_Component](diagrams/LogicComponent.png)
*Figure 4. Diagram for Model component*<br>
**API**: Model.java <br>
In the Model component, <br>
* Stores a DayMap object that holds the data for each date.
* Stores an ActivityList that holds the list of Activities, Food or Exercise for each day 
* Does not depend on any of the other components.




## Implementation

### 3.2 Add activity feature

#### 3.2.1 Current Implementation

The adding mechanism is used by AddFoodCommand and AddExerciseCommand to add to the list of date stated in user input.

The following Sequence Diagram shows how add command is carried out when the user issues add command, in this case, `add f/ food c/ 170 d/ 2020-10-22`:

![Add Activity](diagrams/AddFoodFeature.jpg)

*Figure 5. Component interactions for add food command*

> Add exercise diagram has a similar logic.

#### 3.2.2 Design Considerations

Aspect: How to add activity

>Alternative 1(current choice): Using single letter words as tags for input commands. (e.g. add f/ XXX c/ XXX d/ XXX)
>* Pros: Faster and shorter input keys for user.
>* Cons: Have to ensure that user is clear on what tags to input.

>Alternative 2: Using full words as tags for input commands. (e.g. add food/ XXX calorie/ XXX date/ XXX)
>* Pros: Tags are obvious in what input is expected.
>* Cons: More wordy input needed from user.

### 3.3 Listing feature for find and list commands
The listing mechanism used by ListCommand and FindCommand to display the required list of activities is facilitated by the lastSeenList of class ActivityList. 
The following operations could be applied to the lastSeenList which would change the actual data in the database:

- delete
- move
- edit (note: edit only modifies entries in the database after list command)

The details of those operations can be found further down.

#### 3.3.1 List

This feature is used to list the entries of a specified date where the extracted activityList would be used as the lastSeenList itself.

The following sequence diagram shows how the lastSeenList is set after a “list date" command where date is of YYYY-MM-DD 
or after a “list” command where the date is the current date.

![List Sequence Diagram](diagrams/ListSequenceDiagram.png)

*Figure 6. Sequence diagram of setting the lastSeenList after a listCommand*




### 3.4 Listing feature for find and list commands
The listing mechanism used by ListCommand and FindCommand to display the required list of activities is facilitated by the lastSeenList of class ActivityList. The following operations could be applied to the lastSeenList which would change the actual data in the database:
* `delete`
* `move`
* `edit (note: edit only moedit only modifies entries in the database after list command)`
The details of those operations can be found further down

#### 3.4.1 List
This feature is used to list the entries of a specified date where the extracted activityList would be used as the lastSeenList itself. <br>
The following sequence diagram shows how the lastSeenList is set after a “list date" command where date is of YYYY-MM-DD or after a “list” command where the date is the current date.<br>
![Listing feature for find and list commands](diagrams/setLastSeenList.png)
Figure 6. Sequence diagram of setting the lastSeenList after a `list` command

#### 3.4.2 Find

The editing mechanism is used by the basic find features: `FindDescriptionCommand`, `FindCalorieCommand`, 
as well as the advanced find features: `FindAllCommand` and `FindEitherCommand` to look for keywords in the list.

The following sequence diagram shows how the lastSeenList is set after a find command.
![Find Sequence Diagram](diagrams/FindSequenceDiagram.png)
*Figure 7. Sequence diagram of setting the lastSeenList after a find command*


### 3.5 Displaying the list after `find` or `list` commands
#### 3.5.1 Current implementation
The mechanism used to display the lastSeenList invoked by the list or find commands is facilitated by the listDrawer and findDrawer class respectively. They both work the same way but the list produced by findDrawer has an extra column which contains the dates of the respective entries.
<br>
The following sequence diagram shows how the listDrawer class is used to display the lastSeenList.<br>
![list_Drawer](diagrams/listDrawer.png)

*Figure 8. Sequence diagram of the usage of listDrawer to display the list*

### 3.6 Edit activity in list feature

#### 3.6.1 Current Implementation

The editing mechanism is used by EditFoodCommand and EditExerciseCommand to amend the current list of activities.

The following Sequence Diagram shows how edit command is carried out when the user issues edit command, in this case, `edit 1 f/ egg c/ 10`:

![Edit Activity](diagrams/EditActivityFeature.jpg)

*Figure 8. Sequence diagram of edit food feature*

> Edit exercise diagram has a similar logic.

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

*Figure 9. Sequence diagram of chaining feature*

#### 3.5.2 Design Considerations

Aspect: Which commands to chain

>Alternative 1 (current choice): Allow only certain commands to be chained.
>* Pros: Able to guarantee that no abnormal behaviour will happen.
>* Cons: User must know which commands can be chained.

>Alternative 2: Allow all commands to be chained
>* Pros: Easy to implement.
>* Cons: May give abnormal behaviour.

### Graph feature

### Move feature
This feature allows the user to manually `move` activities from one position to another position <br>
The following sequence diagram shows how the `move` command is executed, where index1 is the position to be moved from and index 2 is the position to be moved below. <br>
![Move_command](diagrams/moveCommand.png)

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
