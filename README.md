
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

```
CLASS Calculator

DECLARE String MENU_TEMPLATE <- "\r\nVeuillez saisir un opérande ou une opération : "
                            + "\r\n+ : addition."
                            + "\r\n- : soustraction."
                            + "\r\n* : multiplication."
                            + "\r\n/ : division."
                            + "\r\nc : supprime tous les nombres."
                            + "\r\ne : efface le dernier nombre entré."
                            + "\r\ni : change de place les deux derniers nombres entré."
                            + "\r\nq : quitter.");
DECLARE List<Double> numbers;
DECLARE String userInput;
DECLARE boolean exit;

Start the calculator, continuously process user inputs until an exit command is given.
START calculator 
	DO show MENU_TEMPLATE and store the user input <- userInput
	IF input is a number
		PROCESS the number
	ELSE IF input is a String of length 1
		PROCESS the operation
	END IF
	WHILE exit is FALSE

Displays the calculator menu and gets user input.
The menu shows the current stack state and available operations.
SHOW menu and store the user input
	DISPLAY the stack <- displayStack
		FOR EACH number in numbers
			append number to displayStack
		END FOR
	SHOW MENU_TEMPLATE

Processes numeric input from the user.
Parses the input string and pushes the resulting number onto the stack	
PROCESS userInput as number
	TRY to CONVERT userInput to Double AND add to numbers
	CATCH Exception e <- should be a NumberFormatException
		SHOW error message	
PROCESS userInput as operation
	TRIM and LowerCase userInput
	TRY variable operation
		CASE q : exit is TRUE
		CASE c : clear numbers list
		CASE e : 	IF numbers is not empty
				USE method to remove last index of numbers
				ENDIF
		CASE i : swap last two numbers
		CASE +, *, -, / : perform arithmetic operation de la variable operation
		DEFAULT : error message

SWAP the last two numbers
	IF numbers has less than 2 number
		throw error
	ENDIF
	DECLARE last index of numbers <- last
	STORE last
	DECLARE second to last index of numbers <- secondLast
	STORE secondLast
	ADD last
	ADD secondLast

PERFORM operation on the last two numbers of the stack
	IF numbers has less than 2 number
		throw error
	ENDIF
	STORE last number <- numberA
	STORE second to last number <- NumberB
	STORE result of operation
	USE inputed operator
	CASE + : result = numberA + numberB
	CASE - : result = numberA - numberB
	CASE * : result = numberA * numberB
	CASE / : 	IF numberB == 0
				throw error ne peux pas diviser par 0
			ENDIF
			result = numberA / numberB
	DEFAULT
		error message : Opérateur inconnu ( utiliser la variable operator stockée )
```

I also added a Util folder and a utility class for possible future logs

````
UTILITY CLASS inputValidator

CHECK if the input string is a valid number after trimming <- isNumber
	IF input is NULL OR is empty
		RETURN FALSE
	ENDIF
	TRY to parse input into a Double
		RETURN TRUE
	CATCH Exception e <- NumberFormatException ?
		RETURN FALSE

CHECK if the input string has a length of 1
	STORE the expression into a temporary variable <-isOneChar (for logging purposes)
	RETURN isOneChar
````

Writing pseudocode takes a lot of time if you want to do it well  
In doing so you will SAVE time when writing your source code  
Weird, you need to take more time in order to save time.  
Crazy.

Now I will have to re-write my source code using the pseudocode in Version 0.15.  
Andale to Version 0.2 !!
