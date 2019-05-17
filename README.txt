Name: Long Nguyen (ltn170130)
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 4
IDE used: NetBeans
Files: RedBlackTree.java, Project4.java(Main Class)

Run the program on: NetBeans IDE 8.2

1. Create a project on NetBeans, then put the two files RedBlackTree.java and Project4.java in the default package of the project

2. In the same working directory (default package of newly created project), create a file serves as input file of project

3. On the top left of NetBeans window, choose File -> Project Properties(project_name)

4. A new window pop up, choose Run Categories, then fillout Arguments and Working Directory:

	- Fillout Arguments with 2 arguments: the first one is input file name, and the second one is output file name, seperated by a whitespace
	- Fillout Working Directory with current directory of the project

5. The program will create a new file with name as passed from the arguments, and results are contained in this file.
(if the file already exist in the working directory (e.g. run the program twice with different content of input file), output file content will be re-wrote)

The program runs perfectly, with all the Exception are caught(including unable to open/read files, not just invalid key arguments)

Sample input 1:
Integer
Insert:98
Insert:-68
Insert:55
Insert:45
PrintTree
Contains:45
Insert:84
Insert:32
Insert:132
Insert:45
PrintTree
Insert
hih

Sample output 1:
true
true
true
true
55 -68 *45 98 
true
true
true
true
false
55 32 *-68 *45 98 *84 *132 
Error in Line: Insert
Error in Line: hih

Sample input 2:
true
true
true
true
Owen Ana *Leo Pete 
true
true
true
false
Owen *Leo Ana Nick *Maya Pete 

Sample input 3:
Students

Sample output 3:
Only works for objects Integers and Strings