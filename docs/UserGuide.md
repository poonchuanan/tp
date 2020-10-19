# User Guide for traKCAL

## Introduction

{Give a product intro}
traKCAL is an application for managing calories intake, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). 
If you can type fast, traKCAL can get your calorie intake input recorded faster than traditional GUI applications.

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

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}
* traKCAL has many commands available. Such as 'create new user', 'add', 'edit', 'delete', 'list', 'find'.

>Things to take note of:
>* Input that look like `**this**` are parameters to be supplied by user.
>* Input format should strictly adhere to the one in the help list or in this user guide.
>* Input commands such as `add`, `edit`, `list`, etc. are not case-sensitive, but it is recommended to follow format stated in help list or this user guide.

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/**TODO_NAME** d/**DEADLINE**`

* The `**DEADLINE**` can be in a natural language format.
* The `**TODO_NAME**` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Setting up program in Intellij

### Viewing help
Prints out the commands available, and their respective input format.

Format: `help`

Example:
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

### Adding a target calorie

### Adding a food entry
Adds a food entry with its respective calories to the list.

Format: `add f/ **FOOD_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**FOOD_DESCRIPTION**`: Description of food consumed.
* `**CALORIE_COUNT**`: Amount of calories consumed.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples:
* `add f/ ice cream c/ 78 d/ 2020-10-19`
```javascript
[F] | ice cream | 78
The current activity list has been saved.
```

### Adding an exercise entry
Adds an exercise entry with its respective calories to the list.

Format: `add e/ **EXERCISE_DESCRIPTION** c/ **CALORIE_COUNT** d/ **DATE**`

Parameters:
* `**EXERCISE_DESCRIPTION**`: Description of exercise lost.
* `**CALORIE_COUNT**`: Amount of calories lost.
* `**DATE**`: Date in the format YYYY-MM-DD, where YYYY = year, MM = month, DD = day.

Examples:
*`add e/ jumping c/ 65 d/ 2020-10-19`
```javascript
[E] | jumping | 65
The current activity list has been saved.
```

### Listing entries for the day

### Editing user profile

### Editing an entry in list

### Finding entries via keyword

### Deleting entry in list

### Deleting all entries in list

### Exiting the program
Saves the current list to file and exits program.

Format: `bye`

Example:
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

Action     | Format, Example
---------- | ----------
Help | `help`
Exit | `bye`

### --- END OF USER GUIDE ---
