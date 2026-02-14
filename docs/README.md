# Toto User Guide🤖
<img src="/docs/Ui.png" width="250" alt="Ui image">

Toto is a **task management chatbot** designed to  manage your to-dos, deadlines and events easily through a GUI interface. Allowing you to stay *organized* and *stress-free*.

## Adding Todo
Add a todo task with no deadline to your list.

**Format:** `todo TASK_DESCRIPTION`

**Example:**

input: `todo read book`

output:
```
Task received! Toto has added this task:
[T][] read book
Now you have 1 task(s) in the list!
```

## Adding deadlines
Add a deadline task with an end date to your list.

**Format:** `deadline TASK_DESCRIPTION /by YYYY/M/D`

**Example:**

input: `deadline math homework /by 2026/11/20`

output:
```
Task received! Toto has added this task:
[D][] math homework (by: Nov 20 2026)
Now you have 1 task(s) in the list!
```

## Adding Events
Add an event task with a start and end date-time to your list.

**Format:** `deadline TASK_DESCRIPTION /from YYYY/M/D HHMM /to YYYY/M/D HHMM`

**Example:**

input: `event ZZZ concert /from 2026/11/20 1400 /to 2026/11/20 1930 `

output:
```
Task received! Toto has added this task:
[E][] ZZZ concert (by: Nov 20 2026 1400 to: Nov 20 2026 1930)
Now you have 1 task(s) in the list!
```

## List Tasks Added

Provide a list of all tasks added previously.

**Format:** `list`

**Example:**

input: `list`

output:
```
Task delivery! Toto's got your back:
1. [T][] read book
2. [D][] math homework (by: Nov 20 2026)
3. [E][] ZZZ concert (by: Nov 20 2026 1400 to: Nov 20 2026 1930)
```

## Mark/Unmark a Task
Finished a task? Mark a task complete.

Realised your task is not complete? Unmark a task.

**Format:** `mark TASK_NUMBER`, `unmark TASK_NUMBER`

**Example #1:**

input: `mark 1`

output:
```
Done! Toto is very happy :)
[T][X] read book
```

**Example #2:**

input: `unmark 1`

output:
```
Oh no! Back to work!
[T][] read book
```

## Delete a Task
Does your task list feel cluttered? Delete a task from your list.

**Format:** `delete TASK_NUMBER`

**Example:**

input: `delete 1`

output:
```
Task Deleted! Toto has removed this task:
[T][] read book
```

## Find a Task
Need help searching for a task? Search for the task's keyword.

**Format:** `find KEYWORD`

**Example:**

input: `find math`

output:
```
Task has compiled all the matching tasks:
1. [D][] math homework (by: Nov 20 2026)
```

## View Schedule
Need help planning? Check which task is due before the input date.

**Format:** `view YYYY/M/D`

**Example:**

input: `list`

output:
```
Task delivery! Toto's got your back:
1. [D][] math homework (by: Nov 20 2026)
2. [E][] ZZZ concert (by: Nov 20 2026 1400 to: Nov 20 2026 1930)
3. [T][] read book
4. [D][] PW (by: Sep 2 2026)
5. [D][] PW2 (by: Nov 9 2026)
```


input: `view 2026/11/2`

output:
```
|-------------------------------|
| Type   |Task                  |
|-------------------------------|
  T       read book             
  T       PW                    

Total task(s): 2
```

## Sort Task List
Sort your task alphabetically.

**Format:** `sort`

**Example:**

input: `list`

output:
```
Task delivery! Toto's got your back:
1. [D][] math homework (by: Nov 20 2026)
2. [E][] ZZZ concert (by: Nov 20 2026 1400 to: Nov 20 2026 1930)
3. [T][] read book
4. [D][] PW (by: Sep 2 2026)
5. [D][] PW2 (by: Nov 9 2026)
```

input: `sort`

output:
```
Task delivery! Toto's got your back:
1. [D][] math homework (by: Nov 20 2026)
2. [D][] PW (by: Sep 2 2026)
3. [D][] PW2 (by: Nov 9 2026)
4. [T][] read book
5. [E][] ZZZ concert (by: Nov 20 2026 1400 to: Nov 20 2026 1930)
```

## NOTE
- Commands are **not** case-sensitive
- Task numbers are based on the current list of tasks
  
