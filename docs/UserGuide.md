# User Guide for traKCAL

By: CS2113-T09-4    Since: September 2020   Licence: MIT


## Introduction

**traKCAL** is a desktop application for managing calories' intake, optimized for use via Command Line Interface (CLI) whilst retaining the benefits of a Graphical User Interface (GUI). 
If you type fast, **traKCAL** can manage your activities faster than traditional GUI applications, and is perfect for you.

The purpose of this user guide is to guide the users on the commands available in this application, their respective uses and the expected inputs.

**traKCAL** is available for the download on all major Operating Systems(OS) such as Windows, Mac and Linux.


## Table of Contents

The section displays the table of contents showing all the available features in **trakCAL**

* [Quick Start](#quick-start)
* [Features](#features)
    * [Viewing help](#viewing-help): `help`
    * [Creating a profile for new user](#creating-a-profile-for-new-user): `create new user`
    * [Creating a set of entries](#creating-a-set-of-entries): `createSet`
    * [Adding a target calorie](#adding-a-target-calorie): `target`
    * [Editing user profile](#editing-user-profile): `edit`
    * [Adding a food entry](#adding-a-food-entry): `add`
    * [Adding an exercise entry](#adding-an-exercise-entry): `add`
    * [Adding a set of entries](#adding-a-set-of-entries): `addSet`
    * [Listing entries for the day](#listing-entries-for-the-day): `list`
    * [Moving an entry to another position](#moving-an-activity-to-another-position): `move`
    * [Editing an entry in list](#editing-an-entry-in-list): `edita`
    * [Finding entries via keyword](#finding-entries-via-keyword): `find`
    * [Deleting an entry in list](#deleting-an-entry-in-list): `delete`
    * [Deleting all entries in list](#deleting-all-entries-in-list): `deleteALL`
    * [Showing past net calories](#showing-past-net-calories): `graph`
    * [Exiting the program](#exiting-the-program): `bye`
* [Frequently asked questions](#frequently-asked-questions)
* [Command Summary](#command-summary)


## Quick Start

This section gives the steps you need to get started quickly.

1. Ensure that you have Java 11 or above installed
2. Down the latest version of `Duke` from [here](http://link.to/duke)
3. Create an empty folder in a convenient location eg. Desktop and copy jar file there
4. Open command window/terminal in that window and run the command `java -jar {filename}.jar` e.g., `java -jar tp.jar`
5. Upon successful run, the following greeting message will be shown

```
=========================================================================================
| Hello from                                                                            |
|  _                  _  __   ___     _     _                                           |
| | |_   _ _   __ _  | |/ /  / __|   /_\   | |                                          |
| |  _| | '_| / _` | | ' <  | (__   / _ \  | |__                                        |
|  \__| |_|   \__,_| |_|\_\  \___| /_/ \_\ |____|                                       |
|                                                                                       |
| Hello! I'm traKCAL.                                                                   |
=========================================================================================
Please do input 'help' for the commands and their respective input format.
```
6. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window<br/>
   Some example commands you can try:
    * `list`: Lists all activities for today
    * `add f/ rice with eggs c/ 200`: Adds a food entry named `rice with eggs` to **traKCAL**.
    * `delete 3`: Deletes the 3rd contact shown in the current list.
    * `bye`: Exits the application.
7. Refer to the [Features](#features) below for details of each command


## Features 

This section gives a detailed description of each feature available in **trakCAL**.
> **traKCAL** has many commands available. Such as 'create new user', 'add', 'edit', 'delete', 'list', 'find'.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should STRICTLY adhere to the one in the help list or in this user guide.
>* Input commands such as `add`, `edit`, `list`, etc. are not case-sensitive, but it is RECOMMENDED to follow format stated in help list or this user guide.





## Viewing help

Prints out the commands available, and their respective input format.

Format: `help`

Example of usage:
* `help`

```
=========================================================================================
Commands available: create new user, list, help, add, delete, find, bye

The expected format of input values:
	create new user         - Adds a new user profile
	target X                - Adds a target calorie, X
	help                    - Prints out commands available and their input format
	add f/ X c/ Y d/ Z      - Adds food consumed, X, calories gained, Y
	                          and date(YYYY-MM-DD), Z
	add e/ X c/ Y d/ Z      - Adds exercise done, X, calories lost, Y
	                          and date(YYYY-MM-DD), Z
	list                    - Prints out the list of entries.
	edit n/U, g/V, w/W, h/X, a/Y, af/Z
	                        - Edit user profile to name, U, gender, V, weight, W,
	                          height, X, age, Y, activity factor(1-5), Z
	edita W f/ X c/ Y       - Edits activity at index W of list to food consumed, X,
	                          calories gained, Y
	edita W e/ X c/ Y       - Edits activity at index W of list to exercise done, X,
	                          calories lost, Y
	find d/ X               - Searches for exercise/food description with X included
	find c/ X               - Searches for activity description with calories of X
	move index/ X below/ Y  - Moves the activity at X to the index below Y
	delete X                - Deletes activity located at index X of the list
	bye                     - Terminates the program
=========================================================================================
```


## Creating a profile for new user

**traKCAL** will check for first time user automatically. 
>However, if you want to create a totally new profile, this command allows you to do so

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


## Creating a set of entries 

Creates a shortcut for commonly called exercise and/or food entries.

Format: `createSet **SHORTCUT_NAME** f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** && f/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT**`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**EXERCISE_DESCRIPTION**`: Description of exercise done.
* `**SHORTCUT_NAME**`: Name of shortcut/set.

Example of usage: 
*  `createSet bfast f/ ice cream c/ 78 && e/ jumping jacks c/ 100`

```
The current activity list has been saved.
```


## Adding a target calorie

Interprets the answers from the user profile questionnaire to calculate health profile.

tracKCAL calculates: 
* BMI
* Recommended daily calorie
* Calorie goal to reach weight goal

Example of calculated health profile: 

```
Your BMI is 20.
Your recommend daily calories intake is 1576.65 calories.
To gain weight, you should consume 2076.65 calories instead.
```


## Editing user profile

Edits user profile of an existing user.

Format: `edit n/**NAME** g/**GENDER** w/**WEIGHT** h/**HEIGHT** a/**AGE** af/**ACTIVITY_FACTOR** goal/**WEIGHT_GOALS**`

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


## Editing an entry in list

Edits activity, food or exercise at the stated index in the list.  
>Things to take note of:
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
> If less than 7 days are stored, all the days will be displayed


## Exiting the program

Saves the current list to file and exits program.

Format: `bye`

Example of usage:
* `bye`

```
=========================================================================================
| Thank you for using traKCAL. See you again!                                           |
=========================================================================================
```

## Frequently asked questions
This section answers questions you may have.

**Q**: How do I transfer my data to another computer? 

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous **traKCAL** folder.

## Command Summary

This section gives you a cheat sheet of commands available.

Action         | Format | Example
-------------- | ---------- | --------
Add food | `add e/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ ice cream c/ 78 d/ 2020-10-19`
Add exercise | `add e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE` | `add e/ jumping c/ 65 d/ 2020-10-19`
Edit activity | `edita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT` | `edita 1 f/ ice kacang c/150`
Edit activity | `edita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT` | `edita 1 e/ running c/100`
List | `list` OR `list DATE` | `list` OR `list 2020-10-24` 
Move activity | `move from/ INDEX1 below/ INDEX2` | `move from/ 5 below/ 2`
Delete entry | `delete INDEX` | `delete 2`
Delete all | `delete /all` | `delete /all`
graph | `graph` | `graph`
Help | `help` | `help`
Exit | `bye` | `bye`