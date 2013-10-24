BooksLibraryMgmtSystem
======================

This project exposes rest API for library management system


Readme.txt

Design Details:-
1. Used facade design pattern.

Implementation Details:-

1. The interface exposing the required services is BookMgmtService.java and its implementation is BooksMgmtServiceImpl.java.
    (a). I have exposed the APIs using a single interface to external entities using facade design pattern.
2. The com.librarymgmt.model package contains the data models as Book.java, Author.java and Category.java.
	(a) The data model Author.java has implemented Comparable interface in order to sort the authors by name. 
3. The com.librarymgmt.action contains the action classes, that contains the actual business logic to obtain the values from DB
   using DOA layer.
4. The com.librarymgmt.doa package contains interface LibraryDbMgmt.java and its implementor LibraryDbMgmtImpl.java which interact 
   with underlying database.

5. dbDump folder contains the mysql database dump.
   (a) To install the database kindly use following command at command prompt.
       mysqldump -uroot -ppassword databasename < libraysystem_db_dump.sql.
       
How to use:-
1. Deploy the application in apache tomcat web server.
2. Hit the specific urls and see the results.

Technologies used:-
1. java 7
2. mysql
3. jersery

Improvements to be made in future:-
1. Use cache management layer for read access, so that db interactions will be reduced.
 
   

