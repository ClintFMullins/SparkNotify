```
  (                           )                       
 )\ )                   ) ( /(        )   (          
(()/(          ) (   ( /( )\())    ( /((  )\ ) (     
 /(_))`  )  ( /( )(  )\()|(_)\  (  )\())\(()/( )\ )
(_))  /(/(  )(_)|()\((_)\ _((_) )\(_))((_)/(_)|()/(  
/ __|((_)_\((_)_ ((_) |(_) \| |((_) |_ (_|_) _|)(_)) 
\__ \| '_ \) _` | '_| / /| .` / _ \  _|| ||  _| || |~~~>
|___/| .__/\__,_|_| |_\_\|_|\_\___/\__||_||_|  \_, |~~~>
     |_|                                       |__/~~~~>
```
////////////////////////////////////////////////////////
Author: Clint "Intern" Mullins
Version: 1.0
Contact: cmullins@sonalysts.com
////////////////////////////////////////////////////////

Description:
This program runs a separate Spark client alongside 
your already running Spark agent. When a batch 
file is called, SparkNotify uses the separate Spark 
client to send a unique message to a list of contacts. 
This message automatically contains the sending 
computer's ID and the time sent.

----------------------------------------------------------

Instructions:

1) In your SparkNotify folder you will see a batch file
called "sparkin.bat" This file needs some paths to change.
The second line in the file:

cd C:\\[path to SparkNotify folder]\\SparkNotify\\Notify\\bin

[path to SparkNotify folder] should be changed to where ever 
your SparkNotify Folder is located. The double backslashes are
necessary, do not forget them.

2) In order to change the list of contacts and message to be sent
you must edit the txt files in: \SparkNotify\Notify\bin
Sample conns.txt file:

cmullins,mnovak,bclown

Notice there are commas between user names, @jabber is added 
automatically, and there are no spaces. If there are spaces or 
a username is wrong there is no guarantee of delivery.
The mess.txt file is much more flexible and can say essentially 
whatever you'd like with no restrictions.

NOTE: If you wish you automatically create a mess.txt file
you must make sure it is created in the \SparkNotify\Notify\bin
folder and has the name mess.txt. If you want to create the 
file elsewhere then you can include the path in the batch file's
3rd line. You must use the double backslash in place of the single.
sample batch file 3rd line: 
java SNAlert C:\\SparkNotify\\Notify\\bin\\mess.txt conns.txt

3) Once you have the message you'd like, and the paths set up
(which you should if step one and two were followed correctly),
you can start using the program.

Go to:
C:\....\SparkNotify\SparkServer\spark\bin 
and double click the batch file. 

This will start the server and Spark client. Sign in as whomever
you'd like.

IMPORTANT: ALL USERS IN LIST MUST BE ON CONTACTS LIST OF USER SIGNED
IN; UNREGISTERED USERS FROM THE LIST WILL NOT BE ABLE TO RECEIVE THE MESSAGE
AND WILL CAUSE ERRORS.

Once you are signed in, the server and Spark client are set up.

4) Any call to the batch file "sparkin.bat" will send the message
to all the contacts on the list. You can also replicate this code
in any batch file and it will work just the same.


If there is any trouble, contact the author.
