Description
-----------

Write a program that processes the attached example file that contains
peoples' names, outputs some statistics and generates updated output.

Input:

 . An arbitrary file with the same format as the attached example file.


Output:

  1. The number of unique names
  2. The ten most common last names (the names and number of occurrences)
  3. The ten most common first names (the names and number of occurrences)
  4. A list of 50 unique names. (see below for details)


Assumptions About Names
-----------------------

Here are some assumptions you can make about names which are meant to
make the program easier to write:

. Names start at the beginning of the line.
. Names follow these rules:
  . Formatted "Lastname, Firstname"
  . Alphabetic

Names that don't follow those rules can be ignored.



List of 50 Unique Names
--------------------------

Take the first 50 names from the list where the following is true:

  . No other name has the same first name
  . No other name has the same last name

  For example, consider these names:

    Smith, Joan
    Smith, John
    Smith, Sam
    Thomas, Joan
    Upton, Joan
    Upton, Tom
    Vasquez, Cesar

  These names would be part of the new list:

    Smith, Joan
    Upton, Tom
    Vasquez, Cesar

  These names would not:

    Smith, John     # Already have a last name "Smith"
    Smith, Sam      # Already have a last name "Smith"
    Thomas, Joan    # Already have a first name "Joan"
    Upton, Joan     # Already have a first name "Joan"

After you have this list of 50 names, create an output file that contains a
50 different names.  These different names should only use first names and
last names from the original 50 names.  However, the new list and the old
list should not share any full names:

  For example, if the file contains the names:

    Brutananadilewski, Carl
    Crews, Xander
    Cartman, Eric
    ... 47 more names ...

  Then this is a valid output:

    Brutananadilewski, Eric
    Crews, Carl
    Cartman, Xander
    ... 47 more names ...
     
  But this is not (because "Barney" and "Bambam" weren't in the original file):

    Brutananadilewski, Fred
    Crews, Barney
    Cartman, Bambam
    ... 47 more names ...

  This is also incorrect (because "Cartman, Eric" is unchanged):        
 
    Brutananadilewski, Xander
    Crews, Carl
    Cartman, Eric
    ... 47 more names ...

  This is also incorrect (because "Carl" is used multiple times):        
 
    Brutananadilewski, Xander
    Crews, Carl
    Cartman, Carl
    ... 47 more names ...



Other Notes
-----------

. You can pick the implementation language: Ruby, Python, C, Java,
  Scheme are all great choices.  Something like bash is not.  Feel
  free to use any libraries you would find helpful.
. The program should provide the correct answer!
. The program should be as time and memory efficient as you can
  make it.
. The program should be as concise and readable as possible.
. Brief comments explaining implementation choices are welcome.
. You can hard code the name of the input file into your program 
  (to make it easier to write) but it should otherwise be built to
  handle an arbitrary file with the same format as the example file.



