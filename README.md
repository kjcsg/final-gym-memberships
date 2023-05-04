Objective:

Create a database to hold membership information for a gym. You’ll create the following three classes:

Main.java (main class)
Database.java (database class)
Member.java (class to hold a single member's info)
Member Class:

For the Member class, create fields to hold the following information and create a constructor to initialize the member object with data for all these fields:

ID Number
First Name
Last Name
Year they joined
Their monthly dues
Age
Database Class:

The database class will have a private hash table field to hold all the member objects. Use the built-in Java hash table class called “HashMap”. You do not need to create your own hash table data structure.

Create a public ‘Add()’ method in the database class to add member objects. This method should accept a member object as an input argument and then add it to the hash table.

Create a public ‘Find()’ method in the database class to get a member’s info from the hash table. This method should accept a member ID number as an input argument and return a member object.

Create a private ‘Quicksort()’ method that gets all the member names in the hash table, sorts them by last name, and then returns the names as a sorted array. This method must use the Quicksort algorithm. This method must not modify the hash table.

Create a public ‘NamesString()’ method that calls the private Quicksort method to sort the names and then formats the sorted names into a String that is easy to read. This method should return the formatted String.

Main Class:

The flow of your main() method:

Create an instance of your database object.
Read in the gym members from the “GymMembers.txt” file (in Files->Final), create a member object for each one, and add them to the database by using its ‘Add()’ method. Their ID number will be their “key”.
Get the info for the member with ID#:1400 by using the ‘Find()’ method of the database. Print their info to the screen.
Print out all the gym members names in alphabetical order of last name by calling the ‘NamesString()’ method of the database.