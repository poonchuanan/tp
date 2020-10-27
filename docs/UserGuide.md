# User Guide for traKCAL

By: CS2113-T09-4    Since: September 2020   Licence: MIT

<br>

## Introduction

**traKCAL** is a desktop application for managing calories' intake, optimized for use via Command Line Interface (CLI) whilst retaining the benefits of a Graphical User Interface (GUI). 
If you type fast, **traKCAL** can manage your activities faster than traditional GUI applications, and is perfect for you.

The purpose of this user guide is to guide the users on the commands available in this application, their respective uses and the expected inputs.

**traKCAL** is available for the download on all major Operating Systems(OS) such as Windows, Mac and Linux.

<br>

## Table of Contents

The section displays the table of contents showing all the available features in **trakCAL**

* [Quick Start](#quick-start)
* [Features](#features)
    * [Viewing help](#viewing-help): `help`
    * [Creating a profile for new user](#creating-a-profile-for-new-user): `create new user`
    * [Creating a set of entries](#creating-a-shortcut-for-a-set-of-entries): `createSet`
    * [Adding a target calorie](#adding-a-target-calorie): `target`
    * [Adding a food entry](#adding-a-food-entry): `add`
    * [Adding an exercise entry](#adding-an-exercise-entry): `add`
    * [Adding a set of entries](#adding-a-set-of-entries): `addSet`
    * [Listing entries for the day](#listing-entries-for-the-day): `list`
    * [Editing user profile](#editing-user-profile): `edit`
    * [Editing an entry in list](#editing-an-entry-in-list): `edita`
    * [Finding entries via keyword](#finding-entries-via-keyword): `find`
    * [Moving an entry to another position](#moving-an-activity-to-another-position): `move`
    * [Deleting an entry in list](#deleting-an-entry-in-list): `delete`
    * [Deleting all entries in list](#deleting-all-entries-in-list): `deleteALL`
    * [Showing past net calories](#showing-past-net-calories): `graph`
    * [Exiting the program](#exiting-the-program): `bye`
* [Frequently asked questions](#frequently-asked-questions)
* [Command Summary](#command-summary)

<br>

## Quick Start

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

## Features 

This section gives you a detailed description of each feature available in **trakCAL**.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should STRICTLY adhere to the one in the help list or in this user guide.
>* Commands such as `add`, `edit`, `list`, etc. are not case-sensitive, but it is recommended for you to follow format stated in help list or this user guide.

<br>
<br>

## Viewing help

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
	edit n/ NAME, g/ GENDER, w/ WEIGHT, h/HEIGHT, a/ AGE, af/ ACTIVITY_FACTOR, goal/ WEIGHT_GOALS
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
	find d/ DESCRIPTION    - Searches for exercise/food description with DESCRIPTION included
	find c/ CALORIE_COUNT  - Searches through activity list with calories of CALORIE_COUNT
	find e/ EITHER         - 
	find a/ ALL            - 
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

## Creating a profile for new user

If this is your first time using **tracKCAL**, you will be automatically prompted to create a user profile and there is no need for you to input this command.
**TracKCAL** will then use these details from your user profile to calculate the following: 

* BMI
* Recommended daily calorie
* Calorie goal to reach weight goal

>However, if you want to create a new profile for an existing user, you will need to use this command

Format: `create new user`

Example of usage:
* `create new user`

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
```

<br>
<br>

## Creating a shortcut for a set of entries 

This command creates a shortcut for a set of commonly called exercise and/or food entries, reducing the amount of time needed for you to add in multiple common entries. 

Format: `createSet **SHORTCUT_NAME** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** && f/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** && ...`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**SHORTCUT_NAME**`: Name of shortcut/set.

Example of usage: 
*  `createSet bfast f/ ice cream c/ 78 && e/ jumping jacks c/ 100`

Snippet of code for correct usage: 
```
The current activity list has been saved.
```

Possible error message: 
* ```Place holder```
You can solve this by ....

<\br>
<\br>

##Adding a target calorie

<\br>
<\br>

## Adding a food entry

Adds a food entry with its respective calories to the list.

Format: `add f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories consumed.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage:
* `add f/ ice cream c/ 78 d/ 2020-10-19`

```
[F] | ice cream | 78
The current activity list has been saved.
```

<br>
<br>

## Adding an exercise entry

Adds an exercise entry with its respective calories to the list.

Format: `add e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples of usage: 
* `add e/ jumping c/ 65 d/ 2020-10-19`

```
[E] | jumping | 65
The current activity list has been saved.
```

<br>
<br>

## Adding a set of entries

Adds a set of repeated entries at once.

Format: `addSet **SHORTCUT_NAME**`

Parameters:
* `**SHORTCUT_NAME**`: Name of shortcut.

Example of usage: 
* `addSet bfast`

```
[F] | ice cream | 78
The current activity list has been saved.

[E] | jumping jacks | 100
The current activity list has been saved.
```

<br>
<br>

## Listing entries for the specified day

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

<br>
<br>

## Editing user profile

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

<br>
<br>

## Editing an entry in list

Edits activity, food or exercise at the stated index in the list.  
>Things you should take note of:
>* In addition, this feature allows the changing of a food activity to exercise activity in the list. Vice versa.
>* The list in which you want to edit to have to be pulled out first before being able to edit on it.
>* This commands edits the latest list pulled out. Thus, if `list 2020-10-21` is the latest list to be pulled out, then edita will edit index stated in date 2020-10-21's list.

Format: `edita **LIST_INDEX** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT**` OR `edita **LIST_INDEX** e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**LIST_INDEX**`: Index of activity to be edited in list.
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**CALORIE_COUNT**`: Amount of calories consumed.

Example of usage:
* `list`

```
1. [F] | pudding | 66
```

* `edita 1 e/ running c/100`

```
[E] | running | 100
The current activity list has been saved.
```

<br>
<br>

## Finding entries via keyword

Finds activity based on keywords entered and list them out. Allows user to search by activity description or calorie count.
>Additionally, you can use the advanced find commands to find all matching keywords or just one matching keyword.

Format for find by description: `find d/**DESCRIPTION**`

Parameters:
* `**DESCRIPTION**`: Keyword to look for from description list.

Example of usage:
* `find d/running`

```
1. 2020-10-19 [E] | running | 100
The current activity list has been saved.
```

Format for find by calorie: `find c/**CALORIE**`

Parameters:
* `**CALORIE**`: Keyword to look for from calorie list.

Example of usage:
* `find c/100` 

```
1. 2020-10-19 [E] | running | 100
The current activity list has been saved.
```

Format for find by just one matching description: `find e/**DESCRIPTION1** e/**DESCRIPTION2** e/**DESCRIPTION3** ...`
> As long as just one of the description keywords matches in the entry, the activity will be listed. There is no limit to the number of descriptions allowed.

Parameters:
* `**DESCRIPTION**`: Keyword to look for from calorie list.
* `**DESCRIPTION1**`: Keyword to look for from calorie list.
* so on...

Example of usage:
* `find e/sleeping e/5pm` 

```
1. 2020-10-19 [E] | running at stadium for 10km at 5pm evening| 100
The current activity list has been saved.
```

Format for find by all descriptions: `find a/**DESCRIPTION1** a/**DESCRIPTION2** a/**DESCRIPTION3** ...`
> This command will search of entries matching ALL description keywords typed. There is no limit to the number of descriptions allowed.

Parameters:
* `**DESCRIPTION**`: Keyword to look for from calorie list.
* `**DESCRIPTION1**`: Keyword to look for from calorie list.
* so on...

Example of usage:
 * `find a/running a/10km a/5pm`
 
```
1. 2020-10-19 [E] | running at stadium for 10km at 5pm evening| 100
The current activity list has been saved.
```

<br>
<br>

## Moving an activity to another position

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

<br>
<br>

## Deleting an entry in list

Deletes an entry via index in the last shown list.

Format: `delete **INDEX**`

Parameters:
* `**INDEX**`: Index of activity to be deleted in the last shown list.

Example of usage:
* `list` before deletion

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

* `list` after deletion

```
1. [F] | apple | 200
2. [F] | banana | 150
3. [F] | orange | 100
```

<br>
<br>

## Deleting all entries in list

Deletes all entry in list.

Format : `delete /all`

Example of usage:
* `list` before deletion

```
1. [F] | apple | 200
2. [F] | banana | 150
3. [F] | orange | 100
```

* `delete /all`

```
The current activity list has been saved.
```

* `list` after deletion

```
Nothing was added!
```

<br>
<br>

## Showing past net calories

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

<br>
<br>

## Exiting the program

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

## Frequently asked questions
This section answers questions you may have.

**Q**: How do I transfer my data to another computer? 

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous **traKCAL** folder.

**Q**: Q2

**A**: ANS2

**Q**: Q3

**A**: ANS3

<br>

## Command Summary

This section gives you a cheat sheet of commands available.
>Things you should take note of:
>* Input that look like THIS are parameters to be supplied by user.

Action         | Format | Example
-------------- | ---------- | --------
Help | `help` | `help`
Create User Profile | `create new user` | `create new user`
Add Target Calorie | `target CALORIE` | `target 500`
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