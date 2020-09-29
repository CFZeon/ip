# User Guide

Duke is a functional todo-list for managing your all your tasks, using the Command Line Interface (CLI). 

* [Quick Start](#quick-start)
* [Features](#features)
    + [1. help](#1-help)
    + [2. list](#2-list)
    + [3. todo](#3-todo)
    + [4. deadline](#4-deadline)
    + [5. event](#5-event)
    + [6. done](#6-done)
    + [7. delete](#7-delete)
    + [8. find](#8-find)
    + [9. dateSearch](#9-dateSearch)
    + [9. bye](#9-bye)
* [Command Summary](#command-summary)

## Quick Start

1. Ensure that you have java *11* installed in your computer
2. Download duke.jar to a convenient folder
3. Navigate to the folder in command prompt and run it with `java -jar duke.jar`
4. Type `help` to see a list of commands for Duke

## Features

Duke can do the following:
* `help`: Provides a list of commands and how to use them
* `list`: List all of your current tasks
* `todo`: Add a todo to your list
* `deadline`: Add a deadline to your list
* `event`: Add an event to your list
* `done`: Mark an available task as done
* `delete`: Deletes a task
* `find`: Finds tasks that contain a keyword or string
* `dateSearch`: Finds tasks that are on that date
* `bye`: Terminates the application


### 1. help

Prints out a list of all available commands

##### Usage

Format: `help`


### 2. list
Prints out the list of all tasks

##### Usage

Format: `list`


### 3. todo
Adds a todo task to the list of tasks

##### Usage

Format: `todo [task description]`


### 4. deadline
Adds a deadline task to the list of tasks

##### Usage

Format: `deadline [task description] /[time limit] [date or string]`


### 5. event
Adds an event task to the list of tasks

##### Usage

Format: `event [task description] /[time limit] [date or string]`


### 6. done
Marks a task as done

##### Usage

Format: `done [task number]`


### 7. delete
Removes a task from the list

##### Usage

Format: `delete [task number]`


### 8. find
Finds tasks with a keyword or string the user inputs

##### Usage

Format: `find [keyword or string]`


### 9. dateSearch
Search through the list of tasks by date

##### Usage

Format: `dateSearch [date]`


### 10. bye
Exits this application

##### Usage

Format: `bye`


## Command Summary

Command | Format | Example
-------- | ---------- | ------------
help | `help` | -
list | `list` | -
todo | `todo [task description]` | `todo study for exams`
deadline | `deadline [task description] /[time limit] [date or string]`| `deadline` submit report /before 31/12/2020
event | `event [task description] /[time limit] [date or string]` | `event` TED talk /at 30-12-2020
find | `find [keyword or string]` | `find study`
done | `done [task number]`  | `done 3`
delete | `delete [task number] | `delete 4`
help | `help` | -
bye | `bye` | -