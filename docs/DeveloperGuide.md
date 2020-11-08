# Developer Guide for traKCAL

The purpose of this developer guide is as reference for future collaborators of **trakCAL**.

By: CS2113-T09-4    Since: October 2020   Licence: MIT

<br>

## 1.0 Introduction

**Welcome to traKCAL!**

**traKCAL** is a desktop application for managing and visualizing your calorie intake, optimized for use via Command Line Interface (CLI) whilst retaining the benefits of a Graphical User Interface (GUI). 

This guide will provide information on the design and implementation of **traKCAL** to help you get started on your journey of becoming a contributor to **traKCAL**. This guide will also explain the various features available in **traKCAL**, to provide you with a better understanding of the current version of **traKCAL**

<br>

## Table of Contents

* Table of Contents
{:toc}

<br>

## 2.0 Setting up
1. Fork the traKCAL repository [here]() and git clone it to a convenient location on your desktop eg. Desktop.
2. Open any IDE (Intellij preferred) and click `Configure` -> `Project Defaults` -> `Project Structure` -> `New` and ensure that a valid Java 11 SDK is selected.
3. Next, go to `Import Project` and select the *build.gradle* file. 
4. Click `Open as Project` and accept all default settings. 
5. After opening the project, go to `src` -> `main` -> `java` -> `seedu.duke` -> `Trakcal` and right click on the Trakcal class. Select the `Run 'Trakcal.main()'` option.
6. Upon successful run, the following opening message will be shown: 

