# User Guide for traKCAL

## Introduction

**traKCAL** is an application for managing calories intake, optimized for use via Command Line Interface (CLI) whilst retaining the benefits of a Graphical User Interface (GUI). 
If you can type fast, traKCAL is for you.

## Table of Contents
* [Quick Start](#quick-start)
* [Features]
    * [Setting up program in Intellij](#setting-up-program-in-intellij)
    * [Viewing help](#viewing-help): `help`
    * [Adding a profile for new user](#adding-a-profile-for-new-user): `create new user`
    * [Adding a target calorie](#adding-a-target-calorie): `target`
    * [Adding a food entry](#adding-a-food-entry): `add`
    * [Adding an exercise entry](#adding-an-exercise-entry): `add`
    * [Listing entries for the day](#listing-entries-for-the-day): `list`
    * [Editing user profile](#editing-user-profile): `edit`
    * [Editing an entry in list](#editing-an-entry-in-list): `editA`
    * [Finding entries via keyword](#finding-entries-via-keyword): `find`
    * [Deleting entry in list](#deleting-entry-in-list): `delete`
    * [Deleting all entries in list](#deleting-all-entries-in-list): `deleteALL`
    * [Exiting the program](#exiting-the-program): `bye`
* [Frequently asked questions](#frequently-asked-questions)
* [Command Summary](#command-summary)

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed
2. Down the latest version of `Duke` from [here](http://link.to/duke)
3. Create an empty folder in a convenient location eg. Desktop and copy jar file there
4. Open command window/terminal in that window and run the command `java -jar {filename}.jar` e.g., `java -jar tp.jar`
5. Upon successful run, the following greeting message will be shown
```
==============================================================
Hello from
  _                  _  __   ___     _     _
 | |_   _ _   __ _  | |/ /  / __|   /_\   | |
 |  _| | '_| / _` | | ' <  | (__   / _ \  | |__
  \__| |_|   \__,_| |_|\_\  \___| /_/ \_\ |____|

Hello! I'm traKCAL.
==============================================================
````

## Features 

{Give detailed description of each feature}
* traKCAL has many commands available. Such as 'create new user', 'add', 'edit', 'delete', 'list', 'find'.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should strictly adhere to the one in the help list or in this user guide.
>* Input commands such as `add`, `edit`, `list`, etc. are not case-sensitive, but it is recommended to follow format stated in help list or this user guide.

### Setting up program in Intellij

### Viewing help
Prints out the commands available, and their respective input format.

Format: `help`

Example of usage:
* `help`
```javascript
==============================================================
Commands available: create new user, list, help, add, delete, find, bye
The expected format of input values:
	create new user         - Adds a new user profile
	target X                - Adds a target calorie, X
	help                    - Prints out commands available and their input format
	add f/ X c/ Y d/ Z      - Adds food consumed, X, calories gained, Y and date(YYYY-MM-DD), Z
	add e/ X c/ Y d/ Z      - Adds exercise done, X, calories lost, Y and date(YYYY-MM-DD), Z
	list                    - Prints out the list of entries.
	edit n/U, g/V, w/W, h/X, a/Y, af/Z
	                        - Edit user profile to name, U, gender, V, weight, W, height, X,
	                          age, Y, activity factor(1-5), Z
	edita W f/ X c/ Y d/ Z  - Edits activity at index W of list to food consumed, X,
	                          calories gained, Y and date(YYYY-MM-DD), Z
	edita W e/ X c/ Y d/ Z  - Edits activity at index W of list to exercise done, X,
	                          calories lost, Y and date(YYYY-MM-DD), Z
	find d/ X               - Searches for exercise/food description with X included
	find c/ X               - Searches for activity description with calories of X
	delete X                - Deletes activity located at index X of the list
	bye                     - Terminates the program
==============================================================
The current activity list has been saved.
```

### Adding a profile for new user
Automatically checks for new user and prompt them to create a new user profile by asking a series of questions

Example of usage:
````
Hey there! We do not have a record of your profile. Please create one now! :)

What is your name?
**Sam**
What is your gender (male/female)?
**female**
What is your weight in kg?
**50**
What is your height in cm?
**100**
What is your age?
**10**
How active are you on a scale of 1-5? With 1 being least active and 5 being most active.
**4**
Do you want to lose/maintain/gain weight?
**gain**
````

### Adding a target calorie
Interprets the answers from the user profile questionnaire to calculate health profile

tracKCAL calculates: 
* BMI
* Recommended daily calorie
* Calorie goal to reach weight goal

Example of calculated health profile: 
````
Your BMI is 20.
Your recommend daily calories intake is 1576.65 calories.
To gain weight, you should consume 2076.65 calories instead.
````

### Adding a food entry
Adds a food entry with its respective calories to the list.

Format: `add f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories consumed.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage:
* `add f/ ice cream c/ 78 d/ 2020-10-19`
```javascript
[F] | ice cream | 78
The current activity list has been saved.
```

### Adding an exercise entry
Adds an exercise entry with its respective calories to the list.

Format: `add e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage: 
* `add e/ jumping c/ 65 d/ 2020-10-19`
```javascript
[E] | jumping | 65
The current activity list has been saved.
```

### Listing entries for the day

### Editing user profile
Edits user profile of an existing user

Format: `edit n/**NAME** g/**GENDER** w/**WEIGHT** h/**HEIGHT** a/**AGE** af/**ACTIVITY_FACTOR** goal/**WEIGHT_GOALS**`

Parameters: 
* `**NAME**`: Name of user
* `**GENDER**`: Gender of user
* `**WEIGHT_KG**`: Weight of user in kg
* `**HEIGHT_CM**`: Height of user in cm
* `**AGE**`: Age of user 
* `**ACTIVITY_FACTOR**`: How active user is, with 1 being most active and 5 being least active
* `**WEIGHT_GOALS**`: whether user wants to lose/maintain/gain weight 

Example of usage: 
* `edit n/Sam g/female w/50 h/100 a/10 af/4 goal/gain`
````
==============================================================
Noted, I have edited your user profile. Here are your new details: 
Name: Sam
Gender: female
Weight: 50
Height: 100
Age: 10
Activity: 4
Weight Goal: gain
Your BMI is 50
Your recommend daily calories intake is 1576.65 calories.
To gain weight, you should consume 2076.65 calories instead.
==============================================================
````

### Editing an entry in list
Edits activity, food or exercise at the stated index in the list.  
> In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.

Format: `edita **LIST_INDEX** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**` OR `edita **LIST_INDEX** f/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**LIST_INDEX`: Index of activity to be edited in list.
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**CALORIE_COUNT**`: Amount of calories consumed.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Example of usage:
* `edita 1 e/ running c/100 d/ 2020-10-21`
```javascript
[E] | running | 100
The current activity list has been saved.
```
### Finding entries via keyword

### Deleting entry in list

### Deleting all entries in list

### Exiting the program
Saves the current list to file and exits program.

Format: `bye`

Example of usage:
* `bye`
```javascript
==============================================================
Thank you for using TraKCAL. See you again!
==============================================================
```

## Frequently asked questions

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

Action     | Format | Example
---------- | ---------- | --------
Add food | `add e/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ ice cream c/ 78 d/ 2020-10-19`
Add exercise | `add e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ jumping c/ 65 d/ 2020-10-19`
Edit activity | `edita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `edita 1 f/ ice kacang c/150 d/ 2020-10-21`
Edit activity | `edita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `edita 1 e/ running c/100 d/ 2020-10-21`
Help | `help` | `help`
Exit | `bye` | `bye`



### --- END OF USER GUIDE ---
