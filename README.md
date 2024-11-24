
### A Reverse Polish Notation (RPN) calculator implementation.

* This calculator allows users to input numbers and perform operations in RPN format.
* Operations include basic arithmetic, stack manipulation, and calculator control.

### First draft : 24/11/2024

After failing to write pseudocode :
* Did not understand scope / assignment
* Did not understand the problem
* Did not compartmentalize the solution :
  * Made the problem bigger than it could be
  * No big picture
  * Solution all over the place
    * Poor and ugly code that made maintenance and refactoring a nightmare.
    
Writing pseudocode :
* Helped in visualising the overall problem
* Helped in creating individual pieces 
* Made working on the logic inside the pieces easier
```
DECLARE String userInput
DECLARE boolean isUserInputValid <- FALSE
DECLARE boolean isNumber <- FALSE
DECLARE boolean isStringOfOne <- FALSE
DECLARE List Double Number <- numbers
DECLARE compute() <- method of Calculator

STORE userInput
	DO menu
	WHILE (!isUserInputValid)

CHECK userInput with TRY CATCH
	TRY userInput is an int or double
		isNumber <- TRUE
	CATCH relevant exceptions
		isStringOfOne <- TRUE
	TRY userInput is a String of length 1
		isStringOfOne <- TRUE
	CATCH relevant exceptions
	
	IF isNumber is TRUE
		add to List numbers
	ELSE IF isStringOfOne
		CASE c
		CASE e
		CASE i
		CASE q
		CASE +
		CASE -
		CASE *
		CASE /
		default
	END IF
```

### Version 0.1

* POSITIVE 
    * The overall architecture works. Hooray !
* NEGATIVES
  * Pseudocode sucked.
    * No logic in the Switch
    * Too many declared variables
    * The overall system implemented shows the assignment was poorly understood.
  * The source code sucks.
    * Poor pseudocode makes for poor source code.
    * Poor use of javadoc

Refactoring is necessary in order for version 0.2 to see the light.  
Soon my child. Soon.

### Version 0.15

Re-doing the pseudocode.