```
====================================================================================
| Hello from                                                                       |
|  _                  _  __   ___     _     _                                      |
| | |_   _ _   __ _  | |/ /  / __|   /_\   | |                                     |
| |  _| | '_| / _` | | ' <  | (__   / _ \  | |__                                   |
|  \__| |_|   \__,_| |_|\_\  \___| /_/ \_\ |____|                                  |
|                                                                                  |
| Hello! I'm traKCAL.                                                              |
| Please do input 'help' for the commands and their respective input format.       |
====================================================================================
```
7. You will then be prompted to create a new user profile.  

<br>

### 2.1 Prerequisites
 * Java 11 (can be download from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html))
 * Intellij IDE
 
<br>
    
### 2.2 Setting up:    
* Download the latest **traKCAL** jar file ([here](https://github.com/AY2021S1-CS2113T-T09-4/tp/releases))
* Copy jar file into an empty folder in a convenient location (eg. Desktop)
* Open terminal and navigate directory to the folder containing jar file 
* Enter the following command line to run program: ```java -jar traKCAL.jar```   
* Look through the user guide for a full detailed explanation on the functionality of **traKCAL**
    
<br>
<br>    
    
## 3.0 Design 

### 3.1 Architecture

![Architecture](diagrams/Architecture.png)

*Figure 1. Diagram for Model component*

The Architecture Diagram shown above explains the high-level design of **traKCAL**.

**traKCAL** is made up of mainly 8 components.

`trakCAL`: tracKCAL starts here

`Ui`: Displays any message that the user can see and interact with

`Logic`: Interprets what the user input

`Model`: Structure of the data

`Command`: Executes specific command according to interpretation by `Logic`

`Storage`: Saves required data into the hard disk or retrieves data

`Exception`: Contains additional exceptions used in code.

`UserProfile`: Processes user details

<br>

### 3.2 Ui component

<br>

### 3.3 Logic component

![Logic Component](diagrams/LogicComponent.png)

*Figure 2. Diagram for logic component*

The main bulk of data processing takes place in the logic component. In this component, 
the data from the userinput is checked for its validity and parsed down futher by the preparecommand class to its respective command blocks.
These command class are derived from the abstract Command class. Each different command block deals with the 
proposed functionality which can be associated with `Ui`,`storage` or `model` components. 

* **traKCAL** uses the parser class to filter based on command words by user.
* Description that comes after is further parsed down by the PrepareCommand class 
and validity of those description are checked..
* Respective Command object is created and is executed by **traKCAL**.
* Respective execution methods can be further associated with `UI`, `Storage` and `Model` components.

<br>

### 3.4 Model component

![Model_Component](diagrams/model.png)

*Figure 3. Diagram for Model component*


In the Model component, 

* Stores a DayMap object that holds the data for each date.
* Stores an ActivityList that holds the list of Activities, Food or Exercise for each day 
* Does not depend on any of the other components.

<br>

### 3.5 Command component

<br>

### 3.6 Storage component

<br>

### 3.7 Exception component

<br>

### 3.8 UserProfile component

<br>
<br>

## 3.0 Implementation

### 3.1 Create User Profile

The sequence diagram below shows how the components will react to a new user or for a returning user. 

![CreateNewUser](diagrams/CreateNewUser.png)

*Figure 4. Components interactions for tracKCAL checks for new or existing user*

<br>

### 3.2 Add activity feature

#### 3.2.1 Current Implementation

The adding mechanism is used by `AddFoodCommand` and `AddExerciseCommand` to add to the list of date stated in user input.

The following Sequence Diagram shows how `AddFoodCommand` is carried out when the user issues add command, in this case, `add f/ food c/ 170 d/ 2020-10-22`:

![Add Food](diagrams/addFoodFeature.png)

*Figure 5. Component interactions for add food command*

> `AddExerciseCommand` diagram has a similar logic.

![Add_Exercise](diagrams/AddExerciseFeature.png)

*Figure 6. Component interactions for add exercise command*

<br>

#### 3.2.2 Design Considerations

Aspect: How to add activity

>Alternative 1(current choice): Using single letter words as tags for input commands. (e.g. add f/ jelly c/ 100 d/ 2020-11-09)
>* Pros: Faster and shorter input keys for user.
>* Cons: Have to ensure that user is clear on what tags to input.

>Alternative 2: Using full words as tags for input commands. (e.g. add food/ XXX calorie/ XXX date/ XXX)
>* Pros: Tags are obvious in what input is expected.
>* Cons: More wordy input needed from user.

<br>
<br>

### 3.3 Listing feature for find and list commands
The listing mechanism used by `ListCommand` and `FindCommand` to display the required list of activities is facilitated by the lastSeenList of class `ActivityList`. 
The following operations could be applied to the lastSeenList which would change the actual data in the database:

- delete
- move
- edita

The details of those operations can be found further down.

<br>

#### 3.3.1 List

This listing feature uses the lastSeenList which is of ActivtyList class.  <br>
The lastSeenList is the list that the user would see after a `list` or `find` command. <br>
For example, 
* A `list 2020-11-11` command would use the activityList for 2020-11-11 as the lastSeenList.<br>
* A `find e/ food` command would go throught the dayMap and add activities containing the keyword/s into the lastSeenList.
Using the lastSeenList allows users to make changes e.g `edit`, `delete`, `move` commands using the numbered index of a single `list` or `find` command.

The following sequence diagram shows how the lastSeenList is set after a “list date" command where date is of YYYY-MM-DD or after a “list” command where the date is the current date.

![Listing feature for find and list commands](diagrams/setLastSeenList.png)

*Figure 6. Sequence diagram of setting the lastSeenList after a `list` command*

<br>
<br>

#### 3.3.2 Find

The editing mechanism is used by the basic find features: `FindDescriptionCommand`, `FindCalorieCommand`, 
as well as the advanced find features: `FindAllCommand` and `FindEitherCommand` to look for keywords in the list.

The following sequence diagram shows how the lastSeenList is set after a find command.

![Find Sequence Diagram](diagrams/FindSequenceDiagram.png)

*Figure 7. Sequence diagram of setting the lastSeenList after a find command*

<br>
<br>

### 3.4 Displaying the list after `find` or `list` commands

#### 3.4.1 Current implementation
The mechanism used to display the lastSeenList invoked by the list or find commands is facilitated by the listDrawer and findDrawer class respectively. They both work the same way but the list produced by findDrawer has an extra column which contains the dates of the respective entries.

The following sequence diagram shows how the listDrawer class is used to display the lastSeenList.

![list_Drawer](diagrams/listDrawer.PNG)

*Figure 8. Sequence diagram of the usage of listDrawer to display the list*

<br>
<br>

### 3.5 Edit activity in list feature

#### 3.5.1 Current Implementation

The editing mechanism is used by `EditFoodCommand` and `EditExerciseCommand` to amend the current list of activities.

The following Sequence Diagram shows how `EditFoodCommand` is carried out when the user issues edit command, in this case, `edit 1 f/ egg c/ 10`:

![Edit_Food](diagrams/EditFood.png)

*Figure 9. Sequence diagram of edit food feature*

> `EditExerciseCommand` diagram has a similar logic.

![Edit_Exercise](diagrams/EditExercise.png)

*Figure 10. Sequence diagram of edit exercise feature*

<br>

#### 3.5.2 Design Considerations

Aspect: How to edit activity

>Alternative 1 (current choice): Same command able to edit both activities, food and exercise in list.
>* Pros: Easy to implement.
>* Cons: Have to ensure that the different type of editing is implemented correctly.

>Alternative 2: Have separate commands for editing the different activity type.
>* Pros: Clear distinction of the classes.
>* Cons: Increase in number of lines. Separate methods with similar logic will be created.

<br>
<br>

### 3.6 Chaining feature

#### 3.6.1 Current Implementation

The chaining mechanism can be used by the various commands available The following are the types of command that can be chained:
- list
- add
- edita
- graph

The following sequence diagram shows how the chaining works after command is entered:

![Chain_Command](diagrams/ChainCommand.png)

*Figure 10. Sequence diagram of chaining feature*

<br>

#### 3.6.2 Design Considerations

Aspect: Which features to chain

>Alternative 1 (current choice): Allow only certain commands to be chained.
>* Pros: Able to better track input of users.
>* Cons: User must know which commands can be chained.

>Alternative 2: Allow all commands to be chained.
>* Pros: Easy to implement.
>* Cons: May give abnormal behaviour.

<br>
<br>

### 3.7 Move feature
This feature allows the user to manually `move` activities from one position to another position 

The following sequence diagram shows how the `move` command is executed, where index1 is the position to be moved from and index 2 is the position to be moved below. 

![Move_command](diagrams/moveCommand.png)

*Figure 11. Sequence diagram of move feature*

<br>
<br>

### 3.8 Graph feature

The graph implementation shows the progress of the daily net 
calories over the period of 7 days. The GraphProperty class extracts the available days from the 
stored data in the application.

The days are sorted accordingly and the latest 7 days are chosen from the sorted list. 
The GraphProperty class extracts these data and calculates the attributes needed to build the graph. The GraphDrawing class makes use of these properties
to draw the graph.

> Examples of graph properties include:
> 1. Maximum/minimum calories
> 1. Calorie interval
> 1. 2-Dimensional array representation of the graph

![Graph_Sequence_Diagram](diagrams/GraphSequenceDiagram.png)

*Figure 12. Sequence diagram of move feature*

As shown above, when the execute command of GraphCommand is called, the GraphProperty object 
is created, the properties of the graph are then stored and calculated in setProperty function.

Next, the graphDrawing object is created and uses the properties calculated earlier to print out the graph.
> In the case where there are less than 7  days stored, all the days will be displayed.

<br>
<br>

## 4.0 Appendix: Requirements

### 4.1 Product scope

#### 4.1.1 Target user profile

{Describe the target user profile}
* Tech savvy university students that have knowledge on the exercise and calories or know where to get the information before inputting it in the application.
    - Can type fast
    - Prefers desktop applications
    - Prefers typing to mouse interactions
    - Conscious about daily calorie intake
    - Conscious about weight
    - Is reasonably comfortable using CLI applications

<br>

#### 4.1.2 Value proposition

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

### 4.2 User Stories

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

### 4.3 Non-Functional Requirements

{Give non-functional requirements}

1. Should work on any mainstream OS as long as it has Java 11 or above installed.
2. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

<br>

### 4.4 Glossary

* *glossary item* - Definition
* *GUI* - Graphics User Interface
* *CLI* - Command Line Interface
* *OS* - Operating System
* *mainstream OS* - Windows, Linus, MacOS, OS-X, Unix
* *API* - Application Programming Interface
* *MSS* - Main Success Scenario

<br>

### 4.5 Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

Starting up application
1. Ensure that you have Java 11 or above installed, if not, it can be found [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
2. Down the latest version of `trakCAL` from [here](https://github.com/AY2021S1-CS2113T-T09-4/tp/releases)
3. Create an empty folder in a convenient location eg. Desktop and copy jar file over to it.
4. Open command window/terminal in that window and navigate into the file directory,
5. Run the command `java -jar {filename}.jar` e.g., `java -jar traKCAL.jar`.
6. Upon successful run, you will get the following greeting message.

```
====================================================================================
| Hello from                                                                       |
|  _                  _  __   ___     _     _                                      |
| | |_   _ _   __ _  | |/ /  / __|   /_\   | |                                     |
| |  _| | '_| / _` | | ' <  | (__   / _ \  | |__                                   |
|  \__| |_|   \__,_| |_|\_\  \___| /_/ \_\ |____|                                  |
|                                                                                  |
| Hello! I'm traKCAL.                                                              |
| Please do input 'help' for the commands and their respective input format.       |
====================================================================================
```

7. Enter `help` to view help list containing the features, and their respective input format.
8. For a detailed list on the available features, please refer to [user guide](UserGuide.md)

Exiting the application
1. To terminate **traKCAL**, enter `bye`. A successful terminating of application would look like this:

```
=====================================================================================================
| Thank you for using traKCAL. See you again!                                                       |
=====================================================================================================
```
 
#### Adding an entry into list
    1. Adding a food entry with date
        Test case: `add f/ cheesy chicken c/ 180 d/ 2020-11-09`
        Expected: An entry with food description `cheesy chicken` and calories of `100` would be added into `2020-11-09`'s list.
    2. Adding a food entry without date
        Test case: `add f/ milk tea with pearls c/ 125`
        Expected: An entry with food description `milk tea with pearls` and calories of `150` would be added into today's list.
    3. Adding an exercise entry with date
        Test case: `add e/ walking c/ 10 d/ 2020-11-05`
        Expected: An entry with exercise description `walking` and calories of `10` would be added into `2020-11-05`'s list.
    4. Adding an exercise entry without date
        Test case: `add e/ 50 sit-ups c/ 75`
        Expected: An entry with food description `50 sit-ups` and calories of `75` would be added into today's list.
    5. Incorrect inputs to try:
        `add f/ jelly 90 `: has missing calorie tag [c/]
        `add f/ jelly c/ 90 d/ 2020-10-13`: date is before application launch date, 2020-10-14
        `add f/ jelly c/ -30`: calories is less than or equals to 0
        `add e/ jumping up and down in a merry round in Singapore c/ 80`: description is longer than 40 characters
        `add e/ c/ `: empty input parameters
        Expected: Message with error will be shown
       