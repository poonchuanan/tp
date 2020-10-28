# User Guide for traKCAL

The purpose of this user guide is to guide the users on the commands available in this application, their respective uses and the expected inputs.

By: CS2113-T09-4    Since: September 2020   Licence: MIT

<br>

# Introduction

**traKCAL** is a desktop application for managing and visualizing your calorie intake, optimized for use via Command Line Interface (CLI) whilst retaining the benefits of a Graphical User Interface (GUI). 

If you are a fast typer, **traKCAL** is perfect for you!

**traKCAL** is available for the download on all major Operating Systems(OS) such as Windows, Mac and Linux.

<br>

# Table of Contents

The section displays the table of contents showing all the available features in **trakCAL**

[ToC]

<br>

# Quick Start

This section gives the steps you need to get started quickly.

1. Ensure that you have Java 11 or above installed, if not, it can be found [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
2. Down the latest version of `Duke` from [here](http://link.to/duke)
3. Create an empty folder in a convenient location eg. Desktop and copy jar file there
4. Open command window/terminal in that window and run the command `java -jar {filename}.jar` e.g., `java -jar tp.jar`
5. Upon successful run, you will get the following greeting message

```
=====================================================================================================
| Hello from                                                                                        |
|  _                  _  __   ___     _     _                                                       |
| | |_   _ _   __ _  | |/ /  / __|   /_\   | |                                                      |
| |  _| | '_| / _` | | ' <  | (__   / _ \  | |__                                                    |
|  \__| |_|   \__,_| |_|\_\  \___| /_/ \_\ |____|                                                   |
|                                                                                                   |
| Hello! I'm traKCAL.                                                                               |
=====================================================================================================
Please do input 'help' for the commands and their respective input format.
```
6. Type a command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window<br/>
   Some example commands you can try:
    * `list`: Lists all activities for today
    * `add f/ rice with eggs c/ 200`: Adds a food entry named `rice with eggs` to **traKCAL**.
    * `delete 3`: Deletes the 3rd contact shown in the current list.
    * `bye`: Exits the application.
7. Refer to the [Features](#features) below for details of each command

<br>

# Features 

This section gives you a detailed description of each feature available in **trakCAL**.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should STRICTLY adhere to the one in the help list or in this user guide.
>* Commands such as `add`, `edit`, `list`, etc. are not case-sensitive, but it is recommended for you to follow format stated in help list or this user guide.

<br>
<br>

## 1.0 Viewing help

Prints out the commands available, and their respective input format.

Format: `help`

Example of usage:
* `help`

```
=====================================================================================================
Commands available: create new user, list, help, add, delete, find, bye

The expected format of input values:
	help                   - Prints out commands available and their input format
	create new user        - Creates a new user profile
	target CALORIE         - Adds a target calorie, CALORIE
	add f/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE
	                       - Adds food consumed, FOOD_DESCRIPTION calories gained, CALORIE_COUNT
	                         and date(YYYY-MM-DD), DATE
	add e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE
	                       - Adds exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT
	                         and date(YYYY-MM-DD), DATE
	list                   - Prints out the list of entries.
	list DATE              - Prints out the list of entries for the date(YYYY-MM-DD), DATE
	edit n/ NAME, g/ GENDER, w/ WEIGHT, h/ HEIGHT, a/ AGE, af/ ACTIVITY_FACTOR, goal/ WEIGHT_GOALS
	                       - Edits your name, NAME, your gender(male/female), GENDER,
	                         your weight in kg, WEIGHT, your height, HEIGHT in cm, your age, AGE,
	                         activity factor(1-5) with 1 being the most active, ACTIVITY_FACTOR,
	                         your weight goals(lose/maintain/gain), WEIGHT_GOALS
	edita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT
	                       - Edits activity at index LIST_INDEX of latest list printed out
	                         to food consumed, FOOD_DESCRIPTION, calories gained, CALORIE_COUNT
	edita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT
	                       - Edits activity at index LIST_INDEX of latest list printed out
	                         to exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT
	find d/ DESCRIPTION    - Searches for all activities description with the DESCRIPTION keyword
    find c/ CALORIE_COUNT  - Searches for all activities with calories of CALORIE_COUNT
    find a/ DESCRIPTION1 / DESCRIPTION2 .../ DESCRIPTIONn
                           - Searches for all activities with ALL matching keywords from
                            DESCRIPTION1 to DESCRIPTIONn
    find e/ DESCRIPTION1 / DESCRIPTION2 .../ DESCRIPTIONn
                           - Searches for all activities with AT LEAST one matching keyword from
                             DESCRIPTION1 to DESCRIPTIONn
	move from/ INDEX1 below/ INDEX2
	                       - Moves the activity at index INDEX1 to the index below INDEX2
	delete LIST_INDEX      - Deletes activity located at index LIST_INDEX of latest list printed out
	delete all/            - Deletes all activities in current date list
	graph                  - Generates a graph of target calorie and net calorie obtained up to
	                         last 7 days
	bye                    - Terminates the program
Words in CAPS are parameters to be filled in by you!

=====================================================================================================
```

<br>
<br>

## 2.0 Create

<br>

### 2.1 Creating a new user profile

If this is your first time using **tracKCAL**, you will be automatically prompted to create a user profile and there is no need for you to input any command.
**tracKCAL** will then use these details from your user profile to calculate the following: 

* BMI
* Recommended daily calorie
* Calorie goal to reach weight goal

>However, if you want to create a new profile for an existing user, you will need to use this command

Format: `create new user`

Example of usage:

```
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

Your BMI is 50.0
Your recommend daily calories intake is 1576.65 calories.
To gain weight, you should consume 2076.65 calories instead.
```

#### Possible error messages and how to solve them:

**tracKCAL** only accepts female and male as gender. If you were to enter `Donkey` as gender, this error message will be shown.
```
=====================================================================================================
Please input female or male as gender only!
=====================================================================================================
```

**tracKCAL** only accepts integers with/without decimal points as weight, height and age. If you were to enter `haha` as weight, height or age, this error message will be shown.
```
=====================================================================================================
Please enter a valid number format!
=====================================================================================================
```

**tracKCAL** only accepts integers from 1 to 5 for activity level. If you were to enter `6` or `haha` as activity level, this error message will be shown.
```
=====================================================================================================
Please enter a number from 1 to 5 only!
=====================================================================================================
```

**tracKCAL** only accepts lose, maintain and gain for weight goals. If you were to enter `haha` as weight goal, this error message will be shown.
```
=====================================================================================================
Please input lose or maintain or gain as weight goal only!
=====================================================================================================
```

<br>
<br>

### 2.2 Creating a shortcut for a set of entries 

This command creates a shortcut for a set of commonly called exercise and/or food entries, reducing the amount of time needed for you to add in multiple common entries. 

Format: `createSet **SHORTCUT_NAME** f/**FOOD_DESCRIPTION** c/**CALORIE_COUNT** + f/**EXERCISE_DESCRIPTION** c/**CALORIE_COUNT** + ...`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**SHORTCUT_NAME**`: Name of shortcut/set.

Example of usage: 
*  `createSet bfast f/ice cream c/78 + e/jumping jacks c/100`

```
=====================================================================================================
You have created a shortcut containing:
1. Food: ice cream, Calories: 78
2. Exercise: jumping jacks, Calories: 100
=====================================================================================================
```

#### Possible error message and how to solve them: 

**tracKCAL** only accepts integers for calories. If you were to enter `createSet bfast f/ice cream c/haha + e/jumping jacks c/100`, this error message will be shown.
 ```
=====================================================================================================
Please enter calories as an integer
=====================================================================================================
 ```

<br>
<br>

## 3.0 Add

<br>

### 3.1 Adding a food entry

Adds a food entry with its respective calories to the list.

Format: `add f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories consumed.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage: 
* `list` before adding *current date is 2020-10-28*
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 30 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30
```

* `add f/ mushroom soup c/ 77 d/ 2020-10-28`

```
=====================================================================================================
Noted! The following has been added into list:
[F] | mushroom soup | 77

The current activity list has been saved.
=====================================================================================================
```

* `list` after adding
```
------------------------------------------
|  2020-10-28  |  Net Calorie: 107 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30

2          Food           mushroom soup_____________________________________________77
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

### 3.2 Adding an exercise entry

Adds an exercise entry with its respective calories to the list.

Format: `add e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage: 
* `list` before adding
```
------------------------------------------
|  2020-10-28  |  Net Calorie: 107 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30

2          Food           mushroom soup_____________________________________________77
```

* `add e/ jumping c/ 65 d/ 2020-10-28`

```
=====================================================================================================
Noted! The following has been added into list:
[E] | jumping | 65

The current activity list has been saved.
=====================================================================================================
```

* `list` after adding
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 42 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30

2          Food           mushroom soup_____________________________________________77

3        Exercise         jumping___________________________________________________65
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

### 3.3 Adding a set of entries

Adds a set of repeated entries at once.

Format: `addSet **SHORTCUT_NAME**`

Parameters:
* `**SHORTCUT_NAME**`: Name of shortcut.

Example of usage: 
* `addSet bfast`

```
=====================================================================================================
Noted! The following has been added into list:
[F] | ice cream | 78
The current activity list has been saved.
=====================================================================================================
=====================================================================================================
[E] | jumping jacks | 100
The current activity list has been saved.
=====================================================================================================
```

#### Possible error message and how to solve them: 

If you were to add a new shortcut without creating it first, this error message will be shown
 ```
=====================================================================================================
This shortcut does not exists, please create a shortcut before adding it!
=====================================================================================================
 ```

<br>
<br>

## List

<br>

### 4.0 Listing entries for the specified day

Displays the list of activities for the given day.

Format: `list` or `list **DATE**`

Parameters:
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.
>NOTE: Typing list without any parameters displays the list of activities for the current date.

Examples of usage: 
* `list`

```
1. [E] | running | 100
```

* `list 2020-10-24`

```
1. [F] | burger | 90
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 5.0 Edit

<br>

### 5.1 Editing user profile

Edits user profile of an existing user.

Format: `edit n/ **NAME** g/ **GENDER** w/ **WEIGHT** h/ **HEIGHT** a/ **AGE** af/ **ACTIVITY_FACTOR** goal/ **WEIGHT_GOALS**`

Parameters: 
* `**NAME**`: Name of user.
* `**GENDER**`: Gender of user.
* `**WEIGHT_KG**`: Weight of user in kg.
* `**HEIGHT_CM**`: Height of user in cm.
* `**AGE**`: Age of user.
* `**ACTIVITY_FACTOR**`: How active user is, with 1 being most active and 5 being least active.
* `**WEIGHT_GOALS**`: Whether user wants to lose/maintain/gain weight.

Example of usage: 
* `edit n/Sam g/female w/50 h/100 a/10 af/4 goal/gain`

```
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
```

#### Possible error messages and how to solve them:

**tracKCAL** only accepts female and male as gender. If you were to enter `Donkey` as gender, this error message will be shown.
```
=====================================================================================================
Please input female or male as gender only!
=====================================================================================================
```

**tracKCAL** only accepts integers with/without decimal points as weight, height and age. If you were to enter `haha` as weight, height or age, this error message will be shown.
```
=====================================================================================================
Please enter a valid number format!
=====================================================================================================
```

**tracKCAL** only accepts integers from 1 to 5 for activity level. If you were to enter `6` or `haha` as activity level, this error message will be shown.
```
=====================================================================================================
Please enter a number from 1 to 5 only!
=====================================================================================================
```

**tracKCAL** only accepts lose, maintain and gain for weight goals. If you were to enter `haha` as weight goal, this error message will be shown.
```
=====================================================================================================
Please input lose or maintain or gain as weight goal only!
=====================================================================================================
```


<br>
<br>

### 5.2 Editing an entry in list from food to food 

Edits a particular food activity in list.
>Things you should take note of:
>* In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.
>* The list in which you want to edit to have to be pulled out first before being able to edit on it.
>* This commands edits the latest list pulled out. Thus, if `list 2020-10-21` is the latest list to be pulled out, then edita will edit index stated in date 2020-10-21's list.

Format: `edita **LIST_INDEX** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**LIST_INDEX**`: Index of activity to be edited in list.
* `**FOOD_DESCRIPTION**`: New description of food consumed.
* `**CALORIE_COUNT**`: New amount of calories consumed.

Example of usage:
* `list` before editing
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 42 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30

2          Food           mushroom soup_____________________________________________77

3        Exercise         jumping___________________________________________________65
```

* `edita 1 f/ orange c/ 35`

```
=====================================================================================================
Noted! The following has been edited:
[F] | orange | 35

The current activity list has been saved.
=====================================================================================================
```

* `list` after editing
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 77 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2          Food           mushroom soup_____________________________________________77

3        Exercise         jumping___________________________________________________65
```

#### Possible error messages and how to solve them:

*explanation*
```

```

### 5.3 Editing an entry in list from food to exercise

Edits a particular food activity in list from food to exercise.
>Things you should take note of:
>* In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.
>* The list in which you want to edit to have to be pulled out first before being able to edit on it.
>* This commands edits the latest list pulled out. Thus, if `list 2020-10-21` is the latest list to be pulled out, then edita will edit index stated in date 2020-10-21's list.

Format: `edita **LIST_INDEX** e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**LIST_INDEX**`: Index of activity to be edited in list.
* `**EXERCISE_DESCRIPTION**`: New description of exercise done.
* `**CALORIE_COUNT**`: New amount of calories lost.

Example of usage:
* `list` before editing
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 42 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           apple_____________________________________________________30

2          Food           mushroom soup_____________________________________________77

3        Exercise         jumping___________________________________________________65
```

* `edita 2 e/ running c/ 99`

```
=====================================================================================================
Noted! The following has been edited:
[E] | running | 99

The current activity list has been saved.
=====================================================================================================
```

* `list` after editing
```
------------------------------------------
|  2020-10-28  |  Net Calorie: -52 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2        Exercise         running___________________________________________________99

3        Exercise         jumping___________________________________________________65
```

#### Possible error messages and how to solve them:

*explanation*
```

```

### 5.4 Editing an entry in list from exercise to exercise 

Edits a particular exercise activity in list. 
>Things you should take note of:
>* In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.
>* The list in which you want to edit to have to be pulled out first before being able to edit on it.
>* This commands edits the latest list pulled out. Thus, if `list 2020-10-21` is the latest list to be pulled out, then edita will edit index stated in date 2020-10-21's list.

Format: `edita **LIST_INDEX** e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**LIST_INDEX**`: Index of activity to be edited in list.
* `**EXERCISE_DESCRIPTION**`: New description of exercise done.
* `**CALORIE_COUNT**`: New amount of calories lost.

Example of usage:
* `list` before editing
```
list
------------------------------------------
|  2020-10-28  |  Net Calorie: -52 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2        Exercise         running___________________________________________________99

3        Exercise         jumping___________________________________________________65
```

* `edita 3 e/ strolling c/ 10`

```
=====================================================================================================
Noted! The following has been edited:
[E] | strolling | 10

The current activity list has been saved.
=====================================================================================================
```

* `list` after editing
```
------------------------------------------
|  2020-10-28  |  Net Calorie: -62 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2        Exercise         running___________________________________________________99

3        Exercise         strolling_________________________________________________10
```

#### Possible error messages and how to solve them:

*explanation*
```

```

### 5.5 Editing an entry in list from exercise to food 

Edits a particular exercise activity in list from exercise to food.  
>Things you should take note of:
>* In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.
>* The list in which you want to edit to have to be pulled out first before being able to edit on it.
>* This commands edits the latest list pulled out. Thus, if `list 2020-10-21` is the latest list to be pulled out, then edita will edit index stated in date 2020-10-21's list.

Format: `edita **LIST_INDEX** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**LIST_INDEX**`: Index of activity to be edited in list.
* `**FOOD_DESCRIPTION**`: New description of food consumed.
* `**CALORIE_COUNT**`: New amount of calories consumed.

Example of usage:
* `list` before editing
```
------------------------------------------
|  2020-10-28  |  Net Calorie: -62 kcal  |
------------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2        Exercise         running___________________________________________________99

3        Exercise         strolling_________________________________________________10
```

* `edita 3 f/ chicken rice c/ 150`

```
=====================================================================================================
Noted! The following has been edited:
[F] | chicken rice | 150

The current activity list has been saved.
=====================================================================================================
```

* `list` after editing
```
-----------------------------------------
|  2020-10-28  |  Net Calorie: 88 kcal  |
-----------------------------------------
No.        Type                        Description                        Calories gain or lost
-----------------------------------------------------------------------------------------------
1          Food           orange____________________________________________________35

2        Exercise         running___________________________________________________99

3          Food           chicken rice______________________________________________150
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 6.0 Find

<br>

### 6.1 Finding entries via keyword - basic

Finds activity based on keywords entered and list them out. Allows user to search by activity description or calorie count.
>Additionally, you can use the advanced find commands to find all matching keywords or just one matching keyword.

Format for find by description: `find d/ **DESCRIPTION**`

Parameters:
* `**DESCRIPTION**`: Keyword to look for from description list.

Example of usage:
* `find d/ running`

```
1. 2020-10-19 [E] | running | 100
The current activity list has been saved.
```

Format for find by calorie: `find c/ **CALORIE**`

Parameters:
* `**CALORIE**`: Keyword to look for from calorie list.

Example of usage:
* `find c/ 100` 

```
1. 2020-10-19 [E] | running | 100
The current activity list has been saved.
```

### 6.2 Finding entries via keywords - advanced

Format for find by all descriptions: `find a/ **DESCRIPTION1** / **DESCRIPTION2** / **DESCRIPTION3** ...`
> This command will search of entries matching ALL description keywords typed. There is no limit to the number of descriptions allowed.

Parameters:
* `**DESCRIPTION1**`: Keyword to look for from calorie list.
* `**DESCRIPTION2**`: Keyword to look for from calorie list.
* so on...

Example of usage:
 * `find a/running a/ 10km / 5pm`
 
```
1. 2020-10-19 [E] | running at stadium for 10km at 5pm evening | 100
The current activity list has been saved.
```

Format for find by just one matching description: `find e/ **DESCRIPTION1** e/ **DESCRIPTION2** e/ **DESCRIPTION3** ...`
> As long as just one of the description keywords matches in the entry, the activity will be listed. There is no limit to the number of descriptions allowed.

Parameters:
* `**DESCRIPTION1**`: Keyword to look for from calorie list.
* `**DESCRIPTION2**`: Keyword to look for from calorie list.
* so on...

Example of usage:
* `find e/ sleeping / 5pm` 

```
1. 2020-10-19 [E] | running at stadium for 10km at 5pm evening | 100
The current activity list has been saved.
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 7.0 Move

<br>

### 7.1 Moving an activity to another position

Moves an activity to another position in the last shown list.

Format: `move from/ **INDEX1** below/ **INDEX2**`

Parameters:
* `**INDEX1**`: Index of the activity to be moved from.
* `**INDEX2**`: Index of the activity to be inserted below.

Examples of usage:
* After a `list 2020-10-11` command, <\br>
 `move from/ 3 below/ 1` moves the 3rd entry in the list for below the 1st entry as shown below.

Examples of usage: 
* `move from/ 5 below/ 2`

*`list 2020-10-11` before moving

```
1. [F] | breakfast | 100
2. [F] | second breakfast | 100
3. [F] | tea break | 200
```

*`list 2020-10-11` after `move from/ 3 below/ 1`

```
1. [F] | breakfast | 100
2. [F] | tea break | 200
3. [F] | second breakfast | 100
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 8.0 Delete

<br>

### 8.1 Deleting an entry in list

Deletes an entry via index in the last shown list.

Format: `delete **INDEX**`

Parameters:
* `**INDEX**`: Index of activity to be deleted in the last shown list.

Example of usage:
* `list` before deleting

```
1. [F] | apple | 200
2. [F] | melon | 300
3. [F] | banana | 150
4. [F] | orange | 100
```

* `delete 2`

```
Activity removed!
The current activity list has been saved.
```

* `list` after deleting

```
1. [F] | apple | 200
2. [F] | banana | 150
3. [F] | orange | 100
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

### 8.2 Deleting all entries in list

Deletes all entry in list.

Format : `delete /all`

Example of usage:
* `list` before deleting

```
1. [F] | apple | 200
2. [F] | banana | 150
3. [F] | orange | 100
```

* `delete /all`

```
The current activity list has been saved.
```

* `list` after deleting

```
Nothing was added!
```

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 9.0 Graph

<br>

### 9.1 Showing past net calories

Shows a graph of target calorie and net calorie obtained upto last 7 days.

Format: `graph`

Example of usage:
* `graph`

```
2100|      |-|                           
    |      | |                           
    |      | |                           
1886|******|*|***************************
    |      | |         |-|               
    ||-|   | |         | |               
    || |   | |   |-|   | |               
    || |   | |   | |   | |               
    || |   | |   | |   | |               
    || |   | |   | |   | |   |-|         
1210|| |   | |   | |   | |   | |   |-|   
    |-+-----+-----+-----+-----+-----+--
    21/10 22/10 23/10 24/10 25/10 26/10 
```
> `***` shows the target calories.
> If less than 7 days are stored in storage file, all the days will be displayed

#### Possible error messages and how to solve them:

*explanation*
```

```

<br>
<br>

## 10.0 Exiting the program

Saves the current list to file and exits program.

Format: `bye`

Example of usage:
* `bye`

```
=====================================================================================================
| Thank you for using traKCAL. See you again!                                                       |
=====================================================================================================
```

<br>

# Frequently asked questions
This section answers questions you may have.

**Q**: How do I transfer my data to another computer? 

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous **traKCAL** folder.

**Q**: How do I know if the data I have input is saved?

**A**: **trakCAL** autosaves data. Unless an error message is printed out, the data entered is saved.

**Q**: Q3

**A**: ANS3

<br>

# Command Summary

This section gives you a cheat sheet of commands available.
>Things you should take note of:
>* Input that look like THIS are parameters to be supplied by user.

Action         | Format | Example
-------------- | ---------- | --------
Help | `help` | `help`
Create User Profile | `create new user` | `create new user`
Add Food | `add e/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ ice cream c/ 78 d/ 2020-10-19`
Add Exercise | `add e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ jumping c/ 65 d/ 2020-10-19`
List | `list` OR `list DATE` | `list` OR `list 2020-10-24` 
Edit Profile | `edit n/ NAME, g/ GENDER, w/ WEIGHT, h/HEIGHT, a/ AGE, af/ ACTIVITY_FACTOR, goal/ WEIGHT_GOALS` | `edit n/ Sam g/ female w/ 50 h/ 165 a/ 10 af/ 4 goal/ gain`
Edit Activity to Food | `edita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT` | `edita 1 f/ ice kacang c/150`
Edit Activity to Exercise | `edita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT` | `edita 1 e/ running c/100`
Find Description | `find d/ DESCRIPTION` | `find d/ apple`
Find Calorie | `find c/ CALORIE` | `find c/ 55`
Find Either | `find e/ DESCRIPTION1 e/ DESCRIPTION2 e/ DESCRIPTION3 ...` | `find e/ apple e/ orange e/ grape ...`
Find All | `find a/ DESCRIPTION1 a/ DESCRIPTION2 a/ DESCRIPTION3 ...` | `find a/ running a/ jumping a/ cake ...`
Move Activity | `move from/ INDEX1 below/ INDEX2` | `move from/ 5 below/ 2`
Delete Entry | `delete INDEX` | `delete 2`
Delete All for Today| `delete all/` | `delete all/`
Graph | `graph` | `graph`
Exit | `bye` | `bye`